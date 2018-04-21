package com.example.sear_cheulong.watoumong.GeneralInformation;

/**
 * Created by nayza on 20/4/2561.
 */

public class GeneralInformation {

    private String title;
    private String description;
    private int img;

    public GeneralInformation(String title, String description, int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public GeneralInformation() {
        this.title = "";
        this.description = "";
        this.img = 0;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
}
