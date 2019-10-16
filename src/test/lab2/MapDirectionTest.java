package lab2;

import agh.cs.lab2.MapDirection;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest
{
    @Test public void nextTest()
    {
        MapDirection testDir = MapDirection.NORTH;
        Assert.assertEquals(testDir.next(), MapDirection.EAST);
        testDir = MapDirection.EAST;
        Assert.assertEquals(testDir.next(), MapDirection.SOUTH);
        testDir = MapDirection.SOUTH;
        Assert.assertEquals(testDir.next(), MapDirection.WEST);
        testDir = MapDirection.WEST;
        Assert.assertEquals(testDir.next(), MapDirection.NORTH);
    }

    @Test public void previous()
    {
        MapDirection testDir = MapDirection.NORTH;
        Assert.assertEquals(testDir.previous(), MapDirection.WEST);
        testDir = MapDirection.WEST;
        Assert.assertEquals(testDir.previous(), MapDirection.SOUTH);
        testDir = MapDirection.SOUTH;
        Assert.assertEquals(testDir.previous(), MapDirection.EAST);
        testDir = MapDirection.EAST;
        Assert.assertEquals(testDir.previous(), MapDirection.NORTH);
    }
}