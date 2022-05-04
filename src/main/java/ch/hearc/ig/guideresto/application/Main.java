package ch.hearc.ig.guideresto.application;

import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.presentation.CLI;
import ch.hearc.ig.guideresto.service.RestaurantService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var printStream = System.out;
    var restaurantService = new RestaurantService();
    var cli = new CLI(scanner, printStream, restaurantService);


    cli.start();
  }
}
