package org.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.homework")
@EnableJpaRepositories(basePackages = "org.homework")
@EntityScan(basePackages = "org.homework.entities")
public class RunAppMain implements CommandLineRunner {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RunAppMain.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Created following notebooks and saved in DB: ");
        NoteBookGenerator.getNoteBooks(20).forEach(n -> noteService.add(n));

        noteService.getAll().forEach(System.out::println);
        System.out.println("===============================================================");

        System.out.println("Get all notebooks by producer's names in descending order: ");
        noteService.getAllByProducerNamesDesc().forEach(System.out::println);
        System.out.println("===============================================================");

        System.out.println("Get all notebooks with RAM more than 16 GB: ");
        noteService.getAllWithRamMoreThan(16).forEach(System.out::println);
        System.out.println("===============================================================");

        System.out.println("Get all second hand notebooks: ");
        noteService.getAllSecondHand().forEach(System.out::println);
    }
}
