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
import javax.swing.JTextArea;


public class Actions implements ActionListener{


	private JTextArea area;
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
		frame.setSize(900, 900);//Die grösse des GUIs
		frame.setLocationRelativeTo(null);//Wird immer in der Mitte platziert
		frame.setLayout(null);
		
		panel1 = new JPanel();//Ist für Label
		panel2 = new JPanel();//Startbutton
		buttonPanel = new JPanel();//rechts und links
		
		panel1.setBackground(Color.black);//Hintergrund soll schwarz sein24
		panel1.setBounds(0, 0, 900, 500);//Wie gross Panel 1 ist
		
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
        icon1 = new ImageIcon("src/Start.png");
//        icon1 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/Start.png");
        int icon1Width = 75;
        int icon1Height = 50; 
        Image scaledImage1 = icon1.getImage().getScaledInstance(icon1Width, icon1Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        
        //Bild füt rechtsbutton
        icon3 = new ImageIcon("src/right.png");
//        icon3 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/right.png");
        int icon3Width = 75;
        int icon3Height = 75; 
        Image scaledImage3 = icon3.getImage().getScaledInstance(icon3Width, icon3Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        
        //Bild für leftbutton
        icon2 = new ImageIcon("src/left.png");
//        icon2 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/left.png");
        int icon2Width = 75;
        int icon2Height = 75; 
        Image scaledImage2 = icon2.getImage().getScaledInstance(icon2Width, icon2Height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        
        icon4 = new ImageIcon("src/reset.png");
//        icon4 = new ImageIcon("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/reset.png");
		int icon4Width = 75;
		int icon4Height = 50;
		Image scaledImage4 = icon4.getImage().getScaledInstance(icon4Width, icon4Height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);

        
        //Buttons werden den Icons zugewiesen 
		startButton = new JButton(scaledIcon1);
		rightButton = new JButton(scaledIcon3);
		leftButton = new JButton(scaledIcon2);
		resetButton = new JButton(scaledIcon4);
		
		//Für die schriftart
		try {
		    String fontPath = "src/joystix monospace.ttf";
//		    String fontPath = "C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/joystix monospace.ttf";
		    pixelArt = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(13f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(pixelArt);
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		
		
		//Ist Starttext vom Spiel--> wenn man den runner betätigt, dann taucht dieser text auf
		area = new JTextArea("Du lauschst dem fröhlichen Zwitschern der Vögel, "
				+ "während das sanfte Rauschen des Flusses deine Ohren umspielt. "
				+ "Perlen aus Schweiss gleiten langsam von deiner Stirn herab, "
				+ "während die Sonne ihre warmen Strahlen auf dich wirft und "
				+ "deine Augen zum Leuchten bringen.\n"
				+ "\n"
				+ "Als du erwachst, nimmst du behutsam deine Umgebung in den "
				+ "Blick. Du versuchst, die Fäden deiner Erinnerung zu "
				+ "entwirren, doch sie entziehen sich deinem Griff, wie "
				+ "Nebelschwaden im Morgenlicht.\n"
				+ "");
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setBackground(Color.black);//Hintergrund schwarz 
		area.setForeground(Color.white);//Schwrift ist weiss
		area.setFont(pixelArt);
		area.setColumns(80); 
		area.setRows(20);
		
		startButton.addActionListener(this);
		rightButton.addActionListener(this);
		leftButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		rightButton.setVisible(false);
		leftButton.setVisible(false);
		resetButton.setVisible(false);
		
		panel1.add(area);
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
		 root = new TreeNode("Ein Text wird auf dem Bildschirm angezeigt, "
		 		+ "und du hast die Möglichkeit, mithilfe des rechten oder "
		 		+ "linken Buttons zu entscheiden, wie die Geschichte deines "
		 		+ "Charakters ihren Verlauf nehmen soll. Zum Beispiel: "
		 		+ "Verwenden Sie den rechten Button, um Option A auszuwählen,"
		 		+ " und den linken Button, um Option B auszuwählen."
		 		+ "\n"
		 		+ "\n"
		 		+ "Du stehst auf und nimmst deine Umgebung nun noch intensiver wahr. "
		 		+ "Überall liegen gefallene Soldaten und der einst schöne Boden ist "
		 		+ "nun mit Menschenblut gefärbt. Dein Hals ist vor Angst "
		 		+ "ausgetrocknet. Du drehst dich nach rechts, wo ein "
		 		+ "gepflasterter Weg in Richtung eines malerischen "
		 		+ "Dorfes führt (Rechter Button). Du drehst dich vorsichtig "
		 		+ "nach links, wo das laute und schreckhafte Kriegsgeschrei "
		 		+ "herkommt (Linker Button)");
		 
		 l = new TreeNode("Du folgst den herzzerreissenden Kriegsschreie. "
		 		+ "Auf deinem Weg siehst du mehr und mehr gefallene Krieger. "
		 		+ "Der Weg wird düsterer und ist mit rotem Blut bedeckt. Verletzte "
		 		+ "Krieger strecken hilfesuchend ihre Hände nach dir aus.\n"
		 		+ "Du versuchst, ihnen zu helfen, doch ohne Erfolg… \n"
		 		+ "Schliesslich erreichst du die Kriegsbelagerung und siehst "
		 		+ "gefangene Soldaten, die verzweifelt zu dir blicken und "
		 		+ "flehentlich darum bitten, befreit zu werden. \n"
		 		+ "Du stehst vor einer schwierigen Entscheidung:\n"
		 		+ "\n"
		 		+ "Willst du einfach weitergehen und den qualvollen Anblick "
		 		+ "hinter dir lassen (rechter Button)? Oder entscheidest du "
		 		+ "dich, das bedrückende Schicksal dieser gefangenen Krieger "
		 		+ "zu ändern, indem du sie befreist und ihnen Hoffnung gibst (linker Button)?\n");
		 ll = new TreeNode("Der Schmerz der Krieger dringt tief in dein Herz, "
		 		+ "und du triffst die Entscheidung, sie aus ihrer misslichen "
		 		+ "Lage zu befreien. Als du sie freilässt, erwidern alle drei "
		 		+ "Krieger mit herzlichem Dank und versprechen, dich auf deinem "
		 		+ "bevorstehenden Weg zu begleiten. Plötzlich hört ihr feindliche "
		 		+ "Krieger, die euch belauschen. Pfeile sausen in eure Richtung, "
		 		+ "doch du und deine Gefährten stellen euch mutig der Bedrohung. "
		 		+ "Dabei erleidest du ein paar Schnittwunden, doch das hindert dich "
		 		+ "nicht daran, unbeirrt weiterzukämpfen. Mit beeindruckender "
		 		+ "Entschlossenheit eilst du auf die Angreifer zu und besiegst "
		 		+ "sie in kürzester Zeit. Deine Mitstreiter sind gleichermassen "
		 		+ "erstaunt über deine Stärke und Schnelligkeit.\n"
		 		+ "Möchtest du weiterhin den Schlachtrufen folgen (linker Button), "
		 		+ "oder möchtest du dich stattdessen mit deinen Kameraden in Richtung der Stadt bewegen (rechter Button)?\n"
		 		+ "Fortsetzung folgt...");
		 lr = new TreeNode ("Du entscheidest dich, die Krieger im Stich"
		 		+ " zu lassen und deinen eigenen Weg zu beschreiten, "
		 		+ "alleine und unbeirrt. Die Kriegsgeschreie hallen "
		 		+ "unaufhörlich in deinen Ohren wieder, während du Zeuge "
		 		+ "wirst, wie Krieger sich gegenseitig bekämpfen. "
		 		+ "Plötzlich durchzucken Pfeile die Luft auf dich "
		 		+ "gerichtet. Mit geschickten Bewegungen weichst du den"
		 		+ " Geschossen aus und fliehst rasch in den Wald, "
		 		+ "wo die Angreifer deine Spur verlieren. Dein Herz "
		 		+ "rast, doch es verlangsamt sich allmählich, und du "
		 		+ "spürst, wie ein Pfeil dein Herz durchdrungen hat. Du "
		 		+ "lehnst dich an einen Baum und schliesst langsam die Augen, "
		 		+ "während der Schlaf dich umhüllt.");
		 
		 r = new TreeNode("Du gehst mit langsamen Schritten in das abgelegene "
		 		+ "Dorf. Dein scharfes Beobachtungsvermögen bemerkt, wie zahlreiche "
		 		+ "Augenpaare dich aus den sicher verschlossenen Fenstern anstarren. "
		 		+ "Dein Bauchgefühl flüstert dir leise zu, dass du in dieser unsicheren "
		 		+ "Umgebung dein Schwert griffbereit halten solltest. Plötzlich erscheint "
		 		+ "vor dir eine Gestalt, gehüllt in einen dunkelgrünen Mantel.\n"
		 		+ "\n"
		 		+ "Deine Hände zucken in Richtung deines Schwertgriffs. Doch bevor du "
		 		+ "dich entscheidest, hältst du einen Moment inne. Möchtest du ohne "
		 		+ "Vorwarnung zum Schwert greifen, um diese rätselhafte Gestalts"
		 		+ "vertreiben (rechter Button)? Oder möchtest du zunächst erfahren, "
		 		+ "wer diese Person ist, indem du sie ansprichst und nach ihrem "
		 		+ "Anliegen fragst (linker Button)?");
		 rr = new TreeNode("Mit entschlossener Kraft ziehst du dein "
		 		+ "mächtiges Schwert und stürzt dich mutig auf die mysteriöse "
		 		+ "Gestalt zu, ohne einen Moment zu zögern. Die Gestalt versucht "
		 		+ "auszuweichen, doch du verfehlst niemals dein Ziel. In dem "
		 		+ "Augenblick, bevor dein tödlicher Schlag landet, enthüllt sich "
		 		+ "das Gesicht der Gestalt als das einer jungen, wunderschönen Frau. "
		 		+ "Doch dir wird klar, dass du deinem Schicksal nicht mehr ausweichen "
		 		+ "kannst. Sie fällt zu Boden. Du kannst sie gerade noch rechtzeitig "
		 		+ "auffangen, aber ihre Augen schliessen sich, und sie verliert ihr "
		 		+ "Bewusstsein. \n"
		 		+ "\n"
		 		+ "Die Dorfbewohner, erschrocken und wütend über das Geschehene, "
		 		+ "stürmen und greifen dich an. Trotz deiner geschickten Verteidigung "
		 		+ "und deiner beeindruckenden Kampfkünste sind ihre Zahlen einfach "
		 		+ "zu überwältigend…\n");
		 rl = new TreeNode("Du fragst mit gehobener Stimme, wer die Gestalt ist. "
		 		+ "Die Gestalt enthüllt sich und eine wunderschöne Frau steht "
		 		+ "vor dir. Sie stellt sich (Ava) vor, aber du bist von ihrer "
		 		+ "Schönheit verzaubert. Sie zieht dich an der Hand und führt "
		 		+ "dich zu ihrem Haus. Du fragst sie, wieso sie dich hierher "
		 		+ "geführt hat und Ava antwortet mit: “Unser Dorf wird von "
		 		+ "toll wütenden Soldaten angegriffen\". \"Sie plündern und "
		 		+ "greifen die Dorfbewohner an. Du spürst die Blicke der Leute "
		 		+ "auf dich ruhen, darunter Avas Eltern. Diese scheinen "
		 		+ "mit deiner Rettung nicht zufrieden zu sein. "
		 		+ "Ava: “Sie denken, dass du einer von ihnen bist, weil "
		 		+ "du so angezogen bist”. Doch du selbst weisst nicht, "
		 		+ "wer du  bist. \n"
		 		+ "Willst du weiter bei Ava und ihren Eltern bleiben "
		 		+ "(rechter Button) oder willst du das Haus verlassen (linker Button)?");
		 rlr = new TreeNode("Du verlässt das Haus und siehst, wie Soldaten das "
		 		+ "Dorf plündern. Du kannst dabei nicht seelenruhig zuschauen, "
		 		+ "willst handeln und beschliesst, darin einzugreifen. So versuchst "
		 		+ "du dich von Ava zu verabschieden, doch sie will dich davon "
		 		+ "abhalten, das Haus zu verlassen. Bei der Auseinandersetzung "
		 		+ "macht ihr auf euch aufmerksam, sodass Soldaten euch entdecken "
		 		+ "und angreifen. Du spürst die Energie in dir und dein "
		 		+ "Beschützerinstinkt setzt ein. Mühelos, wehrst du alle "
		 		+ "Angriffe ab und bringst alle deine Angreifer zum Fallen. "
		 		+ "Du bist selbst sehr von deinem Kampffähigkeiten überrascht "
		 		+ "und wunderst dich, woher du dies alles kannst. Dir bleibt "
		 		+ "deinen Überlegungen aber nicht lange Zeit, da ein Soldat "
		 		+ "Verstärkung gerufen hat. So flüchtest du mit Ava und "
		 		+ "holst dir ein Pferd vom Dorf."
		 		+ "Fortsetzung folgt...");
		 rll = new TreeNode("Ava überzeugt dich, dich und sie in ihrem "
		 		+ "Haus zu verstecken. Ihr haltet den Atem an und hofft, "
		 		+ "dass niemand das Haus betritt. Eure Hoffnungen wurden "
		 		+ "jedoch schnell zerstört, als ihr das Knarren der Haustür "
		 		+ "hört. Ehe du dich versiehst, steht der Soldat direkt vor dir. "
		 		+ "Du willst dich verteidigen, doch deine Reflexe waren zu "
		 		+ "langsam, sodass er dich mit seinem Schwertgriff ohnmächtig "
		 		+ "geschlagen hat.");
		 
		
		//Der Weg von den Nodes: Wenn du den Weg rechts einschlögst, dann wird dir der Pfad von rechts zugewiesen
		root.setLeftChild(l);
		root.setRightChild(r);
		
		r.setRightChild(rr);
		r.setLeftChild(rl);
		rr.setRightChild(r);//-->Tod
		rl.setRightChild(rlr);
		rl.setLeftChild(rll);
		rll.setLeftChild(r);//-->Tod
		rlr.setLeftChild(root);//-->fortsetzung folgt
		rlr.setRightChild(root);//-->forsetzung folgt
		
		l.setRightChild(lr);
		l.setLeftChild(ll);
		lr.setRightChild(root);//-->Tod
		ll.setLeftChild(root);//-->Fortsetzung folgt
		ll.setRightChild(root);//-->Fortsetzung folgt
		return root;
	}

	private void updateLabel(String labelText) {
        area.setText(labelText);
    }
}
