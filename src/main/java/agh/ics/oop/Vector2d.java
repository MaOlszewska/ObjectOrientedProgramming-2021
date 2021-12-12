package agh.ics.oop;
import java.util.Objects;


public class Vector2d {

    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }


    public boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) return true;
        else return false;
    }

    public boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) return true;
        else return false;
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(other.x, this.x), Math.max(other.y, this.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(other.x, this.x), Math.min(other.y, this.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    public Vector2d opposite() {
        return new Vector2d((-1) * this.x, (-1) * this.y);
    }



}