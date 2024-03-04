package Game;

public class Main {

	private static MusicPlayer mp;

	public static void main(String[] args)
	{
		new Actions();
		MusicPlayer mp = new MusicPlayer();
		while(true) {
		mp.playFile("src/Mittelalter.mp3");
		}
	}
}
