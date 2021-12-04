package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected LinkedHashMap<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected ArrayList<IMapElement> mapElements = new ArrayList<>();
    protected MapBoundary boundary = new MapBoundary(this);

    protected abstract Vector2d getLeftCorner();
    protected abstract Vector2d getRightCorner();


    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public Object objectAt(Vector2d position){
        return animals.get(position);  // jesli nie ma żadneog zwierzecia zwraca null
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            mapElements.add(animal);
            boundary.addElements(animal);
            return true;
        }
        else throw new IllegalArgumentException(animal.getPosition().toString() + " Is taken or outside the map");
    }


    public String toString() {return mapVisualizer.draw(getLeftCorner(), getRightCorner());}

}
