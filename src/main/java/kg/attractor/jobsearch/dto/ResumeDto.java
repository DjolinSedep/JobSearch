package kg.attractor.jobsearch.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResumeDto {
    private Integer id;
    private Integer category_id;
    private Integer  applicant_id;
    private String name;
    private BigDecimal salary;
    private Integer isActive;


}
