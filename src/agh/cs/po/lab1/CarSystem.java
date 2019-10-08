package agh.cs.po.lab1;

import java.sql.SQLOutput;

public class CarSystem
{
    public static void main(String[] args)
    {
        System.out.println("Start");
        run(Direction.toDirs(args));
        System.out.println("Stop");
        test();
    }

    public static void test()
    {
        System.out.println("TEST");
    }

    public static void run(Direction[] dirs)
    {
        for (Direction dir : dirs)
        {
            if (dir.equals(Direction.FORWARD))
                System.out.println("Going forward...");
            else if (dir.equals(Direction.LEFT))
                System.out.println("Going backward...");
            else if (dir.equals(Direction.RIGHT))
                System.out.println("Going right...");
            else if (dir.equals(Direction.BACKWARD))
                System.out.println("Going left...");
            else
            {
                System.out.println("Wrong input!");
                break;
            }
        }
    }
}
