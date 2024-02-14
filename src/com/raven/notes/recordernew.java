
package com.raven.notes;



import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;

public class recordernew {
    
    private TargetDataLine targetLine;
    
    public void startRecording(String fileName) {
        try {
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
            DataLine.Info dataInfo = new DataLine.Info (TargetDataLine.class, audioFormat);
            
            if (!AudioSystem.isLineSupported(dataInfo)) {
                System.out.println("Not supported");
                return;
            }
            
            targetLine = (TargetDataLine) AudioSystem.getLine(dataInfo);
            targetLine.open();
            
            
            targetLine.start();
            
            Thread audioRecorderThread = new Thread(() -> {
                AudioInputStream recordingStream = new AudioInputStream(targetLine);
                File outputFile = new File(fileName+".wav");
                
                try {
                    AudioSystem.write(recordingStream, AudioFileFormat.Type.WAVE, outputFile);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                System.out.println("Stopped recording");
            });
            
            audioRecorderThread.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void stopRecording() {
        if (targetLine != null) {
            targetLine.stop();
            targetLine.close();
        }
    }
}

