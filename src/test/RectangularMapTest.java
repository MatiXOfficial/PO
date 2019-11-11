import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class RectangularMapTest
{
    @Test public void test1()
    {
        IWorldMap map = new RectangularMap(3, 4);

        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(new Animal(map));
        //animals.add(new Animal(map));
        animals.add(new Animal(map, new Vector2d(1, 1)));
        //animals.add(new Animal(map, new Vector2d(8, 8)));
        animals.add(new Animal(map, new Vector2d(2, 0)));
        for (Animal animal : animals)
            map.place(animal);
        Assert.assertEquals(3, ((RectangularMap)map).getAnimalSize());

        MoveDirection dirs[] = OptionParser.parse(new String[] {"f", "b", "l", "l", "f", "f", "r", "f", "f", "r", "r", "b"});
        map.run(dirs);

        //animals.add(new Animal(map, new Vector2d(1, 2)));
        //map.place(animals.get(animals.size() - 1));
        //Assert.assertEquals(3, ((RectangularMap)map).getAnimalSize());

        dirs = OptionParser.parse(new String[] {"l", "l", "r", "f", "f", "b", "r", "l", "f", "b"});
        map.run(dirs);

        Assert.assertEquals(new Vector2d(2, 3), animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.EAST, animals.get(0).getOrientation());

        //Assert.assertEquals(new Vector2d(2, 2), animals.get(1).getPosition());
        //Assert.assertEquals(MapDirection.NORTH, animals.get(1).getOrientation());

        Assert.assertEquals(new Vector2d(1, 3), animals.get(1).getPosition());
        Assert.assertEquals(MapDirection.WEST, animals.get(1).getOrientation());

        //Assert.assertEquals(new Vector2d(8, 8), animals.get(2).getPosition());
        //Assert.assertEquals(MapDirection.NORTH, animals.get(2).getOrientation());

        Assert.assertEquals(new Vector2d(1, 1), animals.get(2).getPosition());
        Assert.assertEquals(MapDirection.NORTH, animals.get(2).getOrientation());

        //Assert.assertEquals(new Vector2d(1, 2), animals.get(5).getPosition());
        //Assert.assertEquals(MapDirection.NORTH, animals.get(5).getOrientation());
    }
}
