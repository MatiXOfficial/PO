import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver
{
    protected Map<Vector2d, Animal> animals;
    protected LinkedList<Animal> seq;
    protected MapBoundary mapBoundary;

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public AbstractWorldMap()
    {
        lowerLeft = new Vector2d(0, 0);
        animals = new HashMap<>();
        seq = new LinkedList<>();
        mapBoundary = new MapBoundary();
    }

    public int getAnimalSize()
    {
        return animals.size();
    }

    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            animals.put(animal.getPosition(), animal);
            seq.add(animal);
            mapBoundary.addObject(animal);
            animal.addObserver(this);
            animal.addObserver(mapBoundary);
            return true;
        }
        else
            throw new IllegalArgumentException(animal.getPosition() + " is not available");
    }

    public void run(MoveDirection[] directions)
    {
        for (int i = 0; i < directions.length; i++)
        {
            Animal animal = seq.get(i % animals.size());
            animal.move(directions[i]);
        }
    }

    public boolean isOccupied(Vector2d position)
    {
        return objectAt(position) != null;
    }

    public boolean canMoveTo(Vector2d position)
    {
        return !isOccupied(position);
    }

    public Object objectAt(Vector2d position)
    {
        for (Animal animal : animals.values())
        {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }

    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(mapBoundary.getLowerLeft(), mapBoundary.getUpperRight());
    }

    public void positionChanged(IMapElement animal, Vector2d oldPosition)
    {
        Vector2d newPosition = animal.getPosition();
        if (!oldPosition.equals(newPosition))
        {
            animals.remove(oldPosition);
            animals.put(newPosition, (Animal)animal);
        }
    }
}
