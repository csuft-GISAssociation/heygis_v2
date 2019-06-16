package com.heygis.pojo;

import java.io.Serializable;

/**
 * 资源表
 */
public class Sources  implements Serializable {
    private static final long serialVersionUID = -6041918458761329529L;

    private Integer id;

    private String name;

    private String introduction;

    private String file_size;

    private String download_link;

    private String download_link_offical;

    private String upload_time;

    private Integer download_times;

    private String level;

    private String uploader;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    public String getDownload_link_offical() {
        return download_link_offical;
    }

    public void setDownload_link_offical(String download_link_offical) {
        this.download_link_offical = download_link_offical;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public Integer getDownload_times() {
        return download_times;
    }

    public void setDownload_times(Integer download_times) {
        this.download_times = download_times;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}