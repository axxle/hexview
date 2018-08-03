package ru.axxle.hexview.pojo;

public class ViewItem {
    private String hexLine;
    private String specLine;
    private String annotateLine;

    public ViewItem() {}

    public String getHexLine() {
        return hexLine;
    }

    public void setHexLine(String hexLine) {
        this.hexLine = hexLine;
    }

    public String getSpecLine() {
        return specLine;
    }

    public void setSpecLine(String specLine) {
        this.specLine = specLine;
    }

    public String getAnnotateLine() {
        return annotateLine;
    }

    public void setAnnotateLine(String annotateLine) {
        this.annotateLine = annotateLine;
    }
}
