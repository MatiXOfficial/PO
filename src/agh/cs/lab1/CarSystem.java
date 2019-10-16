package agh.cs.lab1;

public class CarSystem
{
    public static void main(String[] args)
    {
        System.out.println("Start");
        run(Direction.toDirs(args));
        System.out.println("Stop");
    }

    public static void run(Direction[] dirs)
    {
        for (Direction dir : dirs)
        {
            if (dir == Direction.FORWARD)
                System.out.println("Going forward...");
            else if (dir == Direction.LEFT)
                System.out.println("Going backward...");
            else if (dir == Direction.RIGHT)
                System.out.println("Going right...");
            else if (dir == Direction.BACKWARD)
                System.out.println("Going left...");
            else
            {
                System.out.println("Wrong input!");
                break;
            }
        }
    }
}
