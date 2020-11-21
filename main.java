package ru.mirea.pr10;

enum ChairType
{
    VICTORIAN, MAGIC, MULTIFUNCTIONAL
}

abstract class Chair
{
    Chair(ChairType model, Location location)
    {
        this.model = model;
        this.location = location;
    }

    abstract void construct();

    ChairType model = null;
    Location location = null;

    ChairType getModel()
    {
        return model;
    }

    void setModel(ChairType model)
    {
        this.model = model;
    }

    Location getLocation()
    {
        return location;
    }

    void setLocation(Location location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "Client is sitting - " +model +" chair";
    }
}

class MULTIFUNCTIONALChair extends Chair
{
    MULTIFUNCTIONALChair(Location location)
    {
        super(ChairType.MULTIFUNCTIONAL, location);
        construct();
    }
    @Override
    protected void construct()
    {
        System.out.println("Connecting to MULTIFUNCTIONAL Chair");
    }
}

class VICTORIANChair extends Chair
{
    VICTORIANChair(Location location)
    {
        super(ChairType.VICTORIAN, location);
        construct();
    }
    @Override
    protected void construct()
    {
        System.out.println("Connecting to VICTORIAN Chair ");
    }
}

class MAGICChair extends Chair
{
    MAGICChair(Location location)
    {
        super(ChairType.MAGIC,location );
        construct();
    }

    @Override
    void construct()
    {
        System.out.println("Connecting to MAGIC Chair");
    }
}

enum Location
{
    DEFAULT, USA, INDIA
}

class INDIAChairFactory
{
    static Chair buildChair(ChairType model)
    {
        Chair chair = null;
        switch (model)
        {
            case VICTORIAN:
                chair = new VICTORIANChair(Location.INDIA);
                break;

            case MAGIC:
                chair = new MAGICChair(Location.INDIA);
                break;

            case MULTIFUNCTIONAL:
                chair = new MULTIFUNCTIONALChair(Location.INDIA);
                break;

            default:
                break;

        }
        return chair;
    }
}

class DefaultChairFactory
{
    public static Chair buildChair(ChairType model)
    {
        Chair chair = null;
        switch (model)
        {
            case VICTORIAN:
                chair = new VICTORIANChair(Location.DEFAULT);
                break;

            case MAGIC:
                chair = new MAGICChair(Location.DEFAULT);
                break;

            case MULTIFUNCTIONAL:
                chair = new MULTIFUNCTIONALChair(Location.DEFAULT);
                break;

            default:
                break;

        }
        return chair;
    }
}


class USAChairFactory
{
    public static Chair buildChair(ChairType model)
    {
        Chair chair = null;
        switch (model)
        {
            case VICTORIAN:
                chair = new VICTORIANChair(Location.USA);
                break;

            case MAGIC:
                chair = new MAGICChair(Location.USA);
                break;

            case MULTIFUNCTIONAL:
                chair = new MULTIFUNCTIONALChair(Location.USA);
                break;

            default:
                break;

        }
        return chair;
    }
}



class ChairFactory
{
    private ChairFactory()
    {

    }
    public static Chair buildChair(ChairType type)
    {
        Chair chair = null;
        Location location = Location.INDIA;

        switch(location)
        {
            case USA:
                chair = USAChairFactory.buildChair(type);
                break;

            case INDIA:
                chair = INDIAChairFactory.buildChair(type);
                break;

            default:
                chair = DefaultChairFactory.buildChair(type);

        }

        return chair;

    }
}

class AbstractDesign
{
    public static void main(String[] args)
    {
        System.out.println(ChairFactory.buildChair(ChairType.VICTORIAN));
        System.out.println(ChairFactory.buildChair(ChairType.MAGIC));
        System.out.println(ChairFactory.buildChair(ChairType.MULTIFUNCTIONAL));
    }
}