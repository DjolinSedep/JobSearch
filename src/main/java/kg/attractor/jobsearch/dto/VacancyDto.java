package kg.attractor.jobsearch.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto {
    private Integer id;
    private String Name;
    private Integer expTo;
    private Integer expFrom;
    private BigDecimal salary;
    private String description;
    private Integer categoryId;
    private boolean isActive;
    private Integer authorId;


}
