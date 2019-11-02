import java.util.LinkedList;

public class World
{
    public static void main(String[] args)
    {
        LinkedList<Rock> rocks = new LinkedList<>();
        rocks.add(new Rock(new Vector2d(-4, -4)));
        rocks.add(new Rock(new Vector2d(7, 7)));
        rocks.add(new Rock(new Vector2d(3, 6)));
        rocks.add(new Rock(new Vector2d(2, 0)));

        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new UnboundedMap(rocks);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        System.out.println(((UnboundedMap)map).getAnimal(0).toString());
        System.out.println(((UnboundedMap)map).getAnimal(1).toString());
        System.out.println(map.toString());
    }
}
