package com;

import Interface.SpaceShip;

public class Rocket implements SpaceShip {

  private Integer cost;
  private Integer weight;
  private Integer maxWeight;
  public Integer cargoLimit;
  public Integer cargoCarried;



  public void setCargoLimit(Integer maxWeight , Integer weight) {
    this.cargoLimit = this.maxWeight - this.weight;
  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(Integer maxWeight) {
    this.maxWeight = maxWeight;
  }



  public boolean launch() {
    return true;
  }

  public boolean land() {
    return true;
  }


  public boolean canCarry(Item item) {
        return this.cargoLimit >= item.weight;
  }

  public void carry(Item item) {
   this.weight=this.weight+item.weight;
  }
}
