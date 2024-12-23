package lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleRequest {

    @Schema(example = "Comparison between Springboot and Play Framework")
    @NotBlank
    private String title;
}
