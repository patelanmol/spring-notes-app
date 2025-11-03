package com.example.notes.controller;

import com.example.notes.model.Note;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return notes;
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        notes.removeIf(n -> n.getId().equals(id));
    }
}

