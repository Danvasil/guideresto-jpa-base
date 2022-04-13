package ch.hearc.ig.guideresto.business;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="VILLES")
public class City {

    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer id;

    @Column(name="CODE_POSTAL")
    private String zipCode;

    @Column(name="NOM_VILLE")
    private String cityName;

    @OneToMany
    @JoinColumn(name="FK_VILL")
    private Set<Restaurant> restaurants;

    public City(Integer id, String zipCode, String cityName) {
        this.id = id;
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.restaurants = new HashSet<>();
    }

    public City() {}

    public String getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

  public void setId(int id) {
        this.id = id;
  }

  public int getId() {
    return id;
  }
}