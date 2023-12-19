package ryhor.mudrahel.snva.bootcamp.mediaplayer.players;

import ryhor.mudrahel.snva.bootcamp.mediaplayer.MediaInfo;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.MediaFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.audio.AudioFile;

// Concrete class representing an audio player
public class AudioPlayer implements MediaPlayer, MediaInfo {
    private AudioFile audioFile;

    @Override
    public void play() {
        System.out.println("Playing " + audioFile.getFileInfo() + " audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + audioFile.getFileInfo() + " audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping " + audioFile.getFileInfo() + " audio");
    }

    @Override
    public void setMediaFile(MediaFile mediaFile) {
        this.audioFile = (AudioFile) mediaFile;
    }

    @Override
    public String getMediaInfo() {
        return "Audio file information";
    }
}
