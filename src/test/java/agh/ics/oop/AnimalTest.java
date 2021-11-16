package agh.ics.oop;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void orientationTest(){
        Animal a = new Animal();
        String[] moves = new String[]{"l","forward","left","backward"};
        OptionsParser p = new OptionsParser();
        for(MoveDirection move : p.parse(moves)){a.move(move);}

        assertEquals(a.getOrientation(), MapDirection.SOUTH );

        String[] moves1 = new String[]{"r","forward", "b","b", "right"};
        for(MoveDirection move : p.parse(moves1)){a.move(move);}

        assertEquals(a.getOrientation(), MapDirection.NORTH);
    }

    @Test
    public void positionTest(){
        Animal a = new Animal();
        String[] moves = new String[]{"l", "f", "left", "b"};
        OptionsParser p = new OptionsParser();
        for(MoveDirection move : p.parse(moves)){a.move(move);}

        assertEquals(a.getPosition(), new Vector2d(1,3));

        String[] moves1 = new String[]{"r","forward", "b","b", "right"};
        for(MoveDirection move : p.parse(moves1)){a.move(move);}

        assertEquals(a.getPosition(), new Vector2d(2,3));
    }

    @Test
    public void mapTest(){
        Animal a = new Animal();
        String[] moves = new String[]{"f", "f", "f", "f", "f", "f", "f"};
        OptionsParser p = new OptionsParser();
        for(MoveDirection move : p.parse(moves)){a.move(move);}

        assertEquals(a.getPosition(), new Vector2d(2,4));
        assertEquals(a.getOrientation(),MapDirection.NORTH);

        String[] moves1 = new String[]{"r", "f", "f", "f", "r", "f", "f", "f", "f", "f","f"};
        for(MoveDirection move : p.parse(moves1)){a.move(move);}

        assertEquals(a.getPosition(), new Vector2d(4,0));
        assertEquals(a.getOrientation(),MapDirection.SOUTH);
    }

    @Test
    public void interpretationTest(){
        Animal a = new Animal();
        String [] moves = new String[]{"f", "chomik", "right", "Kot", "left", "l", "pies", "backward", "Rybki"};
        OptionsParser p = new OptionsParser();
        for(MoveDirection move : p.parse(moves)){a.move(move);}

        assertEquals(a.getPosition(),new Vector2d(3,3));
        assertEquals(a.getOrientation(),MapDirection.WEST);

        String [] moves1 = new String[]{"chomik", "Kot", "pies", "Rybki", "szynszyl"};
        for(MoveDirection move : p.parse(moves1)){a.move(move);}

        assertEquals(a.getPosition(),new Vector2d(3,3));
        assertEquals(a.getOrientation(),MapDirection.WEST);
    }
}
