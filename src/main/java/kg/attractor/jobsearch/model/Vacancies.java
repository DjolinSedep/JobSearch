package kg.attractor.jobsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancies {
  private Integer id;
  private String description;
  private Category category;
  private float salary;
  private Integer expFrom;
  private Integer expTo;
  private boolean isActive;
  private float created_date;
  private float updateTime;

}
