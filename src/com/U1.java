package com;

import java.util.Random;

public class U1 extends Rocket {

  private Integer chanceOfLaunchExplosion;
  private Integer chanceOfLandingCrash;
  Random rand = new Random();


  public U1() {
    this.setCost(100);
    this.setWeight(10);
    this.setMaxWeight(18);
    setCargoLimit(this.getWeight(), this.getMaxWeight());
    this.cargoCarried = 0;
  }

  @Override
  public boolean launch() {

    int n = rand.nextInt(101);
    this.chanceOfLaunchExplosion = ((n / 100) * this.cargoCarried / this.cargoLimit);
    return (this.chanceOfLaunchExplosion <= n);
  }

  @Override
  public boolean land() {

    int n = rand.nextInt(101);
    this.chanceOfLandingCrash = ((n / 100) * this.cargoCarried / this.cargoLimit);
    return (this.chanceOfLandingCrash <= n);
  }

  public Integer getChanceOfLaunchExplosion() {
    return chanceOfLaunchExplosion;
  }

  public void setChanceOfLaunchExplosion(Integer chanceOfLaunchExplosion) {

    this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;

  }

  public Integer getChanceOfLandingCrash() {
    return chanceOfLandingCrash;
  }

  public void setChanceOfLandingCrash(Integer chanceOfLandingCrash) {
    this.chanceOfLandingCrash = chanceOfLandingCrash;
  }

}
