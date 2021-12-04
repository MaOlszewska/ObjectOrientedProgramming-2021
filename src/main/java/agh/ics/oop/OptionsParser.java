package agh.ics.oop;
import java.util.ArrayList;


public class OptionsParser {
    public MoveDirection[] parse(String[] moves){
        int len = moves.length;
        MoveDirection[] result = new MoveDirection[len];
        int i = 0;
        for(String move : moves){
            result[i] = switch (move){
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "l", "left" -> MoveDirection.LEFT;
                case "r", "right" -> MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException( move + " is not legal move specification");
            };
            i ++;
        }
        return result;
    }
}