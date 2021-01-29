package org.homework;

import org.homework.entities.NoteBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepo noteRepo;

    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public String add(NoteBook noteBook) {
        if (noteBook == null) {
            return "You are trying to save in DB notebook = null!";
        }
        if (noteRepo.existsById(noteBook.getId())) {
            return String.format("Creating of notebook with id=%d is impossible: this notebook already exists in DB",
                    noteBook.getId());
        }
        return noteRepo.save(noteBook).toString() + " is created";
    }

    public NoteBook get(NoteBook noteBook) {
        return noteRepo.getOne(noteBook.getId());
    }

    public List<NoteBook> getAll() {
        return noteRepo.findAll();
    }

    public String update(NoteBook noteBook) {
        if (noteRepo.existsById(noteBook.getId())) {
            return noteRepo.save(noteBook).toString() + " is updated";
        }
        return String.format("Updating of notebook with id=%d is impossible: there is no it in DB",
                noteBook.getId());
    }

    public String delete(NoteBook noteBook) {
        if (noteRepo.existsById(noteBook.getId())) {
            noteRepo.delete(noteBook);
            return String.format("The notebook with id=%d is deleted", noteBook.getId());
        }
        return String.format("Deleting of notebook with id=%d is impossible: there is no it in DB", noteBook.getId());
    }

    public List<NoteBook> getAllByProducerNamesDesc() {
        return noteRepo.findByOrderByModel_ProducerDesc();
    }

    public List<NoteBook> getAllWithRamMoreThan(int minRam) {
        return noteRepo.findAllByRamIsGreaterThan(minRam);
    }

    public List<NoteBook> getAllSecondHand() {
        return noteRepo.findAllBySecondHandIsTrue();
    }


}
