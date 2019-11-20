public interface IMapElement
{
    Vector2d getPosition();

    int compareTox(IMapElement that);

    int compareToy(IMapElement that);
}
