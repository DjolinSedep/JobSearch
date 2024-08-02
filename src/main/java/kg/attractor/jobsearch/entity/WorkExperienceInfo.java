package kg.attractor.jobsearch.entity;


import lombok.*;

@Getter
@Setter
public class WorkExperienceInfo {
    private Integer id;
    private Resume resume;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;
}
