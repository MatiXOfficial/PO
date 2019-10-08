package agh.cs.po.lab1;

public enum Direction
{
    FORWARD, LEFT, RIGHT, BACKWARD, NAN;

    static Direction fromString(String arg)
    {
        if (arg.equals("f"))
            return Direction.FORWARD;
        else if (arg.equals("l"))
            return Direction.LEFT;
        else if (arg.equals("r"))
            return Direction.RIGHT;
        else if (arg.equals("b"))
            return Direction.BACKWARD;
        else
            return Direction.NAN;
    }

    public static Direction[] toDirs(String[] args)
    {
        Direction[] dirs = new Direction[args.length];
        for (int i = 0; i < args.length; i++)
        {
            dirs[i] = Direction.fromString(args[i]);
        }
        return dirs;
    }
}
