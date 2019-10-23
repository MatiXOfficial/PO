package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal
{
    private MapDirection orientation;
    private Vector2d location;

    public MapDirection getOrientation() {return orientation;}
    public Vector2d getLocation() {return location;}

    public Animal()
    {
        orientation = MapDirection.NORTH;
        location = new Vector2d(2, 2);
    }

    public String toString()
    {
        return "location: " + location.toString() + ", direction: " + orientation.toString();
    }

    public void move(MoveDirection direction)
    {
        if (direction == MoveDirection.RIGHT)
            orientation = orientation.next();
        else if (direction == MoveDirection.LEFT)
            orientation = orientation.previous();
        else if (direction == MoveDirection.FORWARD)
        {
            location = location.add(orientation.toUnitVector());
            location = location.lowerLeft(new Vector2d(4, 4));
            location = location.upperRight(new Vector2d(0, 0));
        }
        else if (direction == MoveDirection.BACKWARD)
        {
            location = location.subtract(orientation.toUnitVector());
            location = location.lowerLeft(new Vector2d(4, 4));
            location = location.upperRight(new Vector2d(0, 0));
        }
    }
}
