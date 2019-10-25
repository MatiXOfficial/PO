package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public MapDirection getOrientation() {return orientation;}
    public Vector2d getPosition() {return position;}

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        position = initialPosition;
        orientation = MapDirection.NORTH;
        map.place(this);
    }

    public Animal(IWorldMap map)
    {
        this(map, new Vector2d(2, 2));
    }

    public String toString()
    {
        return "location: " + position.toString() + ", orientation: " + orientation.toString();
    }

    public void move(MoveDirection direction)
    {
        if (direction == MoveDirection.RIGHT)
            orientation = orientation.next();
        else if (direction == MoveDirection.LEFT)
            orientation = orientation.previous();
        else if (direction == MoveDirection.FORWARD)
        {
            Vector2d tempPosition = position.add(orientation.toUnitVector());
            if (!map.isOccupied(tempPosition))
                position = tempPosition;
        }
        else if (direction == MoveDirection.BACKWARD)
        {
            Vector2d tempPosition = position.subtract(orientation.toUnitVector());
            if (!map.isOccupied(tempPosition))
                position = tempPosition;
        }
    }
}
