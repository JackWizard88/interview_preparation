package ru.geekbrains.interview_preparation.hw1.task1;

public class Task1Main {
    public static void main(String[] args) {
        Person person = new Person.Builder().addFirstName("Andrey").addLastName("Krylov").addAge(32).addGender("male").addCountry("Russia").build();
        System.out.println(person.getAge());
    }

}
