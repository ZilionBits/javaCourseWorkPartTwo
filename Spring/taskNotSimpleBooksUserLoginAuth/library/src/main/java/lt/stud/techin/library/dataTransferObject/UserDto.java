package lt.stud.techin.library.dataTransferObject;

import java.time.ZonedDateTime;

public record UserDto(Long id, String username, String name, String email, String role) {

    public record OrderDto(String id, String description, ZonedDateTime createdAt) {
    }
}