package agh.ics.oop;

import java.util.Map;

public class Animal  {
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;


    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
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


    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newposition = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)) {
                    this.position = newposition;
                }
            }
            case BACKWARD -> {
                Vector2d newposition1 = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newposition1)) {
                    this.position = newposition1;
                }
            }
        }
    }
}