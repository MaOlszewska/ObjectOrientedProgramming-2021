package agh.ics.oop;

import java.net.URL;

public interface IMapElement {
    /**
     *
     *
     * @return Vectord2d with object position
     */
    Vector2d getPosition();
    String getPath(IMapElement object);
}

