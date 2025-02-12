package com.example.versedecoded;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String artist;
    
    @Column(columnDefinition = "TEXT")
    private String lyrics;
    
    @Column(columnDefinition = "TEXT")
    private String interpretation;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected Song() {
        this.createdAt = LocalDateTime.now();
    }

    public Song(String title, String artist, String lyrics, String interpretation) {
        this();
        this.title = title;
        this.artist = artist;
        this.lyrics = lyrics;
        this.interpretation = interpretation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    
    public String getLyrics() { return lyrics; }
    public void setLyrics(String lyrics) { this.lyrics = lyrics; }
    
    public String getInterpretation() { return interpretation; }
    public void setInterpretation(String interpretation) { this.interpretation = interpretation; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
}
