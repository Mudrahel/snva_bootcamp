package ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video;

public class AVI implements VideoFile {
    private String resolution;

    public AVI(String resolution) {
        this.resolution = resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public String getFileInfo() {
        return "AVI file";
    }


}
