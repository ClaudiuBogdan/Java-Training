public enum Direction {
    DIRECTION_NORTH ("NORTH",0,-1),
    DIRECTION_NORTH_EAST ("NORTH_EAST",1,-1),
    DIRECTION_EAST ("EAST",1,0),
    DIRECTION_SOUTH_EAST ("SOUTH_EAST",1,1),
    DIRECTION_SOUTH ("SOUTH",0,1),
    DIRECTION_SOUTH_WEST ("SOUTH_WEST",-1,1),
    DIRECTION_WEST ("WEST",-1, 0),
    DIRECTION_NORTH_WEST ("NORTH_WEST",-1, -1);

    private final int diff_X; //Distance in x axis.
    private final int diff_Y; //Distance in y axis.
    private final String directionName;

    Direction(String name, int diff_X, int diff_Y){
        this.diff_X = diff_X;
        this.diff_Y = diff_Y;
        this.directionName = name;
    }

    public String toString(){
        String directionString = String.format("%s: (%d,%d)",getDirectionName(), getDiff_X(),getDiff_Y());
        return directionString;
    }

    public int getDiff_X(){
        return this.diff_X;
    }

    public int getDiff_Y(){
        return this.diff_Y;
    }

    public String getDirectionName(){
        return directionName;
    }
}
