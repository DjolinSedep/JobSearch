package kg.attractor.jobsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsInfo {
    private Integer id;
    private ContactType type;
    private Resume resume;
    private String value;

}
