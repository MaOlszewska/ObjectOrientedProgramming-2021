package agh.ics.oop;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class GrassField implements IWorldMap{

    private final int fieldNumber;
    private final ArrayList<Animal> animals;
    private final ArrayList<Grass> grasses;
    private final MapVisualizer mapVisualizer;

    public GrassField(int fieldNumber){
        this.fieldNumber = fieldNumber;
        this.animals = new ArrayList<>();
        this.grasses = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
        placeGrass();
    }


    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }


    private void placeGrass(){
        Random random = new Random();
        int x ;
        int y ;
        for(int i = 0; i < fieldNumber; i++){
            do{ //  najpierw instrukcja do wykonania
            x = random.nextInt((int)Math.sqrt(this.fieldNumber * 10));
            y = random.nextInt((int)Math.sqrt(this.fieldNumber * 10));
            }
            while(isOccupied(new Vector2d(x,y)) && (objectAt(new Vector2d(x,y)) instanceof Grass) ); // pozniej sprawdzany warunek, czyli wykona sie przynamnije raz
            this.grasses.add(new Grass(new Vector2d(x,y))); // dodaje kępke do trawnika
        }
    }


    @Override
    public void run(MoveDirection[] directions) {
        ArrayList<Animal> animals = this.animals;
        int l = animals.size();
        int i = 0;

        for (MoveDirection direction : directions) {
            animals.get(i % l).move(direction);
            i++;
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        // aby można było się tam ruszyć musi być puste pole lub być kępka trawy
        return  !isOccupied(position) || objectAt(position) instanceof Grass ;
    }


    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        for(Grass grass :grasses){
            if(grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }

        for(Grass grass : grasses){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }


    public String toString(){
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;


        for(Animal animal :animals){
            if(animal.getPosition().x > maxX) maxX = animal.getPosition().x;
            else if(animal.getPosition().x < minX) minX = animal.getPosition().x;
            if(animal.getPosition().y > maxY) maxY = animal.getPosition().y;
            else if(animal.getPosition().y < minY) minY = animal.getPosition().y;
        }

        for(Grass grass :grasses){
            if(grass.getPosition().x > maxX) maxX = grass.getPosition().x;
            else if(grass.getPosition().x < minX) minX = grass.getPosition().x;
            if(grass.getPosition().y > maxY) maxY = grass.getPosition().y;
            else if(grass.getPosition().y < minY) minY = grass.getPosition().y;

        }

        return mapVisualizer.draw(new Vector2d(minX,minY), new Vector2d(maxX, maxY));

    }
}
