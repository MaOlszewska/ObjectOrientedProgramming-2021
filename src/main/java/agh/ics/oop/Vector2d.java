package agh.ics.oop;
import java.util.Objects;


class Vector2d {


    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
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
        Vector2d object = new Vector2d(Math.max(other.x, this.x), Math.max(other.y, this.y));
        return object;
    }

    public Vector2d loweLeft(Vector2d other) {
        Vector2d object = new Vector2d(Math.min(other.x, this.x), Math.min(other.y, this.y));
        return object;
    }

    public Vector2d add(Vector2d other) {
        Vector2d object = new Vector2d(this.x + other.x, this.y + other.y);
        return object;
    }

    public Vector2d subtract(Vector2d other) {
        Vector2d object = new Vector2d(this.x - other.x, this.y - other.y);
        return object;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    public Vector2d opposite() {
        Vector2d object = new Vector2d((-1) * this.x, (-1) * this.y);
        return object;
    }
}