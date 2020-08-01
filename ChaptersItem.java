package com.example.thinkerlab;

public class ChaptersItem {
    String chapter, varieties, price;
    int userPhoto;

    public ChaptersItem(String chapter, String varieties, String price, int userPhoto) {
        this.chapter = chapter;
        this.varieties = varieties;
        this.userPhoto = userPhoto;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ChaptersItem() {
    }



    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
}
