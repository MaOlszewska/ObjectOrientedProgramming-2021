package agh.ics.oop;
import java.util.ArrayList;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map,new Vector2d(2,2)));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.place(new Animal(map,new Vector2d(5,2)));
        System.out.println(map);
        map.run(directions);
        System.out.println(map);
    }
}