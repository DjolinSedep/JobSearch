package kg.attractor.jobsearch.entity;

import lombok.*;

@Getter
@Setter
public class Category {
    private Integer id;
    private String name;
    private Category parentCategory;
}
