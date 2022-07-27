package decisionParalysisWizard;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Subwindow extends JFrame implements ActionListener{ 

	String s = "How about ";
	String s2=null;
	

	protected Subwindow() {
		super(); 
		this.setTitle("Chosen Task");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		this.getContentPane().add(initContent());

		this.setLocation(400, 300); 
		this.setSize(200, 100); 
		this.setVisible(false);
		this.setResizable(false);
	}
	
	public JPanel initContent() {

		//Main Panel
		JPanel sub = new JPanel(); 
		sub.setLayout(new BorderLayout(5, 5));
		sub.setBackground(Color.WHITE); 

		s+=s2+"?";

		//BorderLayout North
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		flow.setBackground(Color.MAGENTA);
		sub.add(flow, BorderLayout.NORTH);

		JLabel yourTasks = new JLabel(s);
		yourTasks.setForeground(Color.BLACK);
		flow.add(yourTasks);
		return sub;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
/*
	public String choose() {

		int anzahlN=0;
		for(int y=0; y<anzahl; y++) { //hier stimmt was nicht!!
			if(String.valueOf(y)==null) {
				Decision.todos.remove(y);
				anzahlN++;
				y--;
			}
		}

		int anzahlTD=anzahl-anzahlN;

		Random random = new Random();
		int r=random.nextInt((anzahlTD-1));

		for(int i=0; i<anzahlTD; i++) {
			if(i==r) {
				this.s2 = String.valueOf(i);
			}
		}
		return s2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	/*
	public static void main(String[] args) {
		new Subwindow();

	}*/

