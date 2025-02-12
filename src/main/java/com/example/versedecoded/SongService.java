package com.example.versedecoded;

import com.example.versedecoded.exception.SongNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SongService {
    private final OpenAIService openAIService;

    @Autowired
    public SongService(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    public Optional<Song> getSong(String title, String artist) {
        try {
            String prompt = String.format(
                "Analyze the song '%s' by %s in depth. Focus on:\n" +
                "1. Deep emotional meaning and personal interpretation\n" +
                "2. Symbolism and metaphors in the lyrics\n" +
                "3. The artist's possible inspiration and personal connection\n" +
                "4. How the song resonates with listeners\n" +
                "5. Musical composition and how it enhances the message\n\n" +
                "Please provide a thoughtful, poetic analysis that captures the soul of the song.", 
                title, artist
            );
            String interpretation = openAIService.getResponse(prompt);
            return Optional.of(new Song(title, artist, null, interpretation));
        } catch (RuntimeException e) {
            throw new SongNotFoundException("Failed to process song: " + e.getMessage());
        }
    }
}