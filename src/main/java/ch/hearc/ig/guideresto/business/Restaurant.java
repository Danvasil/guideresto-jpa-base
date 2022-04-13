package ch.hearc.ig.guideresto.business;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="RESTAURANTS")
public class Restaurant implements IAmRestaurant {

    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer id;

    @Column(name="NOM")
    private String name;

    @Embedded
    private Localisation address;

    @Column (name="DESCRIPTION")
    private String description;

    @Column(name="SITE_WEB")
    private String website;

    @OneToMany
    @JoinColumn(name="FK_REST")
    private Set<Evaluation> evaluations;

    @ManyToOne
    @JoinColumn(name="FK_TYPE")
    private RestaurantType type;


    public Restaurant(Integer id, String name, String description, String website, String street, City city, RestaurantType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.website = website;
        this.evaluations = new HashSet<>();
        this.address = new Localisation(street, city);
        this.type = type;
    }

    public Restaurant() {}

    public String getName() {
        return name;
    }

    public String getZipCode() {
        return address.getCity().getZipCode();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getCityName() {
        return address.getCity().getCityName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public Localisation getAddress() {
        return address;
    }

    public RestaurantType getType() {
        return type;
    }

    public void setType(RestaurantType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setEvaluations(HashSet<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}