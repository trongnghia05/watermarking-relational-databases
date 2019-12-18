package com.kma.watermarking.model;

public class StrObject {
  private int sumASCIIV;
  private int sumASCIIC;
  private int sumASCIIP;

  public StrObject(int sumASCIIV, int sumASCIIC, int sumASCIIP) {
    this.sumASCIIV = sumASCIIV;
    this.sumASCIIC = sumASCIIC;
    this.sumASCIIP = sumASCIIP;
  }

  public StrObject() {}

  public int getSumASCIIV() {
    return this.sumASCIIV;
  }

  public int getSumASCIIC() {
    return this.sumASCIIC;
  }

  public int getSumASCIIP() {
    return this.sumASCIIP;
  }
}
