package agh.cs.lab2;

public enum MapDirection
{
    NORTH, EAST, SOUTH, WEST;

    public String toString()
    {
        if (this == MapDirection.NORTH)
            return "N";
        else if (this == MapDirection.SOUTH)
            return "S";
        else if (this == MapDirection.WEST)
            return "Z";
        else if (this == MapDirection.EAST)
            return "W";
        else
            return null;
    }

    public MapDirection next()
    {
        if (this == MapDirection.NORTH)
            return MapDirection.EAST;
        else if (this == MapDirection.EAST)
            return MapDirection.SOUTH;
        else if (this == MapDirection.SOUTH)
            return MapDirection.WEST;
        else if (this == MapDirection.WEST)
            return MapDirection.NORTH;
        else
            return null;
    }

    public MapDirection previous()
    {
        if (this == MapDirection.NORTH)
            return MapDirection.WEST;
        else if (this == MapDirection.WEST)
            return MapDirection.SOUTH;
        else if (this == MapDirection.SOUTH)
            return MapDirection.EAST;
        else if (this == MapDirection.EAST)
            return MapDirection.NORTH;
        else
            return null;
    }

    public Vector2d toUnitVector()
    {
        if (this == MapDirection.NORTH)
            return new Vector2d(0, 1);
        else if (this == MapDirection.EAST)
            return new Vector2d(1, 0);
        else if (this == MapDirection.SOUTH)
            return new Vector2d(0, -1);
        else if (this == MapDirection.WEST)
            return new Vector2d(-1, 0);
        else
            return null;
    }


}
