package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    int width = 10;
    int height = 10;


    @Test
    public void testcanMoveTo(){
        IWorldMap map = new RectangularMap(width, height);
        assertTrue(map.canMoveTo(new Vector2d(5,5)));
        assertFalse(map.canMoveTo(new Vector2d(10,10)));
        assertTrue(map.canMoveTo(new Vector2d(3,9)));
        assertFalse(map.canMoveTo(new Vector2d(11,12)));
    }


    @Test
    public void testPlace(){
        IWorldMap map = new RectangularMap(width, height);
        Animal newanimal1 = new Animal(map,new Vector2d(3,4));
        Animal newanimal2 = new Animal(map,new Vector2d(5,4));
        Animal newanimal3 = new Animal(map,new Vector2d(0,0));
        Animal newanimal4 = new Animal(map,new Vector2d(3,4));
        Animal newanimal5 = new Animal(map,new Vector2d(1,10));
        assertTrue(map.place(newanimal1));
        assertTrue(map.place(newanimal2));
        assertTrue(map.place(newanimal3));
        try{
            map.place(newanimal4);
        }catch(IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "(3,4) Is taken or outside the map");
        }
        try{
            map.place(newanimal5);
        }catch(IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "(1,10) Is taken or outside the map");
        }
    }


    @Test
    public void testisOccupied(){
        IWorldMap map = new RectangularMap(width, height);
        Animal newanimal1 = new Animal(map,new Vector2d(3,4));
        Animal newanimal2 = new Animal(map,new Vector2d(5,8));
        map.place(newanimal1);
        map.place(newanimal2);
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(5,8)));
        assertFalse(map.isOccupied(new Vector2d(9,7)));
    }


    @Test
    public void testobjectAt(){
        IWorldMap map = new RectangularMap(width, height);
        Animal newanimal1 = new Animal(map,new Vector2d(3,4));
        Animal newanimal2 = new Animal(map,new Vector2d(5,8));
        map.place(newanimal1);
        map.place(newanimal2);
        assertEquals(map.objectAt(new Vector2d(3,4)), newanimal1);
        assertEquals(map.objectAt(new Vector2d(5,8)), newanimal2);
        assertEquals(map.objectAt(new Vector2d(2,9)), null);
    }

}
