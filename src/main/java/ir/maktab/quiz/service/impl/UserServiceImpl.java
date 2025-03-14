package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.dto.SearchCriteriaDTO;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.UserDTO;
import ir.maktab.quiz.model.enums.Role;
import ir.maktab.quiz.model.enums.Status;
import ir.maktab.quiz.repo.UserRepository;
import ir.maktab.quiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setStatus(Status.PENDING);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllPendingUsers() {
        return userRepository.findByStatus(Status.PENDING);
    }

    @Override
    public User approveUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(Status.APPROVED);
        return userRepository.save(user);
    }

//    @Override
//    public List<User> searchUsers(String keyword) {
//        return userRepository.findByRoleAndFirstNameAndLastNameContaining(keyword, keyword);
//    }

    @Override
    public List<User> searchUsers(SearchCriteriaDTO searchCriteria) {
        Role role = Role.valueOf(searchCriteria.getRole().toUpperCase());
        return userRepository.findByRoleAndFirstNameContainingAndLastNameContaining(
                role,
                searchCriteria.getFirstName(),
                searchCriteria.getLastName()
        );
    }

}
