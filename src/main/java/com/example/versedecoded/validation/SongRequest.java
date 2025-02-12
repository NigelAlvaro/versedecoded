package com.example.versedecoded.validation;

import jakarta.validation.constraints.NotBlank;

public class SongRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Artist is required")
    private String artist;

    // Constructors
    public SongRequest() {}

    public SongRequest(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}