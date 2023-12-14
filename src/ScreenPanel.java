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
    Point3D[] points = new Point3D[4];

    ScreenPanel(){
        this.setFocusable(true);
        this.addKeyListener(new KeyList());
        this.addMouseListener(new MouseList());
        this.setPreferredSize(SCREEN_SIZE);

        points[0] = new Point3D(-50,-50,0);
        points[1] = new Point3D(50,-50,0);
        points[2] = new Point3D(50,50,0);
        points[3] = new Point3D(-50,50,0);

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
        graphics.setColor(Color.WHITE);
        points[0].setZAngle(points[0].getZAngle()+.05);
        points[1].setZAngle(points[1].getZAngle()+.05);
        points[2].setZAngle(points[2].getZAngle()+.05);
        points[3].setZAngle(points[3].getZAngle()+.05);

        points[0].setXAngle(points[0].getXAngle()+.05);
        points[1].setXAngle(points[1].getXAngle()+.05);
        points[2].setXAngle(points[2].getXAngle()+.05);
        points[3].setXAngle(points[3].getXAngle()+.05);

        for(Point3D point: points){
            graphics.fillOval((int)point.getXProjection()-5+getWidth()/2,(int)point.getYProjection()-5+getHeight()/2,10,10);
        }
        graphics.drawLine((int)points[0].getXProjection()+getWidth()/2,(int)points[0].getYProjection()+getHeight()/2,(int)points[1].getXProjection()+getWidth()/2,(int)points[1].getYProjection()+getHeight()/2);
        graphics.drawLine((int)points[1].getXProjection()+getWidth()/2,(int)points[1].getYProjection()+getHeight()/2,(int)points[2].getXProjection()+getWidth()/2,(int)points[2].getYProjection()+getHeight()/2);
        graphics.drawLine((int)points[2].getXProjection()+getWidth()/2,(int)points[2].getYProjection()+getHeight()/2,(int)points[3].getXProjection()+getWidth()/2,(int)points[3].getYProjection()+getHeight()/2);
        graphics.drawLine((int)points[3].getXProjection()+getWidth()/2,(int)points[3].getYProjection()+getHeight()/2,(int)points[0].getXProjection()+getWidth()/2,(int)points[0].getYProjection()+getHeight()/2);

        Toolkit.getDefaultToolkit().sync();
    }

    public void update(){

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
