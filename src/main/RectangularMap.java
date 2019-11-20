import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap
{
    private Vector2d upperRight;

    public RectangularMap(int width, int height)
    {
        super();
        upperRight = new Vector2d(width, height);
    }

    private boolean isInTable(Vector2d position)
    {
        if (position.x < lowerLeft.x || position.x >= upperRight.x || position.y < lowerLeft.y || position.y >= upperRight.y)
            return false;
        return true;
    }

    public boolean canMoveTo(Vector2d position)
    {
        if (!isInTable(position))
            return false;
        return super.canMoveTo(position);
    }
}
