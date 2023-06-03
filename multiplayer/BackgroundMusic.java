import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundMusic {
    public void backgroundMusic() {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                try {    
                java.net.URL inurl=this.getClass().getResource("bgm.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(inurl));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);    
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            //}
        //});
    }
}