package lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest
{
    @Test public void test1()
    {
        Animal animal = new Animal();
        String args[] = {"r", "f", "r", "f", "f", "f", "l", "forward", "forward", "backward"};
        MoveDirection dirs[] = OptionParser.parse(args);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals("location: (3,0), direction: Wschod", animal.toString());
    }

    @Test public void test2()
    {
        Animal animal = new Animal();
        String args[] = {"b", "backward", "left", "f", "f", "right", "f", "f", "r", "b", "left"};
        MoveDirection dirs[] = OptionParser.parse(args);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals( "location: (0,2), direction: Polnoc", animal.toString());
    }

    @Test public void test3()
    {
        Animal animal = new Animal();
        String args[] = {"f", "f", "f", "f", "r", "r", "r", "r", "l"};
        MoveDirection dirs[] = OptionParser.parse(args);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals("location: (2,4), direction: Zachod", animal.toString());
    }

    @Test public void test4()
    {
        Animal animal = new Animal();
        String args[] = {"r", "f", "r", "f", "r", "f", "r", "f", "l", "l"};
        MoveDirection dirs[] = OptionParser.parse(args);
        for (MoveDirection dir : dirs)
        {
            animal.move(dir);
        }
        Assert.assertEquals("location: (2,2), direction: Poludnie", animal.toString());
    }
}
