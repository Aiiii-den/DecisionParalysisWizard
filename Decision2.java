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
	int anzahl, anzahlTD, r;
	String s, s2, s3;
	Object[] options;
	JPanel input;



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

		this.input = new JPanel();
		this.input.setLayout(new GridLayout(4,2, 20, 20));
		this.input.setBackground(Color.MAGENTA);
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
			this.r=random.nextInt(this.anzahlTD);

			for(int i=0; i<anzahlTD; i++) {
				if(i==this.r) {
					this.s+=this.todos.get(this.r);
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
		int n = 0;
		if(src instanceof JButton  && src==this.magic) {
			this.choose();
			//todos.clear();
			this.anzahlTD=0;

			//implement if else statements for JDialog when  this.s.isBlank() --> Warning and one okay button
			if(this.s2.matches("You need to enter a task")) {
				JOptionPane.showMessageDialog(rootPane,this.s3, "No tasks entered", JOptionPane.WARNING_MESSAGE);
			}

			else {
				this.options = new Object[]{"finsihed", "go again", "go back"};
				n = JOptionPane.showOptionDialog(rootPane,
						s2,
						"Chosen task",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[2]);


			}

		}
		if(src instanceof JButton  && n==JOptionPane.YES_OPTION) {
			//this.todos .set(r, s); 
			//_______________
			// wird gleich richtig unschöner Code, aber ich möchte schauen ob der Gedankengang aufgeht
			//funktioniert nich ganz so wie gewollt, da die Elemente nach dem finsihed aus der todo AL genommen werden und deswegen die ganze Liste verschoben wird
			if(this.s==this.td1.getText()) {
				this.td1.setText("");
			}
			else if(this.td2.getText()==this.s) {
				this.td2.setText("");
			}
			else if(this.td3.getText()==s) {
				this.td3.setText("");
			}
			else if(this.td4.getText()==s) {
				this.td4.setText("");
			}
			else if(this.td5.getText()==s) {
				this.td5.setText("");
			}
			else if(this.td6.getText()==s) {
				this.td6.setText("");
			}
			else if(this.td7.getText()==s) {
				this.td7.setText("");	
			}
			else if(this.td8.getText()==s) {
				this.td8.setText("");	
			}
			System.out.println("help");
			
			this.input.revalidate();
		}
		
 
		while(src instanceof JButton  && n==JOptionPane.NO_OPTION) {
			this.todos.clear();
			this.tasks();
			this.choose();
			
			this.options = new Object[]{"finsihed", "go again", "go back"};
			n = JOptionPane.showOptionDialog(rootPane,
					s2,
					"Chosen task",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
		}
		
		/*if(src instanceof JButton  && n==JOptionPane.YES_OPTION) {
			JOptionPane.
			
		}*/
	}


	public static void main(String[] args) {
		new Decision2();

	}

}
