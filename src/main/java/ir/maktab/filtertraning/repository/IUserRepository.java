package ir.maktab.filtertraning.repository;


import ir.maktab.filtertraning.model.Person;

public interface IUserRepository extends IBaseRepository<Person,Long>{
    Person findByUsernameAndPassword(String username, String password,String nationalCode);
}
