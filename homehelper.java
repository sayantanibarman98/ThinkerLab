package com.example.thinkerlab;

public class homehelper {
    int image;

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String title,description;

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public homehelper(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;

    }
}
