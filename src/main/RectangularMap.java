import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap
{
    private Vector2d lowerLeft;
    private Vector2d upperRight;

    public RectangularMap(int width, int height)
    {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);
        animals = new LinkedList<>();
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
        return !isOccupied(position);
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }
}
