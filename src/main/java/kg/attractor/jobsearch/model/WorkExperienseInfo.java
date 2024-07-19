package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienseInfo {
    private Integer id;
    private Resume resume;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;

}
