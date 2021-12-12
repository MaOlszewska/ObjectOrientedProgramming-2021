package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;


public class SimulationEngine implements  Runnable {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private final ArrayList<Animal> animals;
    private final App application;
    private final int moveDealy;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions, App application, int moveDealy) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.animals = new ArrayList<>();
        this.application = application;
        this.moveDealy = moveDealy;

        // dodaje zwierzaki do mapy
        for (Vector2d position : this.positions) {
            Animal newAnimal = new Animal(this.map, position);
            if (this.map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }
    }


    @Override
    public void run() {
        int l = animals.size();
        int i = 0;

        for (MoveDirection direction : directions) {
            try{
                Thread.sleep(moveDealy);
                Animal animal = animals.get(i % l);
                animal.move(direction);
                application.drawMap();
                i++;
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }

        }
    }
}

