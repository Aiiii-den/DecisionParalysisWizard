package TrialAndError;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Decision extends JFrame implements ActionListener{

	ArrayList<String> todos;
	ArrayList<String> filled;
	JTextField td1, td2, td3, td4, td5, td6, td7, td8;
	/*JTextField td2;
	JTextField td3;
	JTextField td4;
	JTextField td5;
	JTextField td6;
	JTextField td7;
	JTextField td8;*/
	JButton magic;
	int anzahl=8;
	String s, s2, s3;


	public Decision() {
		super(); 
		this.setTitle("Decision Paralyis Wizard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		this.getContentPane().add(initContent());

		this.setLocation(300, 200); 
		this.setSize(400, 300); 
		this.setVisible(true);
		this.setResizable(false);
	}

	public JPanel initContent() {

		//Main Panel
		JPanel main = new JPanel(); 
		main.setLayout(new BorderLayout(5, 5));
		main.setBackground(Color.MAGENTA); 

		//BorderLayout North
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		flow.setBackground(Color.MAGENTA);
		main.add(flow, BorderLayout.NORTH);

		JLabel yourTasks = new JLabel("Your tasks:");
		yourTasks.setForeground(Color.BLACK);
		flow.add(yourTasks);

		//BorderLayout Center

		JPanel input = new JPanel();
		input.setLayout(new GridLayout(4,2, 20, 20));
		input.setBackground(Color.MAGENTA);
		main.add(input, BorderLayout.CENTER);

		this.td1= new JTextField();
		this.td2= new JTextField();
		this.td3= new JTextField();
		this.td4= new JTextField();
		this.td5= new JTextField();
		this.td6= new JTextField();
		this.td7= new JTextField();
		this.td8= new JTextField();

		input.add(this.td1);
		input.add(this.td2);
		input.add(this.td3);
		input.add(this.td4);
		input.add(this.td5);
		input.add(this.td6);
		input.add(this.td7);
		input.add(this.td8);

		//BorderLayout South
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		south.setBackground(Color.MAGENTA);
		main.add(south, BorderLayout.SOUTH);

		this.magic = new JButton("Let the Magic Happen ^^");
		south.add(this.magic);

		//BorderLayout East & West
		JPanel east = new JPanel();
		east.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		east.setBackground(Color.MAGENTA);
		main.add(east, BorderLayout.EAST);

		JPanel west = new JPanel();
		west.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		west.setBackground(Color.MAGENTA);
		main.add(west, BorderLayout.WEST);

		magic.addActionListener(this);

		return main;

	}

	public ArrayList<String> tasks(){
		String inp1=this.td1.getText();
		String inp2=this.td2.getText();
		String inp3=this.td3.getText();
		String inp4=this.td4.getText();
		String inp5=this.td5.getText();
		String inp6=this.td6.getText();
		String inp7=this.td7.getText();
		String inp8=this.td8.getText();

		this.todos = new ArrayList<>();
		this.todos.add(inp1);
		this.todos.add(inp2);
		this.todos.add(inp3);
		this.todos.add(inp4);
		this.todos.add(inp5);
		this.todos.add(inp6);
		this.todos.add(inp7);
		this.todos.add(inp8);

		return todos;
		
		//trying to filter through this and not in the choose() method -- only one ArrayList as well

	}

	public String choose() {

		this.tasks();
		this.filled = new ArrayList<>();
		this.s="";
		this.s2="How about ";

		int anzahlTD = this.anzahl;
		for(int i=0; i<this.anzahl; i++) {
			if(this.todos.get(i)==null || this.todos.get(i)=="") {
				anzahlTD-=1;
			}
		}

		for(int i=0; i<this.anzahl; i++) {
			if(this.todos.get(i)!=null || this.todos.get(i)!="") {
				this.filled.add(this.todos.get(i));
			}
		}

		Random random = new Random();
		int r=random.nextInt((anzahlTD));

		for(int i=0; i<anzahlTD; i++) {
			if(i==r) {
				this.s += this.filled.get(i);
			}
		}

		this.s2+=s+"?";

		if(this.s.isEmpty()) { //difference vs .isBlank() and isEmpty() ?
			this.s3="You need to enter a task";
			this.s2=this.s3;
		}

		return s2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src instanceof JButton) {
			this.choose();
			filled.clear();
			todos.clear();

			//implement if else statements for JDialog when  this.s.isBlank() --> Warning and one okay button
			//if(this.s2.matches("You need to enter a task")) {
			//	JOptionPane.showMessageDialog(rootPane, s2,"Your chosen task", WARNING_MESSAGE);
			//}

			//else {
			JOptionPane.showMessageDialog(rootPane, s2);
			//}
			//implement code which opens a child window which displays the String chosen and has a heading and two buttons

		}

	}

}
