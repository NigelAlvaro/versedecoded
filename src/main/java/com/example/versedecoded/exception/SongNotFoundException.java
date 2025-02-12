package com.example.versedecoded.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SongNotFoundException extends RuntimeException {
    
    public SongNotFoundException(String message) {
        super(message);
    }
    
    public SongNotFoundException(String title, String artist) {
        super(String.format("Song not found with title '%s' by artist '%s'", title, artist));
    }
}