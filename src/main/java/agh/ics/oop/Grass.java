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

    public String toString() {return "*";}

    @Override
    public String getPath(IMapElement object) {
        return "src/main/resources/grass.png";
    }
}
