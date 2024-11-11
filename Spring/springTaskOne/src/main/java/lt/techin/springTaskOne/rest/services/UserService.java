package lt.techin.springTaskOne.rest.services;

import lt.techin.springTaskOne.rest.users.UserPrank;
import lt.techin.springTaskOne.rest.dto.UserRequest;

import java.util.List;

public interface UserService {

    List<UserPrank> getAll();
    UserPrank createUser(UserRequest newUser);
    UserPrank getUser(Long id);
    UserPrank updateUser(UserRequest userRequest, Long id);
    void deleteUser(Long id);
}
