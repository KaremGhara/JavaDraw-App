// MyBoundedShape.java
import java.awt.Color;
import java.awt.Graphics;
// Class MyBoundedShape is an abstract class who inherits all his attributes from the abstract class MyShape
public abstract class MyBoundedShape extends MyShape
{
private boolean filled;
// empty constructor that sets the shape unfilled
public MyBoundedShape()
{
setFilled(false);
}
//Constructor that calls the super(MyShape) constructor to set all the attributes values
public MyBoundedShape(int x1,int y1,int x2,int y2,Color color,boolean filled)
{
super(x1,y1,x2,y2,color);
setFilled(filled);
}
// set the shape state(filled or unfilled)
public void setFilled(boolean filled)
{
    this.filled=filled;
}
// get the shape state
public boolean getFilled()
{
    return filled;
}
// get the shape width
public int getWidth()
{
return Math.abs(getX2()-getX1());
}
// get the shape height
public int getheight()
{
return Math.abs(getY2()-getY1());
}

// get the upperLeft X
public int getUpperLeftX()
{
return Math.min(getX1(),getX2());
}
// get the upperleft Y
public int getUpperLeftY()
{
return Math.min(getY1(),getY2());
}

}
