package model;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MobileOrder {
    Up,
    Down,
    Right,
    Left;

    public static List<MobileOrder> getValues(){
        return VALUES;
    }
    public static Point getPos(Point pos, MobileOrder direction) {
        switch (direction) {
        case Left:
            return new Point(pos.x, pos.y - 1);
        case Right:
            return new Point(pos.x, pos.y + 1);
        case Up:
            return new Point(pos.x - 1, pos.y);
        case Down:
            return new Point(pos.x + 1, pos.y);
        }
        return null;
    }
    
    private static final List<MobileOrder> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    
    private static final int SIZE = VALUES.size();
    
    private static final Random RANDOM = new Random();
    
    public static MobileOrder random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
