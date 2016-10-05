package com.notepad.rest;

import com.notepad.model.Note;
import com.notepad.service.NoteRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
public class NoteRestController {
    
    private static final Logger log = Logger.getLogger(NoteRestController.class);
    
    @Autowired
    private NoteRepository noteRepo;

    /**
     * Usługa zwracająca wszystkie wpisy
     * <br>
     * @return List<NoteEntity>
     */
    @GetMapping("/all")
    public @ResponseBody List<Note> all() {
        log.info("/all");
        return StreamSupport.stream(noteRepo.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
    /**
     * Usługa zwracająca notatkę o id podanym w ścieżce żądania
     * <br>
     * @param id notatki
     * @return NoteEntity
     */
    @GetMapping("{note}/single")
    public @ResponseBody Note single(@PathVariable(name = "note", required = true) Long id) {
        log.info(id + "/single");
        return noteRepo.findOne(id);
    }
    
    /**
     * Usługa dodająca notatkę do bazy
     * <br>
     * @param note 
     */
    @PostMapping("/add")
    public void add(@RequestBody Note note) {
        log.info("/add " + note);
        noteRepo.save(note);
    }
}
