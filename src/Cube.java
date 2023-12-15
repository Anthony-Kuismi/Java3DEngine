import java.awt.*;

public class Cube {

    private final Vertex3D[] vertexes;
    private final Edge3D[] edges;

    public Cube(int x, int y, int width, Color color){

        vertexes = new Vertex3D[8];
        edges = new Edge3D[12];

        double offset = width/2.0;

        vertexes[0] = new Vertex3D(offset,offset,offset,5,color,x,y);
        vertexes[1] = new Vertex3D(offset,offset,-offset,5,color,x,y);
        vertexes[2] = new Vertex3D(offset,-offset,offset,5,color,x,y);
        vertexes[3] = new Vertex3D(offset,-offset,-offset,5,color,x,y);
        vertexes[4] = new Vertex3D(-offset,offset,offset,5,color,x,y);
        vertexes[5] = new Vertex3D(-offset,offset,-offset,5,color,x,y);
        vertexes[6] = new Vertex3D(-offset,-offset,offset,5,color,x,y);
        vertexes[7] = new Vertex3D(-offset,-offset,-offset,5,color,x,y);

        edges[0] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[1] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[2] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[3] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[4] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[5] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[6] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[7] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[8] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[9] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[10] = new Edge3D(vertexes[0],vertexes[1],10,color);
        edges[11] = new Edge3D(vertexes[0],vertexes[1],10,color);

        updateAngle();
    }

    public void draw(Graphics graphics){
        for(Vertex3D vertex: vertexes){
            vertex.draw(graphics);
            vertex.update();
        }
        for(Edge3D edge: edges){
            edge.draw(graphics);
        }
    }

    public void updateAngle(){
        for(Vertex3D vertex: vertexes){
            double angularXVelocity = 0.025;
            double angularYVelocity = 0.025;
            double angularZVelocity = 0.025;

            vertex.setAngularXVelocity(angularXVelocity);
            vertex.setAngularYVelocity(angularYVelocity);
            vertex.setAngularZVelocity(angularZVelocity);

        }
    }
}
