import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest
{
    @Test public void testEquals()
    {
        Vector2d obj = new Vector2d(1, 10);
        Vector2d obj2 = obj;
        Assert.assertTrue(obj.equals(obj2));

        Object obj3 = new Object();
        Assert.assertFalse(obj.equals(obj3));

        obj2 = new Vector2d(1, 10);
        Assert.assertTrue(obj.equals(obj2));

        obj2 = new Vector2d(2, 9);
        Assert.assertFalse(obj.equals(obj2));
    }

    @Test public void testToString()
    {
        Vector2d obj = new Vector2d(1, 2);
        String s = obj.toString();
        Assert.assertEquals("(1,2)", s);
    }

    @Test public void testPrecedes()
    {
        Vector2d obj = new Vector2d(0, 0);
        Assert.assertTrue(obj.precedes(new Vector2d(1, 0)));
        Assert.assertTrue(obj.precedes(new Vector2d(1, 1)));
        Assert.assertTrue(obj.precedes(new Vector2d(0, 1)));
        Assert.assertFalse(obj.precedes(new Vector2d(-1, 1)));
        Assert.assertFalse(obj.precedes(new Vector2d(-1, 0)));
        Assert.assertFalse(obj.precedes(new Vector2d(-1, -1)));
        Assert.assertFalse(obj.precedes(new Vector2d(0, -1)));
        Assert.assertFalse(obj.precedes(new Vector2d(1, -1)));
        Assert.assertTrue(obj.precedes(new Vector2d(0, 0)));
    }

    @Test public void testFollows()
    {
        Vector2d obj = new Vector2d(0, 0);
        Assert.assertFalse(obj.follows(new Vector2d(1, 0)));
        Assert.assertFalse(obj.follows(new Vector2d(1, 1)));
        Assert.assertFalse(obj.follows(new Vector2d(0, 1)));
        Assert.assertFalse(obj.follows(new Vector2d(-1, 1)));
        Assert.assertTrue(obj.follows(new Vector2d(-1, 0)));
        Assert.assertTrue(obj.follows(new Vector2d(-1, -1)));
        Assert.assertTrue(obj.follows(new Vector2d(0, -1)));
        Assert.assertFalse(obj.follows(new Vector2d(1, -1)));
        Assert.assertTrue(obj.follows(new Vector2d(0, 0)));
    }

    @Test
    public void testUpperRight()
    {
        Vector2d obj = new Vector2d(0, 0);
        Assert.assertEquals(obj.upperRight(new Vector2d(1, -1)), new Vector2d(1, 0));
        Assert.assertEquals(obj.upperRight(new Vector2d(-1, 1)), new Vector2d(0, 1));
    }

    @Test public void testLowerLeft()
    {
        Vector2d obj = new Vector2d(0, 0);
        Assert.assertEquals(obj.lowerLeft(new Vector2d(1, -1)), new Vector2d(0, -1));
        Assert.assertEquals(obj.lowerLeft(new Vector2d(-1, 1)), new Vector2d(-1, 0));
    }

    @Test public void testAdd()
    {
        Vector2d obj = new Vector2d(0, 0);
        Vector2d obj2 = new Vector2d(1, 1);
        Assert.assertEquals(obj.add(obj2), new Vector2d(1, 1));
    }

    @Test public void testSubtract()
    {
        Vector2d obj = new Vector2d(0, 0);
        Vector2d obj2 = new Vector2d(1, 1);
        Assert.assertEquals(obj.subtract(obj2), new Vector2d(-1, -1));
        Assert.assertEquals(obj2.subtract(obj), new Vector2d(1, 1));
    }

    @Test public void testOpposite()
    {
        Vector2d obj = new Vector2d(0, 0);
        Vector2d obj2 = new Vector2d(1, 1);
        Assert.assertEquals(obj.opposite(), new Vector2d(0, 0));
        Assert.assertEquals(obj2.opposite(), new Vector2d(-1, -1));
    }
}
