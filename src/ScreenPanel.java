import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class ScreenPanel extends JPanel implements Runnable{
    static final int SCREEN_WIDTH = 720, SCREEN_HEIGHT = 720;
    static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);

    Thread mainThread;
    Image image;
    Graphics graphics;
    Vertex3D[] vertexes = new Vertex3D[4];
    Edge3D[] edges = new Edge3D[4];

    ScreenPanel(){
        this.setFocusable(true);
        this.addKeyListener(new KeyList());
        this.addMouseListener(new MouseList());
        this.setPreferredSize(SCREEN_SIZE);

        vertexes[0] = new Vertex3D(-50,-50,0, 5, Color.BLUE,200,200);
        vertexes[1] = new Vertex3D(50,-50,0, 5, Color.RED,200,200);
        vertexes[2] = new Vertex3D(50,50,0, 5, Color.YELLOW,200,200);
        vertexes[3] = new Vertex3D(-50,50,0, 5, Color.GREEN,200,200);

        edges[0] = new Edge3D(vertexes[0],vertexes[1],10,Color.WHITE);
        edges[1] = new Edge3D(vertexes[1],vertexes[2],10,Color.WHITE);
        edges[2] = new Edge3D(vertexes[2],vertexes[3],10,Color.WHITE);
        edges[3] = new Edge3D(vertexes[3],vertexes[0],10,Color.WHITE);

        for(Vertex3D vertex: vertexes){
            vertex.setAngularXVelocity(0.1);
        }

        mainThread = new Thread(this);
        mainThread.start();
    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics graphics){
        for(Edge3D edge: edges){
            edge.draw(graphics);
        }
        for(Vertex3D vertex: vertexes){
            vertex.draw(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void update(){
        for(Vertex3D vertex: vertexes){
            vertex.update();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public class KeyList extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

        }
    }

    public class MouseList extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x;
            int y = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y;

            //1 is left click, 2 is middle click, 3 is right click
            if(e.getButton() == 1){
            }
        }
    }

}
