import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

// This is our main in it we can change the Panel width and button and labels  and starts our DrawPanel constuctor.
public class TestDraw
{
    public static void main(String [] args)
    {
        DrawFrame frame=new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setVisible(true);

    }
}
