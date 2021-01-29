CREATE SCHEMA notebook_store
    AUTHORIZATION postgres;

create table models
(
    model_id    serial not null
        constraint models_pk
            primary key,
    model_name  text,
    producer    text,
    cpu         integer,
    corpus_type integer
);

alter table models
    owner to postgres;

create table notes
(
    note_id     serial not null
        constraint notes_pk
            primary key,
    id_model    integer
        constraint notes_models_model_id_fk
            references models
            on update cascade on delete set null,
    ram         integer,
    second_hand boolean,
    price       integer,
    year        integer
);

alter table notes
    owner to postgres;


