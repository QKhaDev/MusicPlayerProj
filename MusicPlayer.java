
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
    public static void main(String[] args) {
        String filePath = "DNA 雨海ルカcover.wav";
        File file = new File(filePath);

        try (Scanner sc = new Scanner(System.in);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String option = "";
            while (!option.equals("Q")) {
                System.out.println("P : Play");
                System.out.println("S : Stop");
                System.out.println("R : Reset");
                System.out.println("Q : Quit");
                System.out.println("L : loop");
                System.out.println("what is your option?");
                option = sc.next().toUpperCase();

                switch (option) {
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q":
                        clip.close();
                        break;
                    case "L":
                        clip.loop(Integer.MAX_VALUE);
                        break;
                    default:
                        System.out.println("invalid option");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        } catch (LineUnavailableException e) {
            System.out.println("File is unavailable");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("This file is not supported");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("Buh bye");
        }
    }
}
