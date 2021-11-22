package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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

        assertTrue(map.objectAt(new Vector2d(2, 0)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3, 7)) instanceof Animal);
    }

}
