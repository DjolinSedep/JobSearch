package kg.attractor.jobsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
  private Integer id;
  private String description;
  private Category category;
  private double salary;
  private Integer expFrom;
  private Integer expTo;
  private boolean isActive;
  private User author;
  private Date created_date;
  private Date updateTime;

}
