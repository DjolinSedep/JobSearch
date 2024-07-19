package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
 private Integer id;
 private User applicant;
 private String name;
 private Category category;
 private Integer salary;
 private boolean isActive;
 private Category createDate;
 private float updateTime;

}
