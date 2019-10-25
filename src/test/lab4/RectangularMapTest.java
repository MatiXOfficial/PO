package lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.*;
import agh.cs.lab4.*;
import org.junit.Assert;
import org.junit.Test;

public class RectangularMapTest
{
    @Test public void test1()
    {
        IWorldMap map = new RectangularMap(3, 4);

        map.place(new Animal(map));
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(8, 8)));
        map.place(new Animal(map, new Vector2d(2, 0)));
        Assert.assertEquals(3, ((RectangularMap)map).animals.size());

        MoveDirection dirs[] = OptionParser.parse(new String[] {"f", "b", "l", "l", "f", "f", "r", "f", "f", "r", "r", "b"});
        map.run(dirs);

        map.place(new Animal(map, new Vector2d(1, 2)));
        Assert.assertEquals(3, ((RectangularMap)map).animals.size());

        dirs = OptionParser.parse(new String[] {"l", "l", "r", "f", "f", "b", "r", "l", "f", "b"});
        map.run(dirs);

        Assert.assertEquals(new Vector2d(2, 3), ((RectangularMap)map).animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.EAST, ((RectangularMap)map).animals.get(0).getOrientation());

        Assert.assertEquals(new Vector2d(1, 3), ((RectangularMap)map).animals.get(1).getPosition());
        Assert.assertEquals(MapDirection.WEST, ((RectangularMap)map).animals.get(1).getOrientation());

        Assert.assertEquals(new Vector2d(1, 1), ((RectangularMap)map).animals.get(2).getPosition());
        Assert.assertEquals(MapDirection.NORTH, ((RectangularMap)map).animals.get(2).getOrientation());
    }

    @Test public void test2()
    {
        IWorldMap map = new RectangularMap(8, 6);

        map.place(new Animal(map, new Vector2d(2, 3)));
        map.place(new Animal(map, new Vector2d(16, 0)));
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(8, 6)));
        map.place(new Animal(map, new Vector2d(7, 5)));
        Assert.assertEquals(3, ((RectangularMap)map).animals.size());

        MoveDirection dirs[] = OptionParser.parse(new String[] {"b", "r", "b", "r", "f", "l", "f", "f", "f", "f", "f", "r", "l", "f", "b", "l", "l", "l", "b", "f", "f", "l", "f", "f"});
        map.run(dirs);

        Assert.assertEquals(new Vector2d(5, 3), ((RectangularMap)map).animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.SOUTH, ((RectangularMap)map).animals.get(0).getOrientation());

        Assert.assertEquals(new Vector2d(6, 2), ((RectangularMap)map).animals.get(1).getPosition());
        Assert.assertEquals(MapDirection.NORTH, ((RectangularMap)map).animals.get(1).getOrientation());

        Assert.assertEquals(new Vector2d(6, 3), ((RectangularMap)map).animals.get(2).getPosition());
        Assert.assertEquals(MapDirection.WEST, ((RectangularMap)map).animals.get(2).getOrientation());
    }

    @Test public void test3()
    {
        IWorldMap map = new RectangularMap(0, 0);

        map.place(new Animal(map));
        Assert.assertEquals(0, ((RectangularMap)map).animals.size());
    }
}
