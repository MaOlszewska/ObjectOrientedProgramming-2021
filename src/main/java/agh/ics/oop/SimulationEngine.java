package agh.ics.oop;

import java.util.ArrayList;


public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.animals = new ArrayList<>();

        // dodaje zwierzaki do mapy
        for(Vector2d position : this.positions){
            Animal newAnimal = new Animal(this.map, position);
            if (this.map.place(newAnimal)) {
                animals.add( newAnimal);
            }
        }
    }

    @Override
    public void run() {
        int l = animals.size();
        int i = 0;

        for (MoveDirection direction: directions) {
            animals.get(i % l).move(direction);
            i ++;
        }
    }
}

