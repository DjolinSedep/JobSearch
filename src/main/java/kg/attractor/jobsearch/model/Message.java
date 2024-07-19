package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;;
    private RespondedApplicant respondedApplicant;
    private String content;
    private Date timeStamp;
}
