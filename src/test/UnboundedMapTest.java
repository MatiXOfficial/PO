import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class UnboundedMapTest
{
    @Test public void test1()
    {
        LinkedList<Rock> rocks = new LinkedList<>();
        rocks.add(new Rock(new Vector2d(537, -16)));  rocks.add(new Rock(new Vector2d(538, -20)));  rocks.add(new Rock(new Vector2d(539, -18)));
        rocks.add(new Rock(new Vector2d(539, -19)));  rocks.add(new Rock(new Vector2d(539, -20)));  rocks.add(new Rock(new Vector2d(540, -18)));
        rocks.add(new Rock(new Vector2d(540, -20)));  rocks.add(new Rock(new Vector2d(541, -18)));  rocks.add(new Rock(new Vector2d(541, -19)));
        rocks.add(new Rock(new Vector2d(541, -20)));  rocks.add(new Rock(new Vector2d(543, -21)));  rocks.add(new Rock(new Vector2d(544, -23)));

        IWorldMap map = new UnboundedMap(rocks);

        map.place(new Animal(map, new Vector2d(540, -19)));
        map.place(new Animal(map, new Vector2d(543, -21)));
        map.place(new Animal(map, new Vector2d(543, -22)));
        map.place(new Animal(map, new Vector2d(537, -20)));
        Assert.assertEquals(3, ((UnboundedMap)map).getAnimalSize());

        MoveDirection dirs[] = OptionParser.parse(new String[] {"r", "l", "r", "f", "f", "f", "b", "f", "f", "r", "l", "r", "r", "b", "f", "r", "l", "l", "r", "b", "f", "r", "b", "f"});
        map.run(dirs);

        Assert.assertEquals(new Vector2d(540, -19), ((UnboundedMap)map).getAnimal(0).getPosition());
        Assert.assertEquals(MapDirection.SOUTH, ((UnboundedMap)map).getAnimal(0).getOrientation());

        Assert.assertEquals(new Vector2d(539, -21), ((UnboundedMap)map).getAnimal(1).getPosition());
        Assert.assertEquals(MapDirection.EAST, ((UnboundedMap)map).getAnimal(1).getOrientation());

        Assert.assertEquals(new Vector2d(538, -21), ((UnboundedMap)map).getAnimal(2).getPosition());
        Assert.assertEquals(MapDirection.EAST, ((UnboundedMap)map).getAnimal(2).getOrientation());
    }
}
