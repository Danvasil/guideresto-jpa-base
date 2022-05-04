package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.BasicEvaluation;
import ch.hearc.ig.guideresto.business.City;
import ch.hearc.ig.guideresto.business.CompleteEvaluation;
import ch.hearc.ig.guideresto.business.EvaluationCriteria;
import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.business.RestaurantOverview;
import ch.hearc.ig.guideresto.business.RestaurantType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestaurantService {


  public Set<RestaurantOverview> researchAllRestaurants() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("guideRestoPersistenceUnit");
    EntityManager em = emf.createEntityManager();
    List<Restaurant> restaurant = em.createQuery("SELECT R FROM Restaurant R").getResultList();
    Set<RestaurantOverview> ro = new HashSet<RestaurantOverview>();
    for (Restaurant r : restaurant){
      ro.add(new RestaurantOverview(r.getId(), r.getName(), r.getStreet(), r.getZipCode(), r.getCityName()));
    }
    return ro;
  }

  public Restaurant researchRestaurantById(int restaurantId) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("guideRestoPersistenceUnit");
    EntityManager em = emf.createEntityManager();
    Restaurant restaurant = em.find(Restaurant.class, restaurantId);
    return restaurant;
  }

  public Set<Restaurant> researchRestaurantsByName(String research) {
    return Collections.emptySet();
  }

  public Set<Restaurant> researchRestaurantsByCityName(String research) {
    return Collections.emptySet();
  }

  public Set<Restaurant> researchRestaurantsByType(RestaurantType restaurantType) {
    return Collections.emptySet();
  }

  public Set<RestaurantType> researchAllRestaurantTypes() {
    return Collections.emptySet();
  }

  public Set<City> researchAllCities() {
    return Collections.emptySet();
  }

  public void insertRestaurant(Restaurant restaurant) {
  }

  public void insertCity(City city) {
  }

  public void insertBasicEvaluation(BasicEvaluation eval) {
  }

  public Set<EvaluationCriteria> researchAllEvaluationCriteria() {
    return Collections.emptySet();
  }

  public void insertCompleteEvaluation(CompleteEvaluation eval) {
  }

  public void updateRestaurant(Restaurant restaurant) {
  }

  public void deleteRestaurant(Restaurant restaurant) {
  }
}
