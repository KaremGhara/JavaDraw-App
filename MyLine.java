// MyLine.java
import java.awt.Color;
import java.awt.Graphics;

/*
Class MyLine gets the requies information for drawing a line
 */
public class MyLine extends MyShape
{

// Empty construtor
public MyLine()
{
}
// Contructor whose values gets set by the super constructor
public MyLine(int x1,int y1,int x2,int y2,Color color)
{
super(x1,y1,x2,y2,color);
}


// Overriding the abstract method in the abstract class MyShape  implemnting it for the line
@Override
public void draw(Graphics g)
{
g.setColor(getColor());
g.drawLine(getX1(),getY1(),getX2(),getY2());
}
}