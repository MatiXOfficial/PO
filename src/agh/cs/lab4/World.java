package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.*;

public class World
{
    public static void main(String[] args)
    {
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        System.out.println(((RectangularMap)map).animals.get(0).toString());
        System.out.println(((RectangularMap)map).animals.get(1).toString());
    }
}
