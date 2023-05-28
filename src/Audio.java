import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    private Clip clip;

    public Audio(String song) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(song);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();


    }

    public void stopAudio() {
        this.clip.stop();
    }

    public void StartAudio() {
        this.clip.start();
    }
}