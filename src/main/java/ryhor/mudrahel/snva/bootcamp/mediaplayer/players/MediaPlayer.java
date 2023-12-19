package ryhor.mudrahel.snva.bootcamp.mediaplayer.players;

import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.MediaFile;

// Interface representing a generic media player
public interface MediaPlayer {
    void play();
    void pause();
    void stop();
    void setMediaFile(MediaFile mediaFile);
}