package kg.attractor.jobsearch.entity;

import kg.attractor.jobsearch.model.RespondedApplicant;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
public class Massage {
    private Integer id;
    private RespondedApplicant respondentApplicant;
    private String content;
    private Date timestamp;
}
