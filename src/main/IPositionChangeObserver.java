public interface IPositionChangeObserver
{
    void positionChanged(IMapElement object, Vector2d oldPosition, Vector2d newPosition);
}
