package com.example.backend.domain.dto;

import com.example.backend.domain.model.Cake;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CakeDto {

    @NotNull
    private String title;
    @NotNull
    private String desc;

    private String image;

    public CakeDto(@JsonProperty("title") String title,
                   @JsonProperty("desc")String desc,
                   @JsonProperty("image")String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public CakeDto(Cake cake) {
        this.title = cake.getTitle();
        this.desc = cake.getDesc();
        this.image = cake.getImage();
    }

    public CakeDto() {
    }

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


