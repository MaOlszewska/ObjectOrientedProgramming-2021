package agh.ics.oop;
import java.util.LinkedList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args){

        Animal animal = new Animal();
        out.println(animal.toString());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        out.println(animal.toString());

        OptionParser p = new OptionParser();
        String[] moves = new String[]{"l","forward","kot","left","backward"};
        for(MoveDirection m : p.parse(moves)){ animal.move(m);}
        out.println(animal.toString());
    }
}

