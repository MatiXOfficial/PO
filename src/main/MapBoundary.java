import java.util.LinkedList;

public class MapBoundary implements IPositionChangeObserver
{
    Vector2d lowerLeft;
    Vector2d upperRight;

    private LinkedList<IMapElement> ordX;
    private LinkedList<IMapElement> ordY;

    public void AddObject(IMapElement object)
    {
        if (ordX.isEmpty())
        {
            ordX.add(object);
            ordY.add(object);
        }
        else
        {
            int i = 0;
            while (i < ordX.size() && object.getPosition().x < ordX.get(i).getPosition().x)
                i++;
        }
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        ;
    }
}
