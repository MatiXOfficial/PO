public class World
{
    public static void main(String[] args)
    {
        try
        {
            MoveDirection[] directions = new OptionParser().parse(args);
            int n = 5;
            IWorldMap map = new GrassField(n);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            map.run(directions);
            System.out.println(map.toString());
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex);
        }
    }
}
