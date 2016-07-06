package com.codenotfound.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codenotfound.jaxb.model.Car;

public final class UnmarshalHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnmarshalHelper.class);

    private UnmarshalHelper() {
        // not called
    }

    public static Car unmarshalError(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Car car = (Car) jaxbUnmarshaller.unmarshal(file);

        LOGGER.info(car.toString());
        return car;
    }

    public static Car unmarshal(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<Car> root = jaxbUnmarshaller.unmarshal(new StreamSource(file), Car.class);
        Car car = root.getValue();

        LOGGER.info(car.toString());
        return car;
    }
}
