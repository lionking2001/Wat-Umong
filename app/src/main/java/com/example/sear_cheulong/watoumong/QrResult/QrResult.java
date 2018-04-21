package com.example.sear_cheulong.watoumong.QrResult;

/**
 * Created by nayza on 21/4/2561.
 */

public class QrResult {

    private String keyword;
    private String title;
    private String description;
    private int img;

    public QrResult() {
        keyword = "";
        title = "title here";
        description = "description here";
        img = 0;
    }

    public QrResult(String keyword, String title, String description, int img) {
        this.keyword = keyword;
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
