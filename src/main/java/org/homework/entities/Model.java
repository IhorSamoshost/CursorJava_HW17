package org.homework.entities;

import org.homework.enums.CorpusType;
import org.homework.enums.Processor;
import org.homework.enums.Producer;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int id;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "producer")
    @Enumerated(EnumType.STRING)
    private Producer producer;
    @Column(name = "cpu")
    @Enumerated(EnumType.ORDINAL)
    private Processor cpu;
    @Column(name = "corpus_type")
    @Enumerated(EnumType.ORDINAL)
    private CorpusType corpusType;

    public Model() {
    }

    public Model(String modelName, Producer producer, Processor cpu, CorpusType corpusType) {
        this.modelName = modelName;
        this.producer = producer;
        this.cpu = cpu;
        this.corpusType = corpusType;
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Processor getCpu() {
        return cpu;
    }

    public void setCpu(Processor cpu) {
        this.cpu = cpu;
    }

    public CorpusType getCorpusType() {
        return corpusType;
    }

    public void setCorpusType(CorpusType corpusType) {
        this.corpusType = corpusType;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + modelName + '\'' +
                ", producer=" + producer +
                ", cpu=" + cpu +
                ", corpusType=" + corpusType +
                '}';
    }
}
