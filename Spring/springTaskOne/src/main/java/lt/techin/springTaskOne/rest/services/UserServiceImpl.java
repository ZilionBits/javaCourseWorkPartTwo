package lt.techin.springTaskOne.rest.services;

import lt.techin.springTaskOne.rest.users.UserPrank;
import lt.techin.springTaskOne.rest.repository.UsersRepository;
import lt.techin.springTaskOne.rest.dto.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserPrank> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public UserPrank createUser(UserRequest newUser) {

        UserPrank user = new UserPrank();

        user.setUserName(newUser.getUserName());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());

        usersRepository.save(user);

        return user;
    }

    @Override
    public UserPrank getUser(Long id) {
        return usersRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public UserPrank updateUser(UserRequest userRequest, Long id) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setUserName(userRequest.getUserName());
                    user.setFirstName(userRequest.getFirstName());
                    user.setLastName(userRequest.getLastName());
                    user.setEmail(userRequest.getEmail());
                    return usersRepository.save(user);
                })
                .orElseThrow();
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
