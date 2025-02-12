package com.example.versedecoded;

import com.example.versedecoded.exception.SongNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Controller for handling song-related operations
 */
@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "*")
public class SongController {
    private static final Logger logger = LoggerFactory.getLogger(SongController.class);
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    /**
     * Retrieves a song interpretation based on title and artist
     *
     * @param title The title of the song
     * @param artist The artist of the song
     * @return ResponseEntity containing the Song with interpretation or not found status
     */
    @GetMapping("/analyze")
    public ResponseEntity<Song> analyzeSong(
            @RequestParam String title,
            @RequestParam String artist) {
        logger.info("Analyzing song: '{}' by '{}'", title, artist);
        return songService.getSong(title, artist)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new SongNotFoundException(title, artist));
    }
}