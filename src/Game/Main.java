package Game;

public class Main {

	private static MusicPlayer mp;

	public static void main(String[] args)
	{
		new Actions();
		MusicPlayer mp = new MusicPlayer();
		mp.playFile("src/bird-singing.WAV");
//		mp.playFile("C:/Users/kieut/Documents/GitHub/ChooseYourOwnAdventure/src/Game/bird-singing.WAV");
        // Konnte es sehen :)
		writeText();
	}
	
	public static void writeText() {
		System.out.println("Hallo");
	}
}
