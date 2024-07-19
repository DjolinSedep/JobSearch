package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.SoftReference;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {
    private Integer id;
    private Resume resume;
    private String institution;
    private String program;
    private Date startDate;
    private Date endDate;
    private String degree;
}
