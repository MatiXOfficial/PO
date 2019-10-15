public enum MapDirection
{
    NORTH, EAST, SOUTH, WEST;

    public String toString()
    {
        if (this == null)
            return "ERROR";
        else if (this == MapDirection.NORTH)
            return "Polnoc";
        else if (this == MapDirection.SOUTH)
            return "Poludnie";
        else if (this == MapDirection.WEST)
            return "Zachod";
        else //if (dir == MapDirection.EAST)
            return "Wschod";
    }

    public MapDirection next()
    {
        if (this == null)
            return null;
        else if (this == MapDirection.NORTH)
            return MapDirection.EAST;
        else if (this == MapDirection.EAST)
            return MapDirection.SOUTH;
        else if (this == MapDirection.SOUTH)
            return MapDirection.WEST;
        else //if (dir == MapDirection.WEST)
            return MapDirection.NORTH;
    }

    public MapDirection previous()
    {
        if (this == null)
            return null;
        else if (this == MapDirection.NORTH)
            return MapDirection.WEST;
        else if (this == MapDirection.WEST)
            return MapDirection.SOUTH;
        else if (this == MapDirection.SOUTH)
            return MapDirection.EAST;
        else //if (dir == MapDirection.EAST)
            return MapDirection.NORTH;
    }

    public Vector2d toUnitVector(MapDirection dir)
    {
        if (this == null)
            return null;
        else if (this == MapDirection.NORTH)
            return new Vector2d(0, 1);
        else if (this == MapDirection.EAST)
            return new Vector2d(-1, 0);
        else if (this == MapDirection.SOUTH)
            return new Vector2d(0, -1);
        else //if (this == MapDirection.WEST)
            return new Vector2d(1, 0);
    }


}
