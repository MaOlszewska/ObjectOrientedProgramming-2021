package agh.ics.oop;
import java.util.ArrayList;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers;


    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.observers = new ArrayList<>();
    }

    public Animal(IWorldMap map){
        this();
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST ->  "<";
        };
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Vector2d getPosition() { return  this.position; }


    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    void removeObserver (IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChange(Vector2d oldPosition, Vector2d newPosition){
        observers.forEach(observer -> observer.positionChanged(oldPosition,newPosition));
    }

    public void move(MoveDirection direction){
        Vector2d newposition;
        switch (direction) {
            case RIGHT :
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD :
                newposition = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)) {
                    Vector2d oldPosition = this.position;
                    this.position = newposition;
                    positionChange(oldPosition, newposition);
                }
                break;

            case BACKWARD:
                newposition = this.position.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)) {
                    Vector2d oldPosition = this.position;
                    this.position = newposition;
                    positionChange(oldPosition, newposition);
                }
                break;
        }
    }
}