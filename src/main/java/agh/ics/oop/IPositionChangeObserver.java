package agh.ics.oop;

public interface IPositionChangeObserver {
    /**
     *  Delete oldPosition and add newPosition.
     */

    void positionChanged(Vector2d oldPosition, Vector2d newPosition);


}
