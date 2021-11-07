package agh.ics.oop;

import java.util.ArrayList;


public class RectangularMap implements IWorldMap {
    private final int height;
    private final int width;
    private ArrayList<Animal> animals = new ArrayList<>();
    private Vector2d leftcorner;
    private Vector2d rightcorner;
    private  MapVisualizer mapVisualizer;

    public RectangularMap (int height, int width){
        this.height = height;
        this.width = width;
        this.rightcorner = new Vector2d( width - 1,height -1);
        this.leftcorner = new Vector2d(0,0);
        this.mapVisualizer = new MapVisualizer(this);
    }
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // sprawdzam czy pozycja miesci sie na planszy i czy nie jest zajęta
        return position.follows(this.leftcorner) && position.precedes(this.rightcorner) && !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        // sprawdzam czy dana pozycja jest już zajęta
        for(Animal animal : animals){
            if (animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        // Sprawdzam czy mogę dodać nowe zwierze
        if (!this.canMoveTo(animal.getPosition())) return false;
        this.animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position){
        // zwracam zwierze któe znajduje się na danej pozycji
        for(Animal animal : animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        return mapVisualizer.draw(this.leftcorner, this.rightcorner);
    }


}
