import java.util.LinkedList;

public class Animal extends AbstractMapElement
{
    private MapDirection orientation;
    private IWorldMap map;
    private LinkedList<IPositionChangeObserver> observers;

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        super(initialPosition);
        this.map = map;
        this.orientation = MapDirection.NORTH;
        observers = new LinkedList<>();
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
            {
                Vector2d oldPosition = position;
                position = tempPosition;
                positionChanged(oldPosition);
            }
        }
        else if (direction == MoveDirection.BACKWARD)
        {
            Vector2d tempPosition = position.subtract(orientation.toUnitVector());
            if (map.canMoveTo(tempPosition))
            {
                Vector2d oldPosition = position;
                position = tempPosition;
                positionChanged(oldPosition);
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer)
    {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition)
    {
        for (IPositionChangeObserver observer : observers)
        {
            observer.positionChanged(this, oldPosition);
        }
    }
}
