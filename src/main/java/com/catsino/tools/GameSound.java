package com.catsino.tools;

import javax.sound.sampled.*;
import java.io.InputStream;

public class GameSound {


  public static final String WIN = "/sound/startup.wav";

  
  public static void soundWin() {
    play(WIN);
  }

  private static void play(String path) {
    new Thread(() -> {
      try {
        InputStream input = GameSound.class.getResourceAsStream(path);
        AudioInputStream audio = AudioSystem.getAudioInputStream(input);
        Clip clip = AudioSystem.getClip();

        clip.addLineListener(e -> { 
          if (e.getType() == LineEvent.Type.STOP) {
            clip.close();
          }
        });

        clip.open(audio);
        clip.start();
        System.out.print("");

        while (clip.isRunning()) {
          Thread.sleep(100);
        }
        clip.close();

      } catch (Exception e) {
        System.err.println("Sound Error: " + path);
      }
    }).start();
  }
}
