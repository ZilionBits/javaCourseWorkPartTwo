package lt.techin.springTaskOne.rest.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;

}
