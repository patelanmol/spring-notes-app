package com.example.notes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateNoteRequest {

    @NotBlank(message = "Content must not be empty")
    private String content;

    @NotBlank(message = "Title must not be empty")
    private String title;
}
