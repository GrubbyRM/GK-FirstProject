import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class TransformedShapes extends JPanel {

    private Graphics2D g2; // A copy of the graphics context from paintComponent.
    private void resetTransform() {
        g2.setTransform(new AffineTransform());
    }
    private void rectangle() {
    	g2.fillRect(50, 50, 350, 25);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // along with g2.setColor, g1.scale, g2.translate, and g2.rotate.
        g2.setColor(Color.red);
        rectangle();
        g2.translate(0,  350);
        rectangle();
        g2.translate(-40,  65);
        g2.rotate(Math.toRadians(-45));
        g2.scale(1.4, 1);
        rectangle();


    }
    public TransformedShapes() {
        setPreferredSize(new Dimension(600,600) );
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
    }

    public static void main(String[] args)  {
        JFrame window = new JFrame("Drawing With Transforms");
        window.setContentPane(new TransformedShapes());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }

}
