import java.awt.*;

public class Vertex3D {
    private final Point3D point;
    private final int radius;
    private final Color color;

    private final int offsetX;
    private final int offsetY;

    private double angularXVelocity = 0;
    private double angularYVelocity = 0;
    private double angularZVelocity = 0;

    public Vertex3D(double x, double y, double z, int radius, Color color, int offsetX, int offsetY){
        point = new Point3D(x,y,z);
        this.radius = radius;
        this.color = color;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void update(){
        point.setXAngle(point.getXAngle()+angularXVelocity);
        point.setYAngle(point.getYAngle()+angularYVelocity);
        point.setZAngle(point.getZAngle()+angularZVelocity);
    }

    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillOval(getGraphicsXLocation()-radius,getGraphicsYLocation()-radius,radius*2,radius*2);
    }

    public void setAngularXVelocity(double angularXVelocity) {
        this.angularXVelocity = angularXVelocity;
    }

    public void setAngularYVelocity(double angularYVelocity) {
        this.angularYVelocity = angularYVelocity;
    }

    public void setAngularZVelocity(double angularZVelocity) {
        this.angularZVelocity = angularZVelocity;
    }

    public int getGraphicsXLocation(){
        int x = (int)point.getXProjection();
        x+= offsetX;
        return x;
    }

    public int getGraphicsYLocation(){
        int y = (int)point.getYProjection();
        y+= offsetY;
        return y;
    }
}
