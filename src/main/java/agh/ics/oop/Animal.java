package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;

    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }

    public String toString(){
        return "Position: " + this.position + " Orientation: " + this.orientation;
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Vector2d getPosition() { return  this.position; }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT:
                this.orientation = this.orientation.next();
                break;

            case LEFT:
                this.orientation = this.orientation.previous();
                break;

            case FORWARD:
                if(this.position.add(this.orientation.toUnitVector()).precedes(new Vector2d(4,4))
                        && this.position.add(this.orientation.toUnitVector()).follows(new Vector2d(0,0))){
                    this.position = this.position.add(this.orientation.toUnitVector());
                }
                break;

            case BACKWARD:
                if(this.position.subtract(this.orientation.toUnitVector()).precedes(new Vector2d(4,4))
                        && this.position.subtract(this.orientation.toUnitVector()).follows(new Vector2d(0,0))){
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                }
                break;
        }
    }
}