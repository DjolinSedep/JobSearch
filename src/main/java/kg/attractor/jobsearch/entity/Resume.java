package kg.attractor.jobsearch.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private Integer id;
    private Integer applicantId;
    private String name;
    private Integer categoryId;
    private BigDecimal salary;
    private Integer isActive;
    private LocalDate createdDate;
    private LocalDate updatedTime;
}
