package agh.ics.oop;
import java.util.ArrayList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args){
    Vector2d position1 = new Vector2d(1,2);
    out.println(position1);
    Vector2d position2 = new Vector2d(-2,1);
    out.println(position2);
    out.println(position1.add(position2));
    MapDirection s = MapDirection.SOUTH;
    out.println(s.toUnitVector());
    }

    static void run(ArrayList<Direction> arguments){
        for(Direction argument : arguments) {
            switch (argument){
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }
}

