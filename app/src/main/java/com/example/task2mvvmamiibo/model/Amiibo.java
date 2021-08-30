package com.example.task2mvvmamiibo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Amiibo implements Serializable {
        @SerializedName("amiiboSeries")
        private String amiiboSeries;
        @SerializedName("character")
        private String character;
        @SerializedName("gameSeries")
        private String gameSeries;
        @SerializedName("head")
        private String head;
        @SerializedName("image")
        private String image;
        @SerializedName("name")
        private String name;

    public String getAmiiboSeries() {
        return amiiboSeries;
    }

    public void setAmiiboSeries(String amiiboSeries) {
        this.amiiboSeries = amiiboSeries;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getGameSeries() {
        return gameSeries;
    }

    public void setGameSeries(String gameSeries) {
        this.gameSeries = gameSeries;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
