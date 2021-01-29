package org.homework;

import org.homework.entities.Model;
import org.homework.entities.NoteBook;
import org.homework.enums.CorpusType;
import org.homework.enums.Processor;
import org.homework.enums.Producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NoteBookGenerator {
    private static final Random RANDOM = new Random();
    private static final List<Integer> RAMS = Arrays.asList(4, 6, 8, 16, 24, 32, 64);
    private static final List<Boolean> BOOLEAN_LIST = Arrays.asList(true, false);
    private static final int MIN_PRICE = 1000;
    private static final int MAX_PRICE = 4000;
    private static final int MIN_YEAR = 2015;
    private static final int MAX_YEAR = 2021;

    private static Model getNewModel() {
        Model newModel = new Model();
        newModel.setProducer(Arrays.asList(Producer.values()).get(RANDOM.nextInt(Producer.values().length)));
        newModel.setCpu(Arrays.asList(Processor.values()).get(RANDOM.nextInt(Processor.values().length)));
        newModel.setCorpusType(Arrays.asList(CorpusType.values()).get(RANDOM.nextInt(CorpusType.values().length)));
        return newModel;
    }

    private static NoteBook createNewNoteBook() {
        int ram = RAMS.get(RANDOM.nextInt(RAMS.size()));
        boolean secondHand = BOOLEAN_LIST.get(RANDOM.nextInt(BOOLEAN_LIST.size()));
        int year = MIN_YEAR + RANDOM.nextInt(MAX_YEAR - MIN_YEAR);
        int price = secondHand ?
                MIN_PRICE + RANDOM.nextInt(MAX_PRICE - MIN_PRICE) * (year - MIN_YEAR) / (MAX_YEAR - MIN_YEAR) / 2
                : MIN_PRICE + RANDOM.nextInt(MAX_PRICE - MIN_PRICE) * (year - MIN_YEAR) / (MAX_YEAR - MIN_YEAR);
        return new NoteBook(getNewModel(), ram, secondHand, price, year);
    }

    public static List<NoteBook> getNoteBooks(int count) {
        List<NoteBook> noteBooks = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String modelName = "Model_" + i;
            NoteBook noteBook = createNewNoteBook();
            noteBook.getModel().setModelName(modelName);
            noteBooks.add(noteBook);
        }
        return noteBooks;
    }
}
