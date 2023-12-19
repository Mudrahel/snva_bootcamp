package ryhor.mudrahel.snva.bootcamp.mediaplayer.players;

import ryhor.mudrahel.snva.bootcamp.mediaplayer.MediaInfo;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.MediaFile;
import ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video.VideoFile;

// Concrete class representing a video player
public class VideoPlayer implements MediaPlayer, MediaInfo {
    private VideoFile videoFile;

    @Override
    public void play() {
        System.out.println("Playing " + videoFile.getFileInfo() + " video with " + videoFile.getResolution() + " resolution");
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + videoFile.getFileInfo() + " video");
    }

    @Override
    public void stop() {
        System.out.println("Stopping " + videoFile.getFileInfo() + " video");
    }

    @Override
    public void setMediaFile(MediaFile mediaFile) {
        this.videoFile = (VideoFile) mediaFile;
    }

    @Override
    public String getMediaInfo() {
        return "Video file information";
    }
}