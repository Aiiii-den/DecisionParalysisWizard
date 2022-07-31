package decisionParalysisWizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.*;
import java.util.List;
import java.util.function.UnaryOperator;

public class TrialSplitting extends JFrame implements ActionListener{

	ArrayList<String> todos;
	ArrayList<JTextField> tf;
	JTextField td1, td2, td3, td4, td5, td6, td7, td8;
	JButton magic, history;
	int anzahl, anzahlTD, r, n, rt;
	String s, s2, s3;
	Object[] options;
	JPanel input;
	JButton fin, again, cancel;
	Map<LocalDate, String> hist;
	LocalDate date;
	String histSt="";
	Boolean magicButton;


	public TrialSplitting() {
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



		Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
		JLabel yourTasks = new JLabel("YOUR TASKS");

		EmptyBorder eBorder = new EmptyBorder(2, 10, 2, 10); // oben, rechts, unten, links
		LineBorder lBorder = new LineBorder(new Color(255, 255, 255));
		yourTasks.setBorder(BorderFactory.createCompoundBorder(lBorder, eBorder));

		yourTasks.setForeground(Color.WHITE);
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
		south.setLayout(new FlowLayout(FlowLayout.CENTER, 55, 12));
		south.setBackground(Color.MAGENTA);
		main.add(south, BorderLayout.SOUTH);

		this.history = new JButton("History");
		south.add(this.history);

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

		this.magic.addActionListener(this);
		this.history.addActionListener(this);

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
		this.tf = new ArrayList<>();

		this.anzahlTD=0;

		if(!inp1.isBlank()) {
			this.todos.add(inp1);
			this.tf.add(td1);
			this.anzahlTD++;
		}
		if(!inp2.isBlank()) {
			this.todos.add(inp2);
			this.tf.add(td2);
			this.anzahlTD++;
		}
		if(!inp3.isBlank()) {
			this.todos.add(inp3);
			this.tf.add(td3);
			this.anzahlTD++;
		}
		if(!inp4.isBlank()) {
			this.todos.add(inp4);
			this.tf.add(td4);
			this.anzahlTD++;
		}
		if(!inp5.isBlank()) {
			this.todos.add(inp5);
			this.tf.add(td5);
			this.anzahlTD++;
		}
		if(!inp6.isBlank()) {
			this.todos.add(inp6);
			this.tf.add(td6);
			this.anzahlTD++;
		}
		if(!inp7.isBlank()) {
			this.todos.add(inp7);
			this.tf.add(td7);
			this.anzahlTD++;
		}
		if(!inp8.isBlank()) {
			this.todos.add(inp8);
			this.tf.add(td8);
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

			while(this.r==this.rt && this.todos.size()>1) {
				random = new Random();
				this.r=random.nextInt(this.anzahlTD);
			}
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
		this.magicButton=false;

		if(src instanceof JButton  && src==this.magic) {
			this.magicClicked();
			if(!this.todos.isEmpty()) {
				this.magicButton=true;
			}
		}

		while(src instanceof JButton && this.n==JOptionPane.NO_OPTION) {
			this.goAgainClicked();
		}


		if(src instanceof JButton && magicButton==true) {
			this.fillMap();
		}

		if(src instanceof JButton && src==this.history) {
			getHistory();
		}
	}



	public void magicClicked() {
		this.choose();
		this.anzahlTD=0;
		if(this.s2.matches("You need to enter a task")) {
			JOptionPane.showMessageDialog(rootPane,this.s3, "No tasks entered", JOptionPane.WARNING_MESSAGE);
		}

		else {
			this.options = new Object[]{"finsihed", "go again", "go back"};
			this.n = JOptionPane.showOptionDialog(rootPane,
					s2,
					"Chosen task",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
		}
	}

	public void goAgainClicked() {
		this.todos.clear();
		this.tasks();
		this.rt=this.r;
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


	public void fillMap() {

		this.date = LocalDate.now();
		this.hist = new HashMap<>();

		if(this.tf.get(this.r) ==this.td1) {
			this.hist.put(this.date, this.td1.getText());
			this.td1.setText("");
			//JTextField ff=new JTextField(""); 
			//this.tf.get(this.r).replaceSelection("");

			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td2) {
			this.hist.put(this.date, this.td2.getText());
			this.td2.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td3) {
			this.hist.put(this.date, this.td3.getText());
			this.td3.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td4) {
			this.hist.put(this.date, this.td4.getText());
			this.td4.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td5) {
			this.hist.put(this.date, this.td5.getText());
			this.td5.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td6) {
			this.hist.put(this.date, this.td6.getText());
			this.td6.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td7) {
			this.hist.put(this.date, this.td7.getText());
			this.td7.setText("");
			this.anzahlTD-=1;
		}
		else if(this.tf.get(this.r) ==this.td8) {
			this.hist.put(this.date, this.td8.getText());
			this.td8.setText("");
			this.anzahlTD-=1;
		}

		for(Map.Entry<LocalDate, String> m : hist.entrySet()) {
			this.histSt+=("Date: " + m.getKey() + " Task: " + m.getValue() + "\n" );
		}

		this.rt=this.r-1;
		this.todos.clear();
		this.input.revalidate();
	}

	public void getHistory() {
		if(this.histSt=="") {
			JOptionPane.showMessageDialog(rootPane, "Nothing finished yet", "Finished Tasks", JOptionPane.QUESTION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(rootPane, this.histSt, "Finished Tasks", JOptionPane.INFORMATION_MESSAGE);
		}
	}


	public static void main(String[] args) {
		new TrialSplitting();

	}

}
