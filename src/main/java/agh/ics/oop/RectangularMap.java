package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap (int height, int width){
        this.upperRight = new Vector2d( width - 1,height -1);
        this.lowerLeft = new Vector2d(0,0);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // sprawdzam czy pozycja miesci sie na planszy i czy nie jest zajęta
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !isOccupied(position);
    }

    public Vector2d getLeftCorner(){
        return this.lowerLeft;
    }

    public Vector2d getRightCorner() {
        return this.upperRight;
    }
}
