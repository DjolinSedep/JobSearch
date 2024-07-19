package kg.attractor.jobsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsInfo {
    private Integer id;
    private ContactTypes types;
    private Resume resume;
    private String value;

}
