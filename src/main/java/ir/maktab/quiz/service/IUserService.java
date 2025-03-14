package ir.maktab.quiz.service;

import ir.maktab.quiz.model.dto.SearchCriteriaDTO;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.UserDTO;

import java.util.List;

public interface IUserService {

    User registerUser(UserDTO user);

    List<User> getAllPendingUsers();

    User approveUser(Long userId);

    //    List<User> searchUsers(String keyword);
    List<User> searchUsers(SearchCriteriaDTO searchCriteria);
}
