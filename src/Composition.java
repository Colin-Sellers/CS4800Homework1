import java.util.ArrayList;

public class Composition
{
    static int depth = 0;
    public static void main(String[] args)
    {
        // Creating folder system
        Folder rootDemo = new Folder("php_demo1");
        rootDemo.addFolder("Source Files");
        rootDemo.addFolder("Include Path");
        rootDemo.addFolder("Remote Files");
        Folder workingFolder = rootDemo.getFolder(0);
        workingFolder.addFolder(".phalcon");			//Folder 0
        workingFolder.addFolder("app");					//Folder 1
        workingFolder.addFolder("cache");				//Folder 2
        workingFolder.addFolder("public");				//Folder 3
        // Change working folder to app, index 1 in list
        workingFolder = workingFolder.getFolder(1);
        workingFolder.addFolder("config");
        workingFolder.addFolder("controllers");
        workingFolder.addFolder("library");
        workingFolder.addFolder("migrations");
        workingFolder.addFolder("models");
        workingFolder.addFolder("views");
        workingFolder = rootDemo.getFolder(0);
        workingFolder = workingFolder.getFolder(3);
        workingFolder.addFile(".htaccess");
        workingFolder.addFile(".gtrouter.php");
        workingFolder.addFile("index.html");

        // Print System
        printEntireSystem(rootDemo);

        // Now delete folder app and print entire system again
        workingFolder = rootDemo.getFolder(0);
        workingFolder.removeFolder(1);
        System.out.println("\nDeleted Folder 'app'\n");
        printEntireSystem(rootDemo);

        // Now delete folder public and print entire system again
        workingFolder.removeFolder(2);
        System.out.println("\nDeleted Folder 'public'\n");
        printEntireSystem(rootDemo);
    }

    // Recursive method to print entire system
    public static void printEntireSystem(Folder thisFolder)
    {
        // Print '-' to show depth
        printDepthLevel();
        // Print this folder
        System.out.println(thisFolder.getFolderName());
        depth++;
        for (int folders = 0; folders < thisFolder.folders.size(); folders++)
        {
            // Recursively call this method for next folder if any
            printEntireSystem(thisFolder.getFolder(folders));
        }
        // If no folders, print all files under this folder
        printAllFiles(thisFolder);
        // All files printed, go up one level
        depth--;
    }

    public static void printAllFiles(Folder thisFolder)
    {
        for (int files = 0; files < thisFolder.files.size(); files++)
        {
            File tempFile = thisFolder.getFile(files);
            printDepthLevel();
            System.out.println(tempFile.getName());
        }
    }

    public static void printDepthLevel()
    {
        for (int fileDepth = 0; fileDepth < depth; fileDepth++)
        {
            System.out.print("-");
        }
    }

}

class File
{
    private String fileName;

    public File(String fileName)
    {
        this.fileName = fileName;
    }

    public void setName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getName()
    {
        return fileName;
    }
}

class Folder
{
    private String folderName;
    ArrayList<Folder> folders = new ArrayList<>();
    ArrayList<File> files = new ArrayList<>();

    public Folder(String folderName)
    {
        this.folderName = folderName;
    }

    public void setFolderName(String folderName)
    {
        this.folderName = folderName;
    }

    public String getFolderName()
    {
        return folderName;
    }
    public Folder getFolder(int folder)
    {
        return folders.get(folder);
    }
    public File getFile(int file)
    {
        return files.get(file);
    }

    public void addFolder(String folderName)
    {
        folders.add(new Folder(folderName));
    }
    public void addFile(String fileName)
    {
        files.add(new File(fileName));
    }

    public void removeFolder(int folder)
    {
        folders.remove(folder);
    }
    public void removeFile(int file)
    {
        files.remove(file);
    }
}
