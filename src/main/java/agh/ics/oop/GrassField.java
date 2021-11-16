package agh.ics.oop;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class GrassField extends AbstractWorldMap{

    private final int fieldNumber;
    private final ArrayList<Grass> grasses;

    public GrassField(int fieldNumber){
        this.fieldNumber = fieldNumber;
        this.animals = new ArrayList<>();
        this.grasses = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
        placeGrass();
    }

    public ArrayList<Animal> getAnimal(){
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
            // instanceof -sprawdzam czy zwracany obiekt z danego pola jest trawą
            while(isOccupied(new Vector2d(x,y)) && (objectAt(new Vector2d(x,y)) instanceof Grass) ); // pozniej sprawdzany warunek, czyli wykona sie przynamnije raz

            this.grasses.add(new Grass(new Vector2d(x,y))); // dodaje kępke do trawnika
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        // aby można było się tam ruszyć musi być puste pole lub być kępka trawy
        return  !isOccupied(position) || objectAt(position) instanceof Grass ;
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


    public Vector2d getLeftCorner(){
        Vector2d f = grasses.get(0).getPosition();
        Vector2d s = grasses.get(1).getPosition();
        Vector2d leftCorner = f.loweLeft(s);

        for (int i = 2; i < grasses.size(); i++){
            leftCorner = leftCorner.loweLeft(grasses.get(i).getPosition());
        }

        for (Animal animal : animals){
            leftCorner = leftCorner.loweLeft(animal.getPosition());
        }
        return leftCorner;
    }


    public Vector2d getRightCorner(){
        Vector2d f = grasses.get(0).getPosition();
        Vector2d s = grasses.get(1).getPosition();
        Vector2d rightCorner = f.upperRight(s);

        for (int i = 2; i < grasses.size(); i++){
            rightCorner = rightCorner.upperRight(grasses.get(i).getPosition());
        }

        for (Animal animal : animals){
            rightCorner = rightCorner.upperRight(animal.getPosition());
        }
        return rightCorner;
    }
}
