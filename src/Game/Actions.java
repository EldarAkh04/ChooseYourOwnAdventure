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
	private TreeNode currentNode,root;
	private TreeNode r, rr, rl, rll, rlr;
	private TreeNode l, ll, lr;
	
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
//        icon1 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/Start.png");
        int icon1Width = 75;
        int icon1Height = 50; 
        Image scaledImage1 = icon1.getImage().getScaledInstance(icon1Width, icon1Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        
        //Bild füt rechtsbutton
        icon3 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/right.png");
//        icon3 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/right.png");
        int icon3Width = 75;
        int icon3Height = 75; 
        Image scaledImage3 = icon3.getImage().getScaledInstance(icon3Width, icon3Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        
        //Bild für leftbutton
        icon2 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/left.png");
//        icon2 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/left.png");
        int icon2Width = 75;
        int icon2Height = 75; 
        Image scaledImage2 = icon2.getImage().getScaledInstance(icon2Width, icon2Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        
        icon4 = new ImageIcon("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/reset.png");
//        icon4 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/reset.png");
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
//		    String fontPath = "C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/joystix monospace.ttf";
		    pixelArt = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(13f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(pixelArt);
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		
		
//		Du lauschst dem fröhlichen Zwitschern der Vögel, während das sanfte Rauschen 
//		des Flusses deine Ohren umspielt. Perlen aus Schweiß gleiten langsam von deiner Stirn herab, während die Sonne ihre warmen Strahlen auf dich wirft und deine Augen zum Leuchten bringen.
//		Als du erwachst, nimmst du behutsam deine Umgebung in den Blick. Du versuchst, die Fäden deiner Erinnerung zu entwirren, doch sie entziehen sich deinem Griff, wie Nebelschwaden im Morgenlicht.

		//Ist Starttext vom Spiel--> wenn man den runner betätigt, dann taucht dieser text auf
		label = new JLabel("<html><body> Du lauschst dem fröhlichen Zwitschern der Vögel, während das"
				+ "<br> sanfte Rauschen sanfte Rauschen während das sanfte Rauschen des Flusses deine"
				+ "<br> Ohren umspielt. Perlen  aus Schweiss gleiten langsam von deiner Stirn herab,"
				+ "<br> während die Sonne ihre warmen Strahlenauf dich wirft und deine Augen zum"
				+ "<br> Leuchten bringen. Als du erwachst, nimmst du behutsam deine Umgebung in"
				+ "<br> den Blick. Du versuchst, die Fäden deiner Erinnerung zu entwirren, doch"
				+ "<br> sie entziehen sich deinem Griff, wie Nebelschwaden im Morgenlicht.</body></html>");
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
	        if (currentNode == rr) {
	            rightButton.setVisible(false);
	            leftButton.setVisible(false);
	            resetButton.setVisible(true);
	        }
	        
	        if (currentNode == lr) {
	            rightButton.setVisible(false);
	            leftButton.setVisible(false);
	            resetButton.setVisible(true);
	        }
	        //Reset--> Wird wieder tum root geführt
	    } else if (e.getSource() == resetButton) {
	    	
	    	if (currentNode == rr) {
				currentNode = root; 
				updateLabel(currentNode.getText());
				rightButton.setVisible(true);
				leftButton.setVisible(true);
				resetButton.setVisible(false);
			}
	    	
	    	if (currentNode == rll) {
				currentNode = r; 
				updateLabel(currentNode.getText());
				rightButton.setVisible(true);
				leftButton.setVisible(true);
				resetButton.setVisible(false);
			}
	    	
	    	if (currentNode == lr) {
				currentNode = root; 
				updateLabel(currentNode.getText());
				rightButton.setVisible(true);
				leftButton.setVisible(true);
				resetButton.setVisible(false);
			}
	        
	        
	    } else if (e.getSource() == leftButton) {
	        currentNode = currentNode.getLeftChild();
	        updateLabel(currentNode.getText());
	        
	        if (currentNode == rll) {
	            rightButton.setVisible(false);
	            leftButton.setVisible(false);
	            resetButton.setVisible(true);
	        }
	    }
	}
	
	private TreeNode createInitialTree() {
		 root = new TreeNode("root");
		 
		 l = new TreeNode("l");
		 ll = new TreeNode("ll");
		 lr = new TreeNode ("lr-->x");
		 
		 r = new TreeNode("r");
		 rr = new TreeNode("rr-->x");
		 rl = new TreeNode("rl");
		 rll = new TreeNode("rll-->x");
		 rlr = new TreeNode("rlr");
		 
		
		//Der Weg von den Nodes: Wenn du den Weg rechts einschlögst, dann wird dir der Pfad von rechts zugewiesen
		root.setLeftChild(l);
		root.setRightChild(r);
		
		r.setRightChild(rr);
		r.setLeftChild(rl);
		rr.setRightChild(r);//-->Tod
		rl.setRightChild(rlr);
		rl.setLeftChild(rll);
		rll.setLeftChild(r);//-->Tod
		
		l.setRightChild(lr);
		l.setLeftChild(ll);
		lr.setRightChild(root);//-->Tod
		return root;
	}

	private void updateLabel(String labelText) {
        label.setText("<html><body>" + labelText + "</body></html>");
    }
}
