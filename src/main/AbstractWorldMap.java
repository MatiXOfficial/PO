import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap
{
    //protected LinkedList<Animal> animals;
    protected Map<Vector2d, Animal> animals;
    protected LinkedList<Animal> seq;
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public AbstractWorldMap()
    {
        animals = new HashMap<>();
        seq = new LinkedList<>();
        lowerLeft = new Vector2d(0, 0);
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
            return true;
        }
        else
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
    }

    public void run(MoveDirection[] directions)
    {
        for (int i = 0; i < directions.length; i++)
        {
            Animal animal = seq.get(i % animals.size());
            animals.remove(animal.getPosition());
            animal.move(directions[i]);
            animals.put(animal.getPosition(), animal);
        }
    }

    public boolean isOccupied(Vector2d position)
    {
        return objectAt(position) != null;
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
}
