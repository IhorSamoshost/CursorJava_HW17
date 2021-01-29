package org.homework.entities;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class NoteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private int id;
    @JoinColumn(name = "id_model")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Model model;
    @Column(name = "ram")
    private int ram;
    @Column(name = "second_hand")
    private boolean secondHand;
    @Column(name = "price")
    private int price;
    @Column(name = "year")
    private int year;

    public NoteBook() {
    }

    public NoteBook(Model model, int ram, boolean isSecondHand, int price, int year) {
        this.model = model;
        this.ram = ram;
        this.secondHand = isSecondHand;
        this.price = price;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isSecondHand() {
        return secondHand;
    }

    public void setSecondHand(boolean secondHand) {
        this.secondHand = secondHand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "id=" + id +
                ", model=" + model +
                ", ram=" + ram +
                ", isSecondHand=" + secondHand +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
