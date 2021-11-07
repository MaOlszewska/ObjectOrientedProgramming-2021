package agh.ics.oop;
import java.util.ArrayList;


public class OptionParser {
    public ArrayList<MoveDirection> parse(String[] moves){
        ArrayList<MoveDirection> result = new ArrayList<>();
        for(String move : moves){
            switch (move){
                case "f","forward":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "r","right":
                    result.add(MoveDirection.RIGHT);
                    break;
                case "b","backward":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "l","left":
                    result.add(MoveDirection.LEFT);
                    break;
                default:
                    continue;
                    //System.out.println(move + " - Nie ma takiego kierunku  " );
            }
        }
        return result;
    }
}