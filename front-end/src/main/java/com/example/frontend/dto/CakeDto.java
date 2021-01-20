package com.example.frontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CakeDto {

    private String title;
    private String desc;
    private String image;

    public CakeDto(@JsonProperty("title") String title,
                   @JsonProperty("desc")String desc,
                   @JsonProperty("image")String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public CakeDto() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
