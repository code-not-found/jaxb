package com.codenotfound.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Car {

  private String make;
  private String manufacturer;
  private String id;

  public String getMake() {
    return make;
  }

  @XmlElement
  public void setMake(String make) {
    this.make = make;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  @XmlElement
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getId() {
    return id;
  }

  @XmlAttribute
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Car [" + "make=" + make + ", manufacturer=" + manufacturer + ", id=" + id + "]";
  }
}
