import java.util.LinkedList;

public class GrassField extends AbstractWorldMap
{
    private int n;
    private LinkedList<Grass> grasses;

    public GrassField(int n)
    {
        super();
        upperRight = new Vector2d((int)Math.sqrt(n*10), (int)Math.sqrt(n*10));
        grasses = new LinkedList<Grass>();
        for (int i = 0; i < n; i++)
            addGrass(lowerLeft, upperRight);
    }

    private void addGrass(Vector2d lowerLeft, Vector2d upperRight)
    {
        while(true)
        {
            int x = lowerLeft.x + (int) (Math.random() * (upperRight.x - lowerLeft.x));
            int y = lowerLeft.y + (int) (Math.random() * (upperRight.y - lowerLeft.y));
            Vector2d pos = new Vector2d(x, y);
            if (objectAt(pos) == null)
            {
                grasses.add(new Grass(pos));
                return;
            }
        }
    }

    public boolean canMoveTo(Vector2d position)
    {
        if (!(super.objectAt(position) == null))
            return false;

        for (int i = 0; i < grasses.size(); i++)
        {
            if (grasses.get(i).getPosition().equals(position))
            {
                addGrass(lowerLeft, upperRight);
                grasses.remove(i);
                break;
            }
        }
        return true;
    }

    public Object objectAt(Vector2d position)
    {
        Object animal = super.objectAt(position);
        if (animal != null)
            return animal;

        for (Grass grass : grasses)
        {
            if (grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftString(), upperRightString());
    }

    private Vector2d lowerLeftString()
    {
        Vector2d result = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals)
        {
            result = result.lowerLeft(animal.getPosition());
        }

        for (Grass grass : grasses)
        {
            result = result.lowerLeft(grass.getPosition());
        }
        return result;
    }

    private Vector2d upperRightString()
    {
        Vector2d result = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal animal : animals)
        {
            result = result.upperRight(animal.getPosition());
        }

        for (Grass grass : grasses)
        {
            result = result.upperRight(grass.getPosition());
        }
        return result;
    }
}
