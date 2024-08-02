package kg.attractor.jobsearch.entity;

import kg.attractor.jobsearch.model.ContactType;
import lombok.*;

@Getter
@Setter
public class ContactInfo {
    private Integer id;
    private ContactType contactType;
    private Resume resume;
    private String value;
}
