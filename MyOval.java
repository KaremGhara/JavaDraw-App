// MyOval.java
import java.awt.Color;
import java.awt.Graphics;

/*
Class MyOval gets the requies information for drawing an Oval
 */
public class MyOval extends MyBoundedShape
{

// Empty contructor that sets the oval as unfilled
public MyOval()
{
setFilled(false);
}
// Contructor whose values gets set by the super constructor
public MyOval(int x1,int y1,int x2,int y2,Color color,boolean filled)
{
super(x1,y1,x2,y2,color,filled);
}

//Overriding the method from the abstract class MyShape and implemnting it for the Oval
@Override
public void draw(Graphics g)
{
g.setColor(getColor());

if(getFilled()) g.fillOval(getUpperLeftX(),getUpperLeftY(),getWidth(),getheight());

else
g.drawOval(getUpperLeftX(),getUpperLeftY(),getWidth(),getheight());

}

}