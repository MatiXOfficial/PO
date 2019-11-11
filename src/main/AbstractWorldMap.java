import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected LinkedList<Animal> animals;
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public AbstractWorldMap()
    {
        animals = new LinkedList<>();
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
            animals.add(animal);
            return true;
        }
        else
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
    }

    public void run(MoveDirection[] directions)
    {
        for (int i = 0; i < directions.length; i++)
        {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Vector2d position)
    {
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position)
    {
        for (Animal animal : animals)
        {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
}
