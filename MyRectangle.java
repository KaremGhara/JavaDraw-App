// MyRectangle.java
import java.awt.Color;
import java.awt.Graphics;

/*
Class MyRectangle gets the requies information for drawing the rectangle
 */
public class MyRectangle extends MyBoundedShape
{

private boolean filled;
// empty constructor who sets the shape unfilled
public MyRectangle()
{
setFilled(false);
}

// Constructor who calls for the super constructor to set the values of the rectangle
public MyRectangle(int x1,int y1,int x2,int y2,Color color,boolean filled)
{
super(x1,y1,x2,y2,color,filled);
}
// Overriding an abstract method on the abstract class MyShape and implemnting it for the rectangle
@Override
public void draw(Graphics g)
{
g.setColor(getColor());

if(getFilled())
g.fillRect(getUpperLeftX(),getUpperLeftY(),getWidth(),getheight());

else 
g.drawRect(getUpperLeftX(),getUpperLeftY(),getWidth(),getheight());

}

}