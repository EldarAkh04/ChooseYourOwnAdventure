package Game;

public class Main {

	private static MusicPlayer mp;

	public static void main(String[] args)
	{
		new Actions();
		MusicPlayer mp = new MusicPlayer();
//		mp.playFile("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/bird-singing.WAV");
		mp.playFile("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/bird-singing.WAV");
        // okay das sollte jetzt funktionieren... hoffentlich kannst du sehen, dass ich etwas commited und dann gepushed habe :)
	}
}
