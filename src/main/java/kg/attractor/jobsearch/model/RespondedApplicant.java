package kg.attractor.jobsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespondedApplicant {
    private Integer id;
    private Resume resume;
    private Vacancy vacancy;
    private  boolean confirmation;

}
