package ir.maktab.filtertraning.service;

import ir.maktab.filtertraning.model.Person;
import ir.maktab.filtertraning.model.dto.CreateUserRequest;
import ir.maktab.filtertraning.model.dto.CreateUserResponse;

public interface IUserService {

    CreateUserResponse addUser(CreateUserRequest createUserRequest);
    Person authenticateUser(String username, String password, String nationalCode);
}
