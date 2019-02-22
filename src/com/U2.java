package com;

import java.util.Random;

public class U2 extends Rocket {

  private Integer chanceOfLaunchExplosion;
  private Integer chanceOfLandingCrash;
  Random rand = new Random();

  public U2() {
    this.setCost(120);
    this.setWeight(18);
    this.setMaxWeight(29);
    setCargoLimit(this.getWeight(), this.getMaxWeight());
    this.cargoCarried = 0;
  }

  @Override
  public boolean launch() {

    int n = 4;
    this.chanceOfLaunchExplosion = ((n / 100) * this.cargoCarried / this.cargoLimit);
    return (this.chanceOfLaunchExplosion <= n);
  }

  @Override
  public boolean land() {

    int n = 8;
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
