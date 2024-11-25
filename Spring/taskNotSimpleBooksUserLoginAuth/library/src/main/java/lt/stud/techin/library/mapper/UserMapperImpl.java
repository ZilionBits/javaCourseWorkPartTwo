package lt.stud.techin.library.mapper;

import lt.stud.techin.library.dataTransferObject.UserDto;
import lt.stud.techin.library.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole());
    }
}
