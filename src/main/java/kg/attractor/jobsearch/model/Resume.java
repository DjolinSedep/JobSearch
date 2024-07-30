package kg.attractor.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
 private Integer id;
 private User applicant;
 private String name;
 private Category category;
 private double salary;
 private boolean isActive;
 private Date createDate;
 private Date updateTime;

    public  getUserId() {
    }
}
