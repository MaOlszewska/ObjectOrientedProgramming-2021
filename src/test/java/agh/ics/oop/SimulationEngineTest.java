package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimulationEngineTest {

    @Test
    public void testRun(){
        int width = 10;
        int height = 10;
        String[] moves = new String[]{"f",  "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        RectangularMap map = new RectangularMap(width, height);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<Animal> animals = map.getAnimals();
        assertEquals(animals.get(1).getPosition(),new Vector2d(2,9));
        assertEquals(animals.get(1).getOrientation(),MapDirection.NORTH);
        assertEquals(animals.get(0).getPosition(),new Vector2d(3,0));
        assertEquals(animals.get(0).getOrientation(), MapDirection.SOUTH);


    }

}
