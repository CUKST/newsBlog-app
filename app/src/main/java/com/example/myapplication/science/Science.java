package com.example.myapplication.science;

public class Science {
    public   String newDate;
    public   String newsImage;
    public   String newsArthur;
    public   String newsDescription;
    public String newsTitle;
    public String url;

    public Science(String newDate, String newsImage, String newsArthur, String newsDescription, String newsTitle, String url) {
        this.newDate = newDate;
        this.newsImage = newsImage;
        this.newsArthur = newsArthur;
        this.newsDescription = newsDescription;
        this.newsTitle = newsTitle;
        this.url = url;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsArthur() {
        return newsArthur;
    }

    public void setNewsArthur(String newsArthur) {
        this.newsArthur = newsArthur;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
