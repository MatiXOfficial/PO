package lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import javafx.scene.shape.MoveTo;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest
{
    @Test public void test1()
    {
        Animal animal = new Animal();
        String args[] = {"r", "f", "r", "adasd", "f", "f", "f", "l", "asdasda", "forward", "forward", "backward"};
        MoveDirection dirs[] = OptionParser.parse(args);
        Assert.assertArrayEquals(new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,
                            MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD}, dirs);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals(new Vector2d(3, 0), animal.getLocation());
        Assert.assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test public void test2()
    {
        Animal animal = new Animal();
        String args[] = {"b", "backward", "left", "baskjf", "f", "f", "right", "f", "f", "r", "b", "left"};
        MoveDirection dirs[] = OptionParser.parse(args);
        Assert.assertArrayEquals(new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD,
                            MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT}, dirs);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals(new Vector2d(0, 2), animal.getLocation());
        Assert.assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test public void test3()
    {
        Animal animal = new Animal();
        String args[] = {"f", "f", "f", "f", "r", "r", "dasdsdafasdas", "r", "r", "l", "x"};
        MoveDirection dirs[] = OptionParser.parse(args);
        Assert.assertArrayEquals(new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT,
                            MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT},  dirs);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals(new Vector2d(2, 4), animal.getLocation());
        Assert.assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test public void test4()
    {
        Animal animal = new Animal();
        String args[] = {"r", "f", "r", "kdha", "f", "r", "f", "r", "f", "l", "l"};
        MoveDirection dirs[] = OptionParser.parse(args);
        Assert.assertArrayEquals(new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT,
                            MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT}, dirs);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals(new Vector2d(2, 2), animal.getLocation());
        Assert.assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }
}
