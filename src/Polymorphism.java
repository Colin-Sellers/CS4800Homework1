import java.util.ArrayList;

public class Polymorphism {

    public static void main(String[] args)
    {

        ArrayList<Ship> listOfShips = new ArrayList<>();
        listOfShips.add(new Ship("FishFlyer", "1995"));
        listOfShips.add(new CruiseShip("Constilation", "2010", 630));
        listOfShips.add(new CargoShip("GreenRiver", "2001", 1020));


        for (Ship thisShip : listOfShips) {
            thisShip.printShip();
        }

    }

}

class Ship
{
    private String nameOfShip;
    private String yearBuilt;

    //Constructors

    public Ship()
    {
        nameOfShip = "NaN";
        yearBuilt = "NaN";
    }
    public Ship(String shipName, String builtYear)
    {
        nameOfShip = shipName;
        yearBuilt = builtYear;
    }
    //Set methods

    public void setShipName(String shipName)
    {
        nameOfShip = shipName;
    }
    public void setYearBuilt(String builtYear)
    {
        yearBuilt = builtYear;
    }

    //Get methods

    public String getShipName()
    {
        return nameOfShip;
    }
    public String getYearBuilt()
    {
        return yearBuilt;
    }

    //Print Method

    public void printShip()
    {
        System.out.println("The ship " + getShipName() + " was built in " + getYearBuilt() + ".");
    }

}

class CruiseShip extends Ship
{
    private int maximumNumberOfPassangers;

    //Constructors

    public CruiseShip()
    {
        maximumNumberOfPassangers = 0;
    }
    public CruiseShip(Ship existingShip, int maxPassangers)
    {
        setShipName(existingShip.getShipName());
        setYearBuilt(existingShip.getYearBuilt());
        maximumNumberOfPassangers = maxPassangers;
    }
    public CruiseShip(String shipName, String yearBuilt, int maxPassangers)
    {
        setShipName(shipName);
        setYearBuilt(yearBuilt);
        maximumNumberOfPassangers = maxPassangers;
    }

    //Set methods

    public void setMaxPassangers(int maxPassangers)
    {
        maximumNumberOfPassangers = maxPassangers;
    }

    //Get methods

    public int getMaxPassangers()
    {
        return maximumNumberOfPassangers;
    }

    //Print method

    public void printShip()
    {
        System.out.println("The ship " + getShipName() + " can carry " + getMaxPassangers() + " passangers.");
    }
}

class CargoShip extends Ship
{
    private int tonnageCargoCapacity;

    //Constructors

    public CargoShip()
    {
        tonnageCargoCapacity = 0;
    }
    public CargoShip(Ship existingShip, int CargoCapacity)
    {
        setShipName(existingShip.getShipName());
        setYearBuilt(existingShip.getYearBuilt());
        tonnageCargoCapacity = CargoCapacity;
    }
    public CargoShip(String shipName, String yearBuilt, int CargoCapacity)
    {
        setShipName(shipName);
        setYearBuilt(yearBuilt);
        tonnageCargoCapacity = CargoCapacity;
    }

    //Set methods

    public void setCargoCapacity(int CargoCapacity)
    {
        tonnageCargoCapacity = CargoCapacity;
    }

    //Get methods

    public int getCargoCapacity()
    {
        return tonnageCargoCapacity;
    }

    //Print method

    public void printShip()
    {
        System.out.println("The ship " + getShipName() + " can carry " + getCargoCapacity() + " tonns of cargo");
    }
}