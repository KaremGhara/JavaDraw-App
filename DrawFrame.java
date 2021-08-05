import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DrawFrame extends JFrame implements ItemListener {
	//Button to undo the previous shape
	private JButton undoButton;
	//Button to Clear the whole shape in the panel
	private JButton clearButton;
	// Array of colors
	private Color[] colors= {Color.GREEN,Color.RED,Color.YELLOW,Color.ORANGE,Color.BLUE,Color.GRAY};
	//Array of the possible colors
	private String [] colorChoises= {"Green","Red","Yellow","Orange","Blue","Gray"};
	//combo box to choose colors
	private JComboBox<String> colorBox;
	//Array of possible shapes
	private String [] shapeChoises= {"Line","Oval","Rectangle"};
	//combo box to choose shapes
	private JComboBox<String> shapes;
	//check box to select if the shape is filled or not
	private JCheckBox filled;
	//label for status bar
	private JLabel statusLabel;
	
	//Panel to draw it handles all the drawing matter
	private DrawPanel panel;
	//Constructor 
	public DrawFrame()
	{
		//Title of the frame
		super("Interactive Drawing ");
		//Panel at the top of the frame for the buttons and the combo boxes
		JPanel top=new JPanel();
		
		//creates and names the Button(Undo)
		undoButton=new JButton("Undo");
		//Adding the button to the top panel
		top.add(undoButton);
		//Inner class to make the necessary event (Undo the shape) 
		undoButton.addActionListener(new ActionListener() {
			//Overriding the method for doing the necessary event
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Calling the method that was implemented in DrawPanel class to undo the panel
				panel.UndoLastDrawing();
				
			}
			
		});
		//Creates and names the Button(Clear)
		clearButton=new JButton("Clear");
		//Adding the panel to the top of the frame 
		top.add(clearButton);
		//Inner class to make the necessary event (clearing the panel) 
		clearButton.addActionListener(new ActionListener() {
			//Overriding the method for doing the necessary event
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==clearButton)
					//Calling the method that was implemented in DrawPanel class to clear the panel
					panel.clearAll();
			}
			
		});
		//Creates the combo box of the colors of the shapes
		colorBox=new JComboBox<String>(colorChoises);
		//Adding the combo box to the top
		top.add(colorBox);
		//
		colorBox.addItemListener(this);
		//Creates the combo box of the shapes
		shapes=new JComboBox<String>(shapeChoises);
		top.add(shapes);
		shapes.addItemListener(this);
		//Creates and names the check box to filled
		filled=new JCheckBox("Filled");
		filled.addItemListener(this);
		top.add(filled);
		//Adding the top panel to the panel of the Drawing
		add(top,BorderLayout.NORTH);
		statusLabel=new JLabel("(0,0)");
		add(statusLabel,BorderLayout.SOUTH);
		panel=new DrawPanel(statusLabel,this);
		add(panel);
		
		
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==shapes)
		{
			if(e.getStateChange()!=ItemEvent.SELECTED) 
				return;
			panel.setCurrShape(shapes.getSelectedIndex());
			
			
		}
		else if(e.getSource()==colorBox)
		{
			if(e.getStateChange()!=ItemEvent.SELECTED) 
				return;
			panel.setDrawingColor(colors[colorBox.getSelectedIndex()]);
		}
		else if(e.getSource()==filled)
		{
			panel.setFilledShape(filled.isSelected());
		}
		
		
	}

}
