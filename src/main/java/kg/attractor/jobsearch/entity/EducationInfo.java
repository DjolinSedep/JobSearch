package kg.attractor.jobsearch.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class EducationInfo {
    private Integer id;
    private Resume resume;
    private String institution;
    private String program;
    private Date startDate;
    private Date endDate;
    private String degree;
}
