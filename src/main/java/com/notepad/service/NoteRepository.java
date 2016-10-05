package com.notepad.service;

import com.notepad.model.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<NoteEntity, Long> { }
