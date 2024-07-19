package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Masage {
    private Integer id;;
    private RespondedApplicant respondedApplicant;
    private String content;
    private String timeStamp;
}
