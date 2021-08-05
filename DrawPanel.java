/*
Class DrawPanel.java
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Class DrawPanel is the class to handle all the mouse events and the buttons
public class DrawPanel extends JPanel implements MouseListener,MouseMotionListener
{
	//Declaring the variables
	//Max shapes are set to 100 shapes
	private int maxShapes=100;
	//Array of shapes
	private MyShape[] shapes;
	//Counting the shape on the panel
	private int shapeCount;
	//Variable to know what type the shape is
	private int Type;
	//What is the current shape that is being drawn
	private MyShape currShape;
	//Current color is used
	private Color currColor;
	//boolean variable to know if the shape is filled or not
	private boolean filled;
	//Status bar
	private JLabel statusLabel;
	//ParentWindow for the frame
	private JFrame parentWindow;
	//Constructor
	public DrawPanel(JLabel statusLabel,JFrame parentWindow)
	{
		this.statusLabel=statusLabel;
		this.parentWindow=parentWindow;
		shapeCount=0;
		setBackground(Color.WHITE);
		shapes=new MyShape[maxShapes];
		setCurrShape(0);
		setDrawingColor(Color.BLACK);
		setFilledShape(false);
		currShape=null;
		addMouseListener(this);
		addMouseMotionListener(this);
				
	}
	//Sets the shape to fill or not filled
	 public void setFilledShape(boolean filled) {
		this.filled=filled;
	}
	 //Sets the color of the shape
	public void setDrawingColor(Color color) {
		currColor=color;
	}
	//Sets the shape type
	public void setCurrShape(int Type) {
		
		if(Type<0||Type>2)
			Type=0;
		else 
		this.Type=Type;
	}
	//Method to clear all shaps int the panel
	 public void clearAll()
	{
		if(shapeCount==0)
		{
			JOptionPane.showMessageDialog(parentWindow,"No Shape has been drawn!");
		}
		shapeCount=0;
		repaint();
	}
	//Method to undo the previous draw
	 public void UndoLastDrawing()
	{
		 
		 if(shapeCount==0)
			{
				JOptionPane.showMessageDialog(parentWindow,"No Shape has been drawn!");
			}
		 
		 
		if(shapeCount>0)
		{
			--shapeCount;
			repaint();
		}
	}
	//Method to draw the shape
	public void paintComponent(Graphics G)
	{
		super.paintComponent(G);
		
		for(int i=0;i<shapeCount;i++)
		{
			shapes[i].draw(G);
		}
		
		if(currShape!=null)
		{
			currShape.draw(G);
		}
	}
	
	private  MyShape createShape(int...cooredinates)
	{
		int x1,y1,x2,y2;
		if(cooredinates.length!=4)
			return null;
		
		x1=cooredinates[0];
		y1=cooredinates[1];
		x2=cooredinates[2];
		y2=cooredinates[3];
		
		switch(Type)
		{
		case 0:
			return new MyLine(x1,y1,x2,y2,currColor);
		case 1:
			return new MyOval(x1,y1,x2,y2,currColor,filled);
		case 2:
			return new MyRectangle(x1,y1,x2,y2,currColor,filled);
			
		}
		return null;
		}
	
	//Method to mouse event when its dragged
	@Override
	public void mouseDragged(MouseEvent e) {
		if(currShape!=null)
		{
			currShape.setX2(e.getX());
			currShape.setY2(e.getY());
			
		}
		mouseMoved(e);
	}
	//Method to mouse event when it moves(Updating the mouse location)

	@Override
	public void mouseMoved(MouseEvent e) {
		statusLabel.setText(String.format("X:Y->(%d,%d)",e.getX(),e.getY()));
	}

	



	//Handling the mouse when it released
	@Override
	public void mouseReleased(MouseEvent e) {
		if(currShape==null||e.getButton()!=MouseEvent.BUTTON1)
			return;
		
		if(currShape.getX1()==currShape.getX2()&&currShape.getY1()==currShape.getY2())
		{
			currShape=null;
			repaint();
			return;
		}
		currShape.setX2(e.getX());
		currShape.setY2(e.getY());
		
		
		if(shapeCount<shapes.length)
		{
			shapes[shapeCount++]=currShape;
		}
		currShape=null;
		repaint();
	}
	//Handling the mouse when its pressed on
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()!=MouseEvent.BUTTON1 || currShape!=null)
		return;
		
		if(shapeCount>=shapes.length)
		{
			JOptionPane.showMessageDialog(parentWindow,String.format("Cannot exceed the currnet number of shapes: %d",shapeCount));
			return;
			
		}
		
		currShape=createShape(e.getX(),e.getY(),e.getX(),e.getY());
		
		
	}
	//We didn't use these methods
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	
	
	}



	
	
	
	
	



