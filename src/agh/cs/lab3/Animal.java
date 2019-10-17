package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal
{
    private MapDirection orientation;
    private Vector2d location;

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
            if (orientation == MapDirection.NORTH)
                location = new Vector2d(location.x, Math.min(location.y + 1, 4));
            else if (orientation == MapDirection.WEST)
                location = new Vector2d(Math.max(location.x - 1, 0), location.y);
            else if (orientation == MapDirection.SOUTH)
                location = new Vector2d(location.x, Math.max(location.y - 1, 0));
            else // if (orientation == MapDirection.EAST)
                location = new Vector2d(Math.min(location.x + 1, 4), location.y);
        }
        else if (direction == MoveDirection.BACKWARD)
        {
            if (orientation == MapDirection.NORTH)
                location = new Vector2d(location.x, Math.max(location.y - 1, 0));
            else if (orientation == MapDirection.WEST)
                location = new Vector2d(Math.min(location.x + 1, 4), location.y);
            else if (orientation == MapDirection.SOUTH)
                location = new Vector2d(location.x, Math.min(location.y + 1, 4));
            else // if (orientation == MapDirection.EAST)
                location = new Vector2d(Math.max(location.x - 1, 0), location.y);
        }
    }
}
