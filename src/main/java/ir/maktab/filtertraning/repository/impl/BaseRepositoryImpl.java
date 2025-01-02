package ir.maktab.filtertraning.repository.impl;

import ir.maktab.filtertraning.model.BaseEntity;
import ir.maktab.filtertraning.repository.IBaseRepository;
import ir.maktab.filtertraning.util.JPAUtil;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

@Getter
public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable> implements IBaseRepository<T, ID> {

    private final EntityManagerFactory emf = JPAUtil.getEmf();

    abstract Class<T> getEntityClass();


    @Override
    public void save(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            System.out.println("Saved entity ID: " + entity.getId());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to save entity: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to update entity: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T findById(ID id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager
                .createQuery("from " + getEntityClass().getSimpleName(), getEntityClass())
                .getResultList();
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T t = entityManager.find(getEntityClass(), entity.getId());
            entityManager.remove(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to delete entity: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
