package com.example.criclowa.Model;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("snippet")
    public Snippet snippet;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
}
