import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;

public class Logo {
    
  public static final String ANSI_CLEAR = "\033[2J\033[H";

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = ("\u001B[32m");
  public static final String ANSI_BLUE = ("\u001B[34m");

  public static void main(String[]args) throws InterruptedException{

    String[] logo = { ANSI_BLUE + " ▄████████  ▄█                                                             ",
                    ANSI_BLUE + "███    ███ ███                                                             ",
                    ANSI_BLUE + "███    █▀  ███▌                                                            ",
                    ANSI_BLUE + "███        ███▌                                                            ",
                    ANSI_BLUE + "███        ███▌                                                            ",
                    ANSI_BLUE + "███    █▄  ███                                                             ",
                    ANSI_BLUE + "███    ███ ███                                                             ",
                    ANSI_BLUE + "████████▀  █▀                                                              ",
                    "                                                                                       ",
                    ANSI_GREEN + " ▄████████    ▄████████     ███        ▄████████  ▄█  ███▄▄▄▄    ▄██████▄ ",
                    ANSI_GREEN + "███    ███   ███    ███ ▀█████████▄   ███    ███ ███  ███▀▀▀██▄ ███    ███",
                    ANSI_GREEN + "███    █▀    ███    ███    ▀███▀▀██   ███    █▀  ███▌ ███   ███ ███    ███",
                    ANSI_GREEN + "███          ███    ███     ███   ▀   ███        ███▌ ███   ███ ███    ███",
                    ANSI_GREEN + "███        ▀███████████     ███     ▀███████████ ███▌ ███   ███ ███    ███",
                    ANSI_GREEN + "███    █▄    ███    ███     ███              ███ ███  ███   ███ ███    ███",
                    ANSI_GREEN + "███    ███   ███    ███     ███        ▄█    ███ ███  ███   ███ ███    ███",
                    ANSI_GREEN + "████████▀    ███    █▀     ▄████▀    ▄████████▀  █▀    ▀█   █▀   ▀██████▀ "
    };

    System.out.println(ANSI_CLEAR);

    try {
    startupsound();
    } catch (Exception e) {
    System.err.println("Sound-Fehler: " + e.getMessage());
    e.printStackTrace();
    }
    

    for (String x : logo) {
    
      System.out.println(x);
      Thread.sleep(50);

    }


    System.out.print(ANSI_RESET);
  }

  public static void startupsound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    File file = new File("Sound/startup.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();

    clip.open(audioStream);

    clip.start();

  }

}
