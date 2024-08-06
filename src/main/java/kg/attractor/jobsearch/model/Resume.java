package kg.attractor.jobsearch.model;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {
 private Integer id;
 private Integer applicantId;
 private String name;
 private Integer categoryId;
 private double salary;
 private boolean isActive;
 private LocalDate createdDate;
 private LocalDate updatedTime;

}
