import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected LinkedList<Animal> animals;

    public AbstractWorldMap()
    {
        animals = new LinkedList<>();
    }

    public Animal getAnimal(int pos)
    {
        if (pos >= animals.size())
            return null;
        return animals.get(pos);
    }

    public int getAnimalSize()
    {
        return animals.size();
    }

    public boolean place(Animal animal)
    {
        if (!canMoveTo(animal.getPosition()))
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
