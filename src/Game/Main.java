package Game;

public class Main {

	public static void main(String[] args) 
	{
		new Actions();
		MusicPlayer mp = new MusicPlayer();
		mp.playFile("/Users/eldarakhundzada/Documents/GitHub/ChooseYourOwnAdventure/src/Game/bird-singing.WAV");
		//mp.playFile("Truc");
	}
}
