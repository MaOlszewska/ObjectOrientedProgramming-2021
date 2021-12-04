package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private final SortedSet<IMapElement> xSet;
    private final SortedSet<IMapElement> ySet;
    private final IWorldMap map;

    public MapBoundary(IWorldMap map){
        this.xSet = new TreeSet<>(new xComparator());
        this.ySet = new TreeSet<>(new yComparator());
        this.map = map;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = (IMapElement) map.objectAt(newPosition);
        xSet.remove(element);
        ySet.remove(element);
        xSet.add(element);
        ySet.add(element);
    }

    public void addElements(IMapElement element){  //dodaje elemnt do obydwu zbiorów
        xSet.add(element);
        ySet.add(element);
    }

    public Vector2d getRightCorner(){ // Prawy górny róg skałda się z największego x w zbiorze x i  najwiekszego y w zbiorze y
        return xSet.last().getPosition().upperRight(ySet.last().getPosition());
    }

    public Vector2d getLeftCorner(){  // analogicznie jak wyżej tylko najmniejsze
        return xSet.first().getPosition().lowerLeft(ySet.first().getPosition());
    }
}
class xComparator implements Comparator<IMapElement> {

    @Override
    public int compare(IMapElement o1, IMapElement o2) {
        Vector2d o1Position = o1.getPosition();
        Vector2d o2Position = o2.getPosition();

        if (o1Position.x > o2Position.x) return 1; // jeśli 1 to pierwszy element jest większy, jeśli -1 to drugi
        else if(o1Position.x == o2Position.x){
            if(o1Position.y > o2Position.y || (o1 instanceof Animal && o2 instanceof  Grass)) return 1;
            else if(o1Position.y < o2Position.y || (o1 instanceof Grass && o2 instanceof Animal)) return -1;
            else return 0;
        }
        return -1;
    }
}

class yComparator implements Comparator<IMapElement> {

    @Override
    public int compare(IMapElement o1, IMapElement o2) {
        Vector2d o1Position = o1.getPosition();
        Vector2d o2Position= o2.getPosition();

        if (o1Position.y > o2Position.y) return 1;
        else if(o1Position.y == o2Position.y){
            if(o1Position.x > o2Position.x || (o1 instanceof Animal && o2 instanceof  Grass)) return 1;
            else if(o1Position.x < o2Position.x || (o1 instanceof Grass && o2 instanceof Animal)) return -1;
            else return 0;
        }
        return -1;
    }
}
