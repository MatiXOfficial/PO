public class World
{
    public static void main(String[] args)
    {
        MoveDirection[] directions = new OptionParser().parse(args);
        int n = 1200;
        IWorldMap map = new GrassField(n);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3, 4)));
        map.run(directions);
        System.out.println(((GrassField)map).getAnimal(0).toString());
        System.out.println(((GrassField)map).getAnimal(1).toString());
        System.out.println(map.toString());
    }
}
