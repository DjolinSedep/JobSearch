package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto {
    private Integer id;
    @NotBlank
    private String Name;
    @NotNull
    private Integer expTo;
    @NotNull
    private Integer expFrom;
    @NotNull
    private double salary;
    private String description;
    @NotNull
    private Integer categoryId;
    private boolean isActive;
    @NotNull
    private Integer authorId;



}
