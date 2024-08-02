package kg.attractor.jobsearch.entity;

import lombok.*;

@Getter
@Setter
public class RespondedApplicant {
    private Integer id;
    private Resume resume;
    private Vacancy vacancy;
    private Boolean confirmation;
}
