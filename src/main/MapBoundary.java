import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver
{
    private SortedSet<IMapElement> ordX;
    private SortedSet<IMapElement> ordY;

    public MapBoundary()
    {
        ordX = new TreeSet<>(IMapElement::compareTox);
        ordY = new TreeSet<>(IMapElement::compareToy);
    }

    public Vector2d getLowerLeft()
    {
        if (ordX.isEmpty())
        {
            return new Vector2d(0, 0);
        }
        return new Vector2d(ordX.first().getPosition().x, ordY.first().getPosition().y);
    }

    public Vector2d getUpperRight()
    {
        if (ordY.isEmpty())
        {
            return new Vector2d(0, 0);
        }
        return new Vector2d(ordX.last().getPosition().x, ordY.last().getPosition().y);
    }

    public void addObject(IMapElement object)
    {
        ordX.add(object);
        ordY.add(object);
    }

    public void deleteObject(IMapElement object)
    {
        ordX.remove(object);
        ordY.remove(object);
    }

    public void updateObject(IMapElement object)
    {
        deleteObject(object);
        addObject(object);
    }

    public void positionChanged(IMapElement object, Vector2d oldPosition, Vector2d newPosition)
    {
        if (!newPosition.equals(oldPosition))
        {
            updateObject(object);
        }
    }
}
