package pl.coderslab.Spring01Hibernate.Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
   private String firstName;
   private String lastName;
   private String gender;
   private String country;
   private String notes;
   private boolean mailingList;
   private List<Skill> programmingSkills;
   private List <Hobby>hobbies;


}
