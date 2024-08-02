package kg.attractor.jobsearch.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    private Integer id;
    private String name;
    private String description;
    private Integer categoryId;
    private BigDecimal salary;
    private Integer expFrom;
    private Integer expTo;
    private Boolean isActive;
    private Integer authorId;
    private LocalDate createdDate;
    private LocalDate updateDate;
}
