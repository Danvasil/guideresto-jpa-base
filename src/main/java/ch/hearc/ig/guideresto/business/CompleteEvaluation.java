package ch.hearc.ig.guideresto.business;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="COMMENTAIRES")
public class CompleteEvaluation extends Evaluation {

  @Column(name="COMMENTAIRE")
  private String comment;

  @Column(name="NOM_UTILISATEUR")
  private String username;

  @OneToMany
  @JoinColumn(name="FK_COMM")
  private Set<Grade> grades;

  public CompleteEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, String comment,
      String username) {
    super(id, visitDate, restaurant);
    this.comment = comment;
    this.username = username;
    this.grades = new HashSet<>();
  }

  public CompleteEvaluation() {
    super();
  }

  public String getComment() {
    return comment;
  }

  public String getUsername() {
    return username;
  }

  public Set<Grade> getGrades() {
    return grades;
  }

  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  public void setGrades(Set<Grade> grades) {
    this.grades = grades;
  }
}