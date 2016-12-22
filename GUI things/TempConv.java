import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempConv extends JFrame implements ActionListener{

    private Container screen;
    
    private JLabel tempA;
    private JTextField tempB;
    
    public TempConv() {
	this.setTitle("Temperature Converter between Metric and America");
	this.setSize(683,384);
	this.setLocation(341,192);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	screen = this.getContentPane();
	screen.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	JButton FtoC = new JButton("Fahrenheit to Celsius");
	FtoC.addActionListener(this);
	FtoC.setActionCommand("FtoC");
	JButton CtoF = new JButton("Celsius to Fahrenheit");
	CtoF.addActionListener(this);
	CtoF.setActionCommand("CtoF");
	tempA = new JLabel("32");
	tempB = new JTextField(20);
	screen.add(FtoC);
        screen.add(CtoF);
	screen.add(tempA);
	screen.add(tempB);
    }

    public void actionPerformed(ActionEvent p){
	String event = p.getActionCommand();
	if(event.equals("CtoF")){
	    tempA.setText("" + (((9 * Integer.parseInt(tempB.getText())) / 5) + 32));
	}
	if(event.equals("FtoC")){
	    tempA.setText("" + (((Integer.parseInt(tempB.getText()) - 32) * 5) / 9));
	}
    }
	    
    public static void main(String[] args) {
        TempConv g = new TempConv();
	g.setVisible(true);
    }
}
