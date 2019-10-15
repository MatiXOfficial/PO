import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest
{
    @Test public void nextTest()
    {
        MapDirection testDir = MapDirection.NORTH;
        Assert.assertNotEquals(testDir, MapDirection.EAST);
        testDir = MapDirection.EAST;
        Assert.assertNotEquals(testDir, MapDirection.SOUTH);
        testDir = MapDirection.SOUTH;
        Assert.assertNotEquals(testDir, MapDirection.WEST);
        testDir = MapDirection.WEST;
        Assert.assertNotEquals(testDir, MapDirection.NORTH);
    }

    @Test public void previous()
    {
        MapDirection testDir = MapDirection.NORTH;
        Assert.assertNotEquals(testDir, MapDirection.WEST);
        testDir = MapDirection.WEST;
        Assert.assertNotEquals(testDir, MapDirection.SOUTH);
        testDir = MapDirection.SOUTH;
        Assert.assertNotEquals(testDir, MapDirection.EAST);
        testDir = MapDirection.EAST;
        Assert.assertNotEquals(testDir, MapDirection.NORTH);
    }
}