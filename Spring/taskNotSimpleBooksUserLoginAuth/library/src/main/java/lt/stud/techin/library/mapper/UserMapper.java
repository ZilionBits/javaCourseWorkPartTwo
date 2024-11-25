package lt.stud.techin.library.mapper;


import lt.stud.techin.library.dataTransferObject.UserDto;
import lt.stud.techin.library.model.User;

public interface UserMapper {

    UserDto toUserDto(User user);
}