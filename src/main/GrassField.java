import java.util.LinkedList;

public class GrassField extends AbstractWorldMap
{
    private int n;
    private LinkedList<Grass> grasses;

    public GrassField(int n)
    {
        super();
        upperRight = new Vector2d((int)Math.sqrt(n*10), (int)Math.sqrt(n*10));
        grasses = new LinkedList<>();
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
            if (!isOccupied(pos))
            {
                Grass grass = new Grass(pos);
                grasses.add(grass);
                mapBoundary.addObject(grass);
                return;
            }
        }
    }

    public boolean canMoveTo(Vector2d position)
    {
        if (super.objectAt(position) != null)
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
}
