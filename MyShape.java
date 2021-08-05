//MyShape.java
import java.awt.Color;
import java.awt.Graphics;
// MyShape is an abstratc class that initialize the required methpd for shapes
public abstract class MyShape
{
private int x1,y1,x2,y2;
private Color color;

// Contructor that sets our cooredinates and color fot our shape
public MyShape(int x1,int y1,int x2,int y2,Color color)
{
setX1(x1);
setX2(x2);
setY1(y1);
setY2(y2);
setColor(color);

}
// empty contructor
public MyShape()
{
this(0,0,0,0,Color.BLACK);
}
//Set the shape color
public void setColor(Color color)
{
this.color=color;
}
// get the shape color
public Color getColor()
{
return color;
}

// set x1 coordinate
public void setX1(int x1)
{
this.x1=(x1>=0 ? x1:0);
}
// set x2 coordinate
public void setX2(int x2)
{
this.x2=(x2>=0 ? x2:0);
}
// set y1 coordinate
public void setY1(int y1)
{
this.y1=(y1>=0 ? y1:0);
}
// set y2 coordinate
public void setY2(int y2)
{
this.y2=(y2>=0 ? y2:0);
}
// get x1 coordinate
public int getX1()
{
return x1;
}
// get x2 coordinate
public int getX2()
{
return x2;
}
// get y1 coordinate
public int getY1()
{
return y1;
}
// get y2 coordinate
public int getY2()
{
return y2;
}
// an abstract method that the the specfic class will inherit it from MyShape class to draw his shape
public abstract void draw(Graphics g);



}
