package kg.attractor.jobsearch.dto;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import kg.attractor.jobsearch.model.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    @NotBlank
    @Email
    @NotBlank
    @Size(min = 4, max = 24, message = "Length must be >= 4 and <= 24")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$", message = "Should contain at least one uppercase letter, one number")
    private Integer id;
    private String name;
    private String surname;
    private Integer phoneNumber;
    private Integer age;
    private String email;
    private String password;

}
