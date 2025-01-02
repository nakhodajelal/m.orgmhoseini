package ir.maktab.filtertraning.repository.impl;

import ir.maktab.filtertraning.model.Person;
import ir.maktab.filtertraning.repository.IUserRepository;
import ir.maktab.filtertraning.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

public class UserRepositoryImpl extends BaseRepositoryImpl<Person,Long>implements IUserRepository {
    private final EntityManagerFactory emf = JPAUtil.getEmf();
    @Override
    public Person findByUsernameAndPassword(String username, String password,String nationalCode) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Person p WHERE p.username = :username AND p.password = :password AND p.nationalCode=:nationalCode", Person.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .setParameter("nationalCode", nationalCode)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }
    @Override
    Class<Person> getEntityClass() {
        return Person.class;
    }
}
