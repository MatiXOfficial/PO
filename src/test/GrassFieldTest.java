import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class GrassFieldTest
{
    @Test public void test1()
    {
        IWorldMap map = new GrassField(10);

        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(new Animal(map));
        animals.add(new Animal(map));
        animals.add(new Animal(map, new Vector2d(5, 4)));
        animals.add(new Animal(map, new Vector2d(7, -2)));
        animals.add(new Animal(map, new Vector2d(7, -2)));
        for (Animal animal : animals)
            map.place(animal);
        Assert.assertEquals(3, ((GrassField)map).getAnimalSize());

        MoveDirection dirs[] = OptionParser.parse(new String[] {"f", "b", "l", "r", "r", "f", "f", "b", "f", "f", "b", "r", "l", "l", "f", "f", "b", "f", "f", "b", "l", "f", "b", "f", "r"});
        map.run(dirs);

        Assert.assertEquals(new Vector2d(3, 6), animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.EAST, animals.get(0).getOrientation());

        Assert.assertEquals(new Vector2d(2, 2), animals.get(1).getPosition());
        Assert.assertEquals(MapDirection.NORTH, animals.get(1).getOrientation());

        Assert.assertEquals(new Vector2d(4, 0), animals.get(2).getPosition());
        Assert.assertEquals(MapDirection.NORTH, animals.get(2).getOrientation());

        Assert.assertEquals(new Vector2d(5, 0), animals.get(3).getPosition());
        Assert.assertEquals(MapDirection.WEST, animals.get(3).getOrientation());

        Assert.assertEquals(new Vector2d(7, -2), animals.get(4).getPosition());
        Assert.assertEquals(MapDirection.NORTH, animals.get(4).getOrientation());
    }
}
