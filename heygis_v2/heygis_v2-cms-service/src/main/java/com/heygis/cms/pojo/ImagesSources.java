package com.heygis.cms.pojo;

import java.io.Serializable;

/**
 * 图片资源表
 */
public class ImagesSources implements Serializable {

    private static final long serialVersionUID = -6854893550847099503L;

    private Integer imgID;

    private String imgName;

    private String imgLink;

    private String display;

    private String type;

    private Integer uploader;

    public Integer getImgID() {
        return imgID;
    }

    public void setImgID(Integer imgID) {
        this.imgID = imgID;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUploader() {
        return uploader;
    }

    public void setUploader(Integer uploader) {
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return "ImagesSources{" +
                "imgID=" + imgID +
                ", imgName='" + imgName + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", display='" + display + '\'' +
                ", type='" + type + '\'' +
                ", uploader=" + uploader +
                '}';
    }
}
