package ir.maktab.quiz.controller;

import ir.maktab.quiz.model.dto.SearchCriteriaDTO;
import ir.maktab.quiz.model.domainmodel.User;
import ir.maktab.quiz.model.dto.UserDTO;
import ir.maktab.quiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<UserDTO>> getPendingUsers() {
        List<User> users = userService.getAllPendingUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<UserDTO> approveUser(@PathVariable Long id) {
        User user = userService.approveUser(id);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PostMapping("/search")
    public List<User> searchUsers(@RequestBody SearchCriteriaDTO searchCriteria) {
        return userService.searchUsers(searchCriteria);
    }

}
