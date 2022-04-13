package ch.hearc.ig.guideresto.business;

import javax.persistence.*;

@Entity
@Table(name="CRITERES_EVALUATION")
public class EvaluationCriteria {

    @Id
    @Basic(optional =false)
    @Column(name="NUMERO")
    private Integer id;

    @Column(name="NOM")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    public EvaluationCriteria(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public EvaluationCriteria() {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}