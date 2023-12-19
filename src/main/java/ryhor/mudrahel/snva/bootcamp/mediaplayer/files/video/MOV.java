package ryhor.mudrahel.snva.bootcamp.mediaplayer.files.video;

public class MOV implements VideoFile {

    private String resolution;

    public MOV(String resolution) {
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
        return "MOV file";
    }
}
