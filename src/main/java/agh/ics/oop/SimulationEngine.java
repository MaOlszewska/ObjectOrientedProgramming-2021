package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.animals = new ArrayList<>();

        // dodaje zwierzaki do mapy
        for(Vector2d position : positions){
            Animal newAnimal = new Animal(map,position);
            if (map.place(newAnimal)) {
                map.place(new Animal(this.map,position));
            }
        }
    }

    @Override
    public void run() {
        RectangularMap map = (RectangularMap) this.map;
        List<Animal> animals = map.getAnimals();
        int len = animals.size();
        int i = 0;


        for (MoveDirection direction: this.directions) {
            animals.get(i%len).move(direction);
            i++;

        }
    }
}

