package agh.ics.oop;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;


public class GrassField extends AbstractWorldMap{

    private final int fieldNumber;
    private final LinkedHashMap<Vector2d, Grass> grass;

    public GrassField(int fieldNumber){
        this.fieldNumber = fieldNumber;
        this.grass = new LinkedHashMap<>();
        placeGrass();
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
            Grass tuft = new Grass(new Vector2d(x,y));
            mapElements.add(tuft);
            this.grass.put(tuft.getPosition(), tuft); // dodaje kępke do trawnika
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // aby można było się tam ruszyć musi być puste pole lub być kępka trawy
        return  !isOccupied(position) || objectAt(position) instanceof Grass ;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object =  super.objectAt(position);
        if (object == null){
            return grass.get(position);
        }
        else return object;
    }

    public Vector2d getLeftCorner(){
        Vector2d leftcorner = mapElements.get(0).getPosition();

        for(IMapElement element : mapElements){
            leftcorner = leftcorner.lowerLeft(element.getPosition());
        }
        return leftcorner;
    }


    public Vector2d getRightCorner(){
        Vector2d rightcorner = mapElements.get(0).getPosition();

        for(IMapElement element : mapElements){
            rightcorner = rightcorner.upperRight(element.getPosition());
        }
        return rightcorner;
    }
}
