package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    IWorldMap map = new GrassField(10);
    Animal cat  = new Animal(map, new Vector2d(1,1));
    Animal dog  = new Animal();
    Animal fly  = new Animal(map, new Vector2d(5,5));
    Animal worm = new Animal(map,new Vector2d(3,4));



    @Test
    public void testcanMoveTo(){
        map.place(cat);
        map.place(dog);
        map.place(fly);

        assertTrue(map.canMoveTo(new Vector2d(2,5)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
        assertTrue(map.canMoveTo((new Vector2d(6,1))));
    }

    @Test
    public void testPlace(){
        assertTrue(map.place(cat));
        assertTrue(map.place(dog));
        try{
            map.place(new Animal(map, new Vector2d(1,1)));
        }catch(IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "(1,1) Is taken or outside the map");
        }
       try{
           map.place(new Animal(map, new Vector2d(2,2)));
       }catch(IllegalArgumentException ex){
           assertEquals(ex.getMessage(),"(2,2) Is taken or outside the map");
       }
    }

    @Test
    public void testidOccupied(){
        map.place(cat);
        map.place(dog);
        map.place(fly);

        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertTrue(map.isOccupied(new Vector2d(5,5)));
    }

    @Test
    public void testobjectAt(){
        map.place(cat);
        map.place(dog);
        map.place(fly);

        assertEquals(map.objectAt(new Vector2d(2,2)), dog);
        assertEquals(map.objectAt(new Vector2d(5,5)), fly);
        assertEquals(map.objectAt(new Vector2d(0,0)), null );
        assertEquals(map.objectAt(new Vector2d(1,1)), cat);
    }

    @Test
    public void testRun(){
        String[] moves = new String[]{"f",  "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        Vector2d[] positions = {dog.getPosition(), worm.getPosition()};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();

        assertTrue(map.objectAt(new Vector2d(2, -1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3, 7)) instanceof Animal);

    }
}
