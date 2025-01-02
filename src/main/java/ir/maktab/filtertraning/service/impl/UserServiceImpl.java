package ir.maktab.filtertraning.service.impl;

import ir.maktab.filtertraning.model.Person;
import ir.maktab.filtertraning.model.dto.CreateUserRequest;
import ir.maktab.filtertraning.model.dto.CreateUserResponse;
import ir.maktab.filtertraning.repository.IUserRepository;
import ir.maktab.filtertraning.repository.impl.UserRepositoryImpl;
import ir.maktab.filtertraning.service.IUserService;

public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository=new UserRepositoryImpl();

    public UserServiceImpl() {
    }

    @Override
    public CreateUserResponse addUser(CreateUserRequest createUserRequest) {
        Person person = Person.builder()
                .nationalCode(createUserRequest.getNationalCode())
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .build();

        userRepository.save(person);

        if (person.getId() == null) {
            throw new RuntimeException("Failed to save the user.");
        }

        return CreateUserResponse.builder()
                .id(person.getId())
                .nationalCode(person.getNationalCode())
                .username(person.getUsername())
                .build();
    }

    @Override
    public Person authenticateUser(String username, String password, String nationalCode) {
        Person person = userRepository.findByUsernameAndPassword(username, password, nationalCode);
        return person;
    }
}
