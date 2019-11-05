import java.util.LinkedList;

public class UnboundedMap extends AbstractWorldMap
{
    public LinkedList<Rock> rocks;

    public UnboundedMap(LinkedList<Rock> rocks)
    {
        this.rocks = rocks;
        animals = new LinkedList<>();
    }

    public UnboundedMap()
    {
        this.rocks = new LinkedList<>();
        animals = new LinkedList<>();
    }

    public boolean canMoveTo(Vector2d position)
    {
        return !isOccupied(position);
    }

    public boolean place(Animal animal)
    {
        if (isOccupied(animal.getPosition()))
            return false;
        else
        {
            animals.add(animal);
            return true;
        }
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
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return animal;
        }

        for (Rock rock : rocks)
        {
            if (rock.getPosition().equals(position))
                return rock;
        }
        return null;
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft(), upperRight());
    }

    public Vector2d lowerLeft()
    {
        Vector2d result = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals)
        {
            result = result.lowerLeft(animal.getPosition());
        }

        for (Rock rock : rocks)
        {
            result = result.lowerLeft(rock.getPosition());
        }
        return result;
    }

    public Vector2d upperRight()
    {
        Vector2d result = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal animal : animals)
        {
            result = result.upperRight(animal.getPosition());
        }

        for (Rock rock : rocks)
        {
            result = result.upperRight(rock.getPosition());
        }
        return result;
    }
}
