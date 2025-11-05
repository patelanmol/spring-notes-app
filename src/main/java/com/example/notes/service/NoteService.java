package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(String content) {
        Note note = new Note();
        note.setContent(content);
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note updateNote(Long id, Note updatedNote) {
        return noteRepository.findById(id)
                .map(n -> {
                    n.setTitle(updatedNote.getTitle());
                    n.setContent(updatedNote.getContent());
                    return noteRepository.save(n);
                })
                .orElse(null);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
