package agh.ics.oop;
import java.util.ArrayList;


public class OptionsParser{

    public static MoveDirection[] parse(Object[] list) {
        int len = list.length;
        MoveDirection[] result = new MoveDirection[len];
        int i =0;
        for(Object element : list){
            if ("f".equals(element) || "forward".equals(element)) {
                result[i] = (MoveDirection.FORWARD);
            } else if ("b".equals(element) || "backward".equals(element)) {
                result[i] = (MoveDirection.BACKWARD);
            } else if ("l".equals(element) || "left".equals(element)) {
                result[i] = (MoveDirection.LEFT);
            } else if ("r".equals(element) || "right".equals(element)) {
                result[i] = (MoveDirection.RIGHT);
            } else {
                i -= 1;
                throw new IllegalArgumentException(element + " is not legal move specification");
            }
            i+=1;
        }
        return result;
    }
}