package org.homework;

import org.homework.entities.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<NoteBook, Integer> {

    List<NoteBook> findByOrderByModel_ProducerDesc();

    List<NoteBook> findAllByRamIsGreaterThan(Integer mem);

    List<NoteBook> findAllBySecondHandIsTrue();

}
