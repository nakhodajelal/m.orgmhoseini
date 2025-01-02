package ir.maktab.filtertraning.repository;

import ir.maktab.filtertraning.model.BaseEntity;

import java.io.Serializable;
import java.util.List;


public interface IBaseRepository <T extends BaseEntity<ID>,ID extends Serializable>{

    void save(T entity);
    void update(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);

}
