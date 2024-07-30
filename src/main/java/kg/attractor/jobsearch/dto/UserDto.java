package kg.attractor.jobsearch.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name ;
    private String email;
    private Integer number;
}
