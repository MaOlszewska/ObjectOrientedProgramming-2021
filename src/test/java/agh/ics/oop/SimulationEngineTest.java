package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    @Test
    public void testRun(){
        int width = 5;
        int height = 10;
        String[] moves = new String[]{"f",  "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        IWorldMap map = new RectangularMap(width, height);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(9,8) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Animal> animals = ((RectangularMap) map).getAnimals();
        assertEquals(animals.get(1).getPosition(),new Vector2d(2,4));
        assertEquals(animals.get(1).getOrientation(),MapDirection.NORTH);
        assertEquals(animals.get(0).getPosition(),new Vector2d(3,0));
        assertEquals(animals.get(0).getOrientation(), MapDirection.SOUTH);

        String[] moves1 = new String[]{"f",  "r", "r", "l", "r", "f", "r", "f", "f", "b", "r", "r", "f", "f", "l", "r"};
        MoveDirection[] directions1 = new OptionsParser().parse(moves1);
        Vector2d[] positions1 = { new Vector2d(3,0), new Vector2d(2,4)};
        IEngine engine1 = new SimulationEngine(directions1, map, positions1);
        engine1.run();
        List<Animal> animals1 = ((RectangularMap) map).getAnimals();
        assertEquals(animals1.get(0).getPosition(),new Vector2d(4,0));
        assertEquals(animals1.get(0).getOrientation(),MapDirection.EAST);
        assertEquals(animals1.get(1).getPosition(),new Vector2d(3,4));
        assertEquals(animals1.get(1).getOrientation(), MapDirection.SOUTH);
    }

}
