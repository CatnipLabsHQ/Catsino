package com.catsino;

import javax.sound.sampled.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.catsino.tools.GameData.Ansi.*;

public class Startup {

  public static void startupMain() throws InterruptedException {

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
      System.err.println("Sound Error");
    }

    for (String x : logo) {

      System.out.println(x);
      Thread.sleep(50);

    }

    Thread.sleep(1000);

    System.out.print(ANSI_RESET);
  }

  public static void startupsound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    
    InputStream inputStream = Startup.class.getResourceAsStream("/sound/startup.wav");
    if (inputStream == null) {
      throw new FileNotFoundException("Sound not found: /sound/startup.wav");
    }

    AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
    Clip clip = AudioSystem.getClip();

    clip.open(audioStream);

    clip.start();

  }

}
