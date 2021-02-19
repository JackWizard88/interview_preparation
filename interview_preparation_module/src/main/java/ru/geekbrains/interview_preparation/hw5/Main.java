package ru.geekbrains.interview_preparation.hw5;

public class Main {
    public static void main(String[] args) {

        User u = new User("Bob");
        GenericDAO dao = new GenericDAOImpl(User.class);

        dao.create(u);
    }
}
