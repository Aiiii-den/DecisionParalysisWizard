package decisionParalysisWizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Decision2 extends JFrame implements ActionListener{

	ArrayList<String> todos;
	JTextField td1, td2, td3, td4, td5, td6, td7, td8;
	JButton magic;
	int anzahl, anzahlTD;
	String s, s2, s3;



	public Decision2() {
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
		
		this.anzahl=8;
		
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
		
		if(!inp1.isBlank()) {
			this.todos.add(inp1);
			this.anzahlTD=1;
		}
		if(!inp2.isBlank()) {
			this.todos.add(inp2);
			this.anzahlTD++;
		}
		if(!inp3.isBlank()) {
			this.todos.add(inp3);
			this.anzahlTD++;
		}
		if(!inp4.isBlank()) {
			this.todos.add(inp4);
			this.anzahlTD++;
		}
		if(!inp5.isBlank()) {
			this.todos.add(inp5);
			this.anzahlTD++;
		}
		if(!inp6.isBlank()) {
			this.todos.add(inp6);
			this.anzahlTD++;
		}
		if(!inp7.isBlank()) {
			this.todos.add(inp7);
			this.anzahlTD++;
		}
		if(!inp8.isBlank()) {
			this.todos.add(inp8);
			this.anzahlTD++;
		}
		

		return todos;

	}

	public String choose() {

		this.tasks();
		this.s="";
		this.s2="How about ";

		if(!this.todos.isEmpty()) { //difference vs .isBlank() and isEmpty() ?
			Random random = new Random();
			int r=random.nextInt(this.anzahlTD);
	
			for(int i=0; i<anzahlTD; i++) {
				if(i==r) {
					this.s+=this.todos.get(r);
				}
			}
	
			this.s2+=s+"?";
		}

		else { //difference vs .isBlank() and isEmpty() ?
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



	public static void main(String[] args) {
		new Decision2();

	}

}
