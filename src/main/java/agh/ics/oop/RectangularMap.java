package agh.ics.oop;

import java.util.ArrayList;


public class RectangularMap extends AbstractWorldMap{

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap (int height, int width){
        this.upperRight = new Vector2d( width - 1,height -1);
        this.lowerLeft = new Vector2d(0,0);
    }


    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        // sprawdzam czy pozycja miesci sie na planszy i czy nie jest zajęta
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !isOccupied(position);
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


    public Vector2d getLeftCorner(){
        return this.lowerLeft;
    }


    public Vector2d getRightCorner() {
        return this.upperRight;
    }
}
