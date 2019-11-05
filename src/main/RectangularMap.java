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

    public boolean place(Animal animal)
    {
        if (isOccupied(animal.getPosition()) || !isInTable(animal.getPosition()))
            return false;
        else
        {
            animals.add(animal);
            return true;
        }
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft, upperRight);
    }

    public void run(MoveDirection[] directions)
    {
        for (int i = 0; i < directions.length; i++)
        {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public Object objectAt(Vector2d position)
    {
        if (!isInTable(position))
            return null;
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
}
