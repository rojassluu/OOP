package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Simulation {

  public List<Item> loadItems() throws IOException {

    List<Item> items = new ArrayList<>();


    FileReader in = new FileReader("utils/loadItems");
    BufferedReader br = new BufferedReader(in);
    String line = br.readLine();
    while (line != null) {

      String[] parts = line.split("=");
      System.out.println(line);
      items.add(new Item(parts[0],Integer.parseInt(parts[1])));
      line = br.readLine();
    }
    in.close();

    return items;

  }

  public List<Rocket> loadU1() throws IOException {
    //List<Item> items = loadItems();
    List<Rocket> u1Rockets = new ArrayList<>();
    U1 u1 = new U1();


    for (Item item : loadItems()) {

      var itemWeight = (item.weight / 1000);

      if (u1.cargoCarried + itemWeight > u1.cargoLimit) {
        u1Rockets.add(u1);
        u1 = new U1();
      }
      u1.cargoCarried = u1.cargoCarried + itemWeight;
    }
    //u1Rockets.add(u1);
    return u1Rockets;
  }

  public List<Rocket> loadU2() throws IOException {
    List<Item> items = loadItems();
    List<Rocket> u1Rockets = new ArrayList<>();
    U2 u2 = new U2();

    for (Item item : items) {
      var itemWeight = (item.weight / 1000);

      if (u2.cargoCarried + itemWeight >= u2.cargoLimit) {
        u1Rockets.add(u2);
        u2 = new U2();
      }
      u2.cargoCarried = u2.cargoCarried + itemWeight;
    }

    return u1Rockets;
  }

  public Integer runSimulation(List<Rocket> rockets) {
    Integer totalBudget = 0;
    for (Rocket rocket : rockets) {
      if (rocket.getClass() == U1.class) {

        while (!((U1) rocket).land() && !((U1) rocket).launch()) {
          totalBudget += rocket.getCost();
        }
        totalBudget += rocket.getCost();
      } else {
        while (!((U2) rocket).land() && !((U2) rocket).launch()) {
          totalBudget += rocket.getCost();
        }
        totalBudget += rocket.getCost();
      }
    }
    return totalBudget;
  }
}
