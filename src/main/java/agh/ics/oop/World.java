package agh.ics.oop;
import java.util.ArrayList;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("Start");
        ArrayList<Direction>List = new ArrayList<>();
        // Zmiana na wartości enum
        for(int i = 0; i < args.length; i++) {
            switch (args[i]){
                case "f":
                    List.add(Direction.FORWARD);
                    break;
                case "b":
                    List.add(Direction.BACKWARD);
                    break;
                case "r":
                    List.add(Direction.RIGHT);
                    break;
                case "l":
                    List.add(Direction.LEFT);
                    break;
            }
        }
        run(List);
        out.println("Koniec");
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

