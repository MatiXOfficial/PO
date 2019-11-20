abstract public class AbstractMapElement implements IMapElement
{
    protected Vector2d position;

    public AbstractMapElement(Vector2d position)
    {
        this.position = position;
    }

    public Vector2d getPosition()
    {
        return this.position;
    }

    public int compareTox(IMapElement that)
    {
        if (this.getPosition().x == that.getPosition().x)
        {
            return this.getPosition().y - that.getPosition().y;
        }
        return this.getPosition().x - that.getPosition().x;
    }

    public int compareToy(IMapElement that)
    {
        if (this.getPosition().y == that.getPosition().y)
        {
            return this.getPosition().x - that.getPosition().x;
        }
        return this.getPosition().y - that.getPosition().y;
    }
}
