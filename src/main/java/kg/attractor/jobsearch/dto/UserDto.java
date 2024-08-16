package kg.attractor.jobsearch.dto;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.constraints.*;
import kg.attractor.jobsearch.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {


    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private Integer age;
    @NotBlank
    private String phoneNumber;
    @Email
    private String email;
    @Size(min = 4, max = 24, message = "Length must be >= 4 and <= 24")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Should contain at least one uppercase letter, one number")
    private String password;
    private boolean getAccountType;


}
