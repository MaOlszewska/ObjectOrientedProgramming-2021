package agh.ics.oop;


enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        switch(this){
            case NORTH: return "Północ";
            case EAST: return "Wschód";
            case SOUTH: return "Południe";
            case WEST: return "Zachód";
            default: return "Są tylko cztery kierunki";
        }
    }

    public MapDirection next(){
        switch(this){
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return null;
        }
    }

    public MapDirection previous(){
        switch(this){
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            default: return null;
        }
    }

    public Vector2d toUnitVector(){
        switch(this){
            case NORTH: return new Vector2d(0,1);
            case EAST: return new Vector2d(1,0);
            case SOUTH: return new Vector2d(0,-1);
            case WEST: return new Vector2d(-1, 0);
            default: return null;
        }
    }
}
