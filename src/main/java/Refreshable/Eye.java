package Refreshable;

import java.awt.*;

public class Eye extends BoardEntity {
    private final int size;
    private final double index;
    public Eye(int maxWindowWidth, int maxWindowHeight) {
        super((int) (Math.random()*maxWindowWidth),(int) (Math.random()*maxWindowHeight));
        this.size = (int) (Math.random() * 100 + 50);
        this.index = Math.random() * 0.2 + 0.4;
        this.setXVelocity(1);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(this.getX(), this.getY(), this.size, (int) (this.size*this.index));
    }

    @Override
    public void refresh() {
        this.setX(this.getX() + this.getXVelocity());
        this.setY(this.getY() + this.getYVelocity());
    }
}
