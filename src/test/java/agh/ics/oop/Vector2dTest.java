package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(1,1);
        assertTrue(v1.equals(v3));
        assertFalse(v2.equals(v1));
        assertFalse(v3.equals(v2));
    }

    @Test
    public void toStringTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(10,0);
        assertEquals(v1.toString(),"(1,1)");
        assertEquals(v2.toString(), "(10,0)");
    }

    @Test
    public void precedesTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(10,3);
        assertTrue(v1.precedes(v3));
        assertFalse(v3.precedes(v2));
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void followsTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(10,3);
        assertFalse(v1.follows(v3));
        assertTrue(v3.follows(v2));
        assertFalse(v1.follows(v2));
    }

    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(-4,5);
        Vector2d v3 = new Vector2d(10,3);
        assertEquals(v1.upperRight(v2), new Vector2d(1,5));
        assertEquals(v3.upperRight(v2), new Vector2d(10,5));
        assertEquals(v1.upperRight(v3), new Vector2d(10,3));
    }

    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(-4,5);
        Vector2d v3 = new Vector2d(10,3);
        assertEquals(v1.lowerLeft(v2), new Vector2d(-4,1));
        assertEquals(v3.lowerLeft(v2), new Vector2d(-4,3));
        assertEquals(v1.lowerLeft(v3), new Vector2d(1,1));
    }

    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(11,1);
        Vector2d v2 = new Vector2d(-4,3);
        Vector2d v3 = new Vector2d(5,-2);
        assertEquals(v1.add(v2), new Vector2d(7,4));
        assertEquals(v3.add(v2), new Vector2d(1,1));
        assertEquals(v1.add(v3), new Vector2d(16,-1));
    }

    @Test
    public void substarctTest(){
        Vector2d v1 = new Vector2d(4,7);
        Vector2d v2 = new Vector2d(-6,-2);
        Vector2d v3 = new Vector2d(1,4);
        assertEquals(v1.subtract(v2), new Vector2d(10,9));
        assertEquals(v3.subtract(v2), new Vector2d(7,6));
        assertEquals(v1.subtract(v3), new Vector2d(3,3));
    }

    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(4,7);
        Vector2d v2 = new Vector2d(-6,-2);
        Vector2d v3 = new Vector2d(1,4);
        assertEquals(v1.opposite(), new Vector2d(-4,-7));
        assertEquals(v2.opposite(), new Vector2d(6,2));
        assertEquals(v3.opposite(), new Vector2d(-1,-4));
    }
}
