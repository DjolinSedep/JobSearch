package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResumeDto {
    private Integer id;
    @NotNull
    private Integer category_id;
    @NotNull
    private Integer  applicant_id;
    @NotNull
    private String name;
    @NotNull
    private double salary;
    private boolean isActive;


}
