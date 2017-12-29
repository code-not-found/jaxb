package com.codenotfound.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codenotfound.jaxb.model.Car;

public final class UnmarshalHelper {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(UnmarshalHelper.class);

  private UnmarshalHelper() {
    // not called
  }

  public static Car unmarshal(String xml) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

    StringReader reader = new StringReader(xml);
    Car car = (Car) jaxbUnmarshaller.unmarshal(reader);

    LOGGER.info(car.toString());
    return car;
  }
}
