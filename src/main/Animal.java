public class Animal
{
    protected Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        map.place(this);
    }

    public Animal(IWorldMap map)
    {
        this(map, new Vector2d(2, 2));
    }

    public Vector2d getPosition()
    {
        return this.position;
    }

    public MapDirection getOrientation() {return orientation;}

    public String toString()
    {
        return orientation.toString();
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
            if (map.canMoveTo(tempPosition))
                position = tempPosition;
        }
        else if (direction == MoveDirection.BACKWARD)
        {
            Vector2d tempPosition = position.subtract(orientation.toUnitVector());
            if (map.canMoveTo(tempPosition))
                position = tempPosition;
        }
    }
}
