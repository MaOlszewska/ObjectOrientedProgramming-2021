package agh.ics.oop;

public class Grass implements IMapElement {

    private final Vector2d grassPosition;

    public Grass(Vector2d grassPosition){
        this.grassPosition = grassPosition;
    }

    @Override
    public Vector2d getPosition() {
        return grassPosition;
    }

    public String toString(){
        return "*";
    }
}
