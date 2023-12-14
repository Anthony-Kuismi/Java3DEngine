import java.awt.*;

public class Edge3D {
    private final Vertex3D source;
    private final Vertex3D destination;
    private final int width;
    private final Color color;

    public Edge3D(Vertex3D source, Vertex3D destination, int width, Color color){
        this.source = source;
        this.destination = destination;

        this.width = width;
        this.color = color;
    }

    public void draw(Graphics graphics){
        graphics.setColor(color);
        int x1 = source.getGraphicsXLocation();
        int y1 = source.getGraphicsYLocation();

        int x2 = destination.getGraphicsXLocation();
        int y2 = destination.getGraphicsYLocation();

        graphics.drawLine(x1,y1,x2,y2);
    }
}
