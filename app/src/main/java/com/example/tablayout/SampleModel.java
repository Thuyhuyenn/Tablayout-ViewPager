package com.example.tablayout;

public class SampleModel {
    private String title;
    private String imageUrl; // Sử dụng URL cho đơn giản, hoặc Resource ID

    public SampleModel(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
