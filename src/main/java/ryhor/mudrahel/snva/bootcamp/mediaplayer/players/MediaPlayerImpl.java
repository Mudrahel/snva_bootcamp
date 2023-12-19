package ryhor.mudrahel.snva.bootcamp.mediaplayer.players;

import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.MediaFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.audio.AudioFile;

public class MediaPlayerImpl implements MediaPlayer {
    private MediaPlayer audioPlayer;
    private MediaPlayer videoPlayer;

    private MediaPlayer activePlayer;

    public MediaPlayerImpl() {
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
    }

    @Override
    public void play() {
        activePlayer.play();
    }

    @Override
    public void pause() {
        activePlayer.pause();
    }

    @Override
    public void stop() {
        activePlayer.stop();
    }

    @Override
    public void setMediaFile(MediaFile mediaFile) {
        switchMediaPlayer(mediaFile);

        activePlayer.setMediaFile(mediaFile);
    }

    private void switchMediaPlayer(MediaFile mediaFile) {
        if (mediaFile instanceof AudioFile) {
            System.out.println("\n===  switching to Audio player  ==");
            activePlayer = this.audioPlayer;
        } else {
            System.out.println("\n===  switching to Video player  ===");
            activePlayer = this.videoPlayer;
        }
    }
}
