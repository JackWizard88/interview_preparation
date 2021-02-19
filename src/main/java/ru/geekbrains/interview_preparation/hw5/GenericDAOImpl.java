package ru.geekbrains.interview_preparation.hw5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericDAOImpl <T> implements GenericDAO <T> {

    private static SessionFactory sessionFactory;
    private final Class<T> type;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void create(T o) {
        getSession().save(o);
    }

    @Override
    public T read(Long id) {
        return getSession().get(type, id);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure("configs/hibernate.mock.cfg.xml").buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    private Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
}
