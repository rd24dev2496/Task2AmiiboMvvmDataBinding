package com.example.task2mvvmamiibo.data;
import com.example.task2mvvmamiibo.model.Amiibo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmiiboResponse {

    @SerializedName("amiibo")
    private List<Amiibo> amiiboList;

    public List<Amiibo> getAmiiboList() {
        return amiiboList;
    }
}
