package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class Match {


    @SerializedName("unique_id")
    public String unique_id;


    @SerializedName("description")
    public String description;

    @SerializedName("title")
    public String title;


    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
