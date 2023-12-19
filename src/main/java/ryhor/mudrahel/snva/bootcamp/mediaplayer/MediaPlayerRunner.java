package ryhor.mudrahel.snva.bootcamp.mediaplayer;

import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.MediaFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.audio.AudioFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.audio.MP3;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.audio.WAV;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video.AVI;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video.MOV;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video.VideoFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.players.AudioPlayer;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.players.MediaPlayer;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.players.MediaPlayerImpl;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.players.VideoPlayer;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerRunner {

    public static void main(String[] args) {
        runDemo();
    }

    private static void runDemo() {
        List<MediaFile> files = prepareFilesForDemo();

        MediaPlayer mediaPlayer = new MediaPlayerImpl();

        for (MediaFile file : files) {
            mediaPlayer.setMediaFile(file);
            sleep();
            mediaPlayer.play();
            mediaPlayer.pause();
            mediaPlayer.stop();
            sleep();
        }
    }

    private static List<MediaFile> prepareFilesForDemo() {
        List<MediaFile> files = new ArrayList<>();
        files.add(new MP3());
        files.add(new AVI("480x640"));
        files.add(new WAV());
        files.add(new MOV("1368x1760"));
        return files;
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the InterruptedException if necessary
            e.printStackTrace();
        }
    }
}