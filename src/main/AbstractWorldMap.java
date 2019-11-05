import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected LinkedList<Animal> animals;

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

    public boolean isOccupied(Vector2d position)
    {
        if (objectAt(position) == null)
            return false;
        else
            return true;
    }
}
