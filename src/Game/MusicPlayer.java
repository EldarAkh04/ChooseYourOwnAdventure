package Game;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MusicPlayer {

	 private AdvancedPlayer player;

	    public MusicPlayer()
	    {
	        player = null;
	    }
	    
	    public void playFile(String dateiname)
	    {
	        try {
	        	playerPrepare(dateiname);
	            player.play(500);
	        }
	        catch(JavaLayerException e) {
	        	reportProblem(dateiname);
	        }
	        finally {
	            killPlayer();
	        }
	    }
	    
	    public void startPlay(final String dateiname)
	    {
	        try {
	        	playerPrepare(dateiname);
	            Thread playerThread = new Thread() {
	                public void run()
	                {
	                    try {
	                        player.play(5000);
	                    }
	                    catch(JavaLayerException e) {
	                    	reportProblem(dateiname);
	                    }
	                    finally {
	                        killPlayer();
	                    }
	                }
	            };
	            playerThread.start();
	        }
	        catch (Exception ex) {
	        	reportProblem(dateiname);
	        }
	    }
	    
	    public void stop()
	    {
	        killPlayer();
	    }


	    private void playerPrepare(String dateiname)
	    {
	        try {
	            InputStream is = gibEingabestream(dateiname);
	            player = new AdvancedPlayer(is, erzeugeAudiogeraet());
	        }
	        catch (IOException e) {
	        	reportProblem(dateiname);
	            killPlayer();
	        }
	        catch(JavaLayerException e) {
	        	reportProblem(dateiname);
	            killPlayer();
	        }
	    }


	    private InputStream gibEingabestream(String dateiname)
	            throws IOException
	    {
	        return new BufferedInputStream(
	                new FileInputStream(dateiname));
	    }


	    private AudioDevice erzeugeAudiogeraet()
	            throws JavaLayerException
	    {
	        return FactoryRegistry.systemRegistry().createAudioDevice();
	    }


	    private void killPlayer()
	    {
	        synchronized(this) {
	            if(player != null) {
	                player.stop();
	                player = null;
	            }
	        }
	    }


	    private void reportProblem(String dateiname)
	    {
	        System.out.println("Es gab ein Problem beim Abspielen von: " + dateiname);
	    }

}
