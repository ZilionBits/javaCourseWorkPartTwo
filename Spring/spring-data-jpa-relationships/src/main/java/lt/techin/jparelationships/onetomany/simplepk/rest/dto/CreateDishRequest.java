package lt.techin.jparelationships.onetomany.simplepk.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDishRequest {

    @Schema(example = "Pizza Salami")
    @NotBlank
    private String name;
}
