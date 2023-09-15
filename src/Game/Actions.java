package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Actions implements ActionListener{


	private JLabel label;
	private JFrame frame;
	private JPanel panel1, panel2, buttonPanel;
	private JButton startButton, leftButton, rightButton, resetButton;
	private Font pixelArt;
	private ImageIcon icon1, icon2, icon3, icon4;
	private TreeNode currentNode,root, leftNode, rightNode,rightNode1;
	
	public Actions() {
		frame = new JFrame();//Hier erstellen wir den GUI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);//Die größe des GUIs
		frame.setLocationRelativeTo(null);//Wird immer in der Mitte platziert
		frame.setLayout(null);
		
		panel1 = new JPanel();//Ist für Label
		panel2 = new JPanel();//Startbutton
		buttonPanel = new JPanel();//rechts und links
		
		panel1.setBackground(Color.black);//Hintergrund soll schwarz sein24
		panel1.setBounds(0, 0, 900, 500);//Wie groß Panel 1 ist
		
		panel2.setBackground(Color.black);
		panel2.setBounds(0, 500, 900, 100);
		
		buttonPanel.setBackground(Color.black);
		buttonPanel.setBounds(0, 600, 900, 300);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(buttonPanel);
		
		frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        
        //Bild für Startbutton
        icon1 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/Start.png");
//      icon1 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/Start.png");
        int icon1Width = 75;
        int icon1Height = 50; 
        Image scaledImage1 = icon1.getImage().getScaledInstance(icon1Width, icon1Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        
        //Bild füt rechtsbutton
        icon3 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/right.png");
//      icon3 = new ImageIcon(Dein Pfad);
        int icon3Width = 75;
        int icon3Height = 75; 
        Image scaledImage3 = icon3.getImage().getScaledInstance(icon3Width, icon3Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        
        //Bild für leftbutton
        icon2 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/left.png");
//      icon2 = new ImageIcon(Dein Pfad);
        int icon2Width = 75;
        int icon2Height = 75; 
        Image scaledImage2 = icon2.getImage().getScaledInstance(icon2Width, icon2Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        
        icon4 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/reset.png");
//      icon4 = new ImageIcon(Dein Pfad);
		int icon4Width = 50;
		int icon4Height = 25;
		Image scaledImage4 = icon4.getImage().getScaledInstance(icon2Width, icon2Height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);

        
        //Buttons werden den Icons zugewiesen 
		startButton = new JButton(scaledIcon1);
		rightButton = new JButton(scaledIcon3);
		leftButton = new JButton(scaledIcon2);
		resetButton = new JButton(scaledIcon4);
		
		//Für die schriftart
		try {
		    String fontPath = "/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/joystix monospace.ttf";
//		    Pfad von tff
		    pixelArt = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(15f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(pixelArt);
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		
		//Ist Starttext vom Spiel--> wenn man den runner betätigt, dann taucht dieser text auf
		label = new JLabel("<html><body>You are standing in front of the entrance to an old, "
				+ "<br>weathered cave. The entrance is surrounded by wild greenery "
				+ "<br>and the birds are chirping happily in the trees. "
				+ "<br>You feel a mixture of excitement and nervousness "
				+ "<br>as you decide to enter the cave. You switch on your "
				+ "<br>torch and cautiously enter. </body></html>");
		label.setBackground(Color.black);//Hintergrund schwarz 
		label.setForeground(Color.white);//Schwrift ist weiß
		label.setFont(pixelArt);
		
		startButton.addActionListener(this);
		rightButton.addActionListener(this);
		leftButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		rightButton.setVisible(false);
		leftButton.setVisible(false);
		resetButton.setVisible(false);
		
		panel1.add(label);
		panel2.add(startButton);
		
//		buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(leftButton, BorderLayout.EAST);
        buttonPanel.add(rightButton, BorderLayout.WEST);
        buttonPanel.add(resetButton, BorderLayout.CENTER);


		frame.setTitle("ChooseYourOwnAdventure");
		frame.setVisible(true);
	}

	@Override
	/*
	 * Hier führen die Buttons ihre Aktionen aus:
	 * Wenn dies geklickt wird, dann soll es das machen und wenn das, dann...
	 */
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == startButton) {
	        currentNode = createInitialTree();
	        updateLabel(currentNode.getText());
	        startButton.setVisible(false);
	        rightButton.setVisible(true);
	        leftButton.setVisible(true);
	    } else if (e.getSource() == rightButton) {
	        currentNode = currentNode.getRightChild();
	        updateLabel(currentNode.getText());
	        //Zweites rechts
	        if (currentNode == rightNode1) {
	            rightButton.setVisible(false);
	            leftButton.setVisible(false);
	            resetButton.setVisible(true);
	        }
	        //Reset--> Wird wieder tum root geführt
	    } else if (e.getSource() == resetButton) {
	        currentNode = rightNode; 
	        updateLabel(currentNode.getText());
	        rightButton.setVisible(true);
	        leftButton.setVisible(true);
	        resetButton.setVisible(false);
	        
	        
	    } else if (e.getSource() == leftButton) {
	        currentNode = currentNode.getLeftChild();
	        updateLabel(currentNode.getText());
	    }
	}
	
	private TreeNode createInitialTree() {
		 root = new TreeNode("<html><body>Rules: The target is \"something\". You can choose your "
				+ "<br>own path by choosing right or left before each decision. " + "<br>"
				+ "<br>The cave is dark and damp. The light from your torch reveals "
				+ "<br>stalactites hanging from the ceiling and strange rock formations "
				+ "<br>along the walls. After a while you discover an inscription on a rock "
				+ "<br>sticking out of the ground. The inscription is written in an ancient, "
				+ "<br>forgotten language. You cannot decipher it, but it arouses your "
				+ "<br>interest. Do you want to go further into the cave and look for more "
				+ "<br>clues (Go right), or do you want to try to unravel the meaning of the "
				+ "<br>inscription (Go left)?</body></html>");
		 leftNode = new TreeNode("<html><body>You chosen left You sit down on the floor and begin to "
				+ "<br>study the inscription. After some time you manage to decipher a "
				+ "<br>few words. They seem to speak of a legendary source of knowledge "
				+ "<br>in this cave. Your mind is made up: you will go deeper into the "
				+ "<br>cave to find this source. You return to the entrance and choose "
				+ "<br>one of the tunnels leading deeper inside.</body></html>");
		 rightNode = new TreeNode("<html><body>You chosen right: You decide to go deeper into the cave. "
				+ "<br>Your footsteps echo off the walls as you walk down a narrow tunnel. "
				+ "<br>Suddenly you reach a large chamber lit by torches. In the middle of "
				+ "<br>the chamber you see an ancient chest. It is decorated with old "
				+ "<br>carvings and looks mysterious. Open the chest (Go right), or examine "
				+ "<br>the torches more closely (Go left)? </body></html>");
		 rightNode1 = new TreeNode("<html><body>Your path was very dark and that's"
				+ "<br>why you didn't see the gorge below you. Unfortunately, "
				+ "<br>you did not survive the fall..."
				+ "<br>"
				+ "<br>Press start:</body></html>");
		
		//Der Weg von den Nodes: Wenn du den Weg rechts einschlögst, dann wird dir der Pfad von rechts zugewiesen
		root.setLeftChild(leftNode);
		root.setRightChild(rightNode);
		rightNode.setRightChild(rightNode1);
		rightNode1.setRightChild(rightNode);
		return root;
	}

	private void updateLabel(String labelText) {
        label.setText("<html><body>" + labelText + "</body></html>");
    }
}
