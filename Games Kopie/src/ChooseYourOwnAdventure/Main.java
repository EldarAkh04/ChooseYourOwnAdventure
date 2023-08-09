package ChooseYourOwnAdventure;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Main implements ActionListener{
	
	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton startButton;
	private JButton rightButton;
	private JButton leftButton;	
	
	
	public Main() {
		frame = new JFrame();
		panel = new JPanel();
		startButton = new JButton("Start");
		rightButton = new JButton("Right");
		leftButton = new JButton("Left");
		
		label = new JLabel("Number of clicks: 0");
		
		startButton.addActionListener(this);
		rightButton.addActionListener(this);
		leftButton.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(startButton);
		panel.add(rightButton);
		panel.add(leftButton);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ChooseYourOwnAdventure");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to 'GAME'!");
		System.out.print("Left or right >");
		String response1 = input.nextLine();
		
		while (input.hasNext()) {
			response1 = input.next();
			response1 = response1.toLowerCase();
			if(response1.contains("end")) {
				break;
			}
			if (response1.contains("right")) {
				System.out.println("You choosed right");
			} else if (response1.contains("left")) {
				System.out.println("You choosed left");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks:" + count);
	}
}
