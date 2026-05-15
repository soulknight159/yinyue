package cn.itcast.yinyue.bean;

import java.io.Serializable;

public class Music implements Serializable {
    // ========== 原有字段 ==========
    private Integer id;          // 本地音乐在 MediaStore 中的 _id，网络音乐可为 null
    private String title;        // 歌曲标题
    private Long duration;    // 时长（毫秒）
    private String artist;       // 艺术家
    private String album;        // 专辑
    private String type;         // 文件类型（如 "mp3"），可保留用于本地
    private Long size;         // 文件大小（字符串形式）
    private String path;         // 本地路径 或 Content Uri 字符串（本地音乐使用）
    private String url;          // 网络音乐的 URL（在线播放地址）
    private int sourceType;      // 来源类型：0 = 本地，1 = 网络
    public boolean isLocal() {
        return sourceType == 0;
    }

    public boolean isNetwork() {
        return sourceType == 1;
    }

    // 获取可用的数据源字符串（本地返回 path，网络返回 url）
    public String getDataSource() {
        return isLocal() ? path : url;
    }

    // ========== Getter / Setter ==========
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }
}