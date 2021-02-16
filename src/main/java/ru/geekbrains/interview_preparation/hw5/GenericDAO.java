package ru.geekbrains.interview_preparation.hw5;

public interface GenericDAO <T> {

        void create(T o);

        T read(Long id);

        void update(T o);

        void delete(T o);
}
