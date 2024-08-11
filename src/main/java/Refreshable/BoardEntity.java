package Refreshable;
import lombok.Data;

import java.awt.*;

@Data
abstract public class BoardEntity {
    private int x;
    private int y;
    private int xVelocity;
    private int yVelocity;
    public BoardEntity (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);
    public abstract void refresh();
}
