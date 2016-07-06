package com.codenotfound.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codenotfound.jaxb.model.Car;

public final class MarshalHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarshalHelper.class);

    private MarshalHelper() {
        // not called
    }

    public static String marshalError(Car car) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // format the XML output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(car, stringWriter);

        String result = stringWriter.toString();
        LOGGER.info(result);
        return result;
    }

    public static String marshal(Car car) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // format the XML output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        QName qName = new QName("com.codenotfound.jaxb.model", "car");
        JAXBElement<Car> root = new JAXBElement<Car>(qName, Car.class, car);

        jaxbMarshaller.marshal(root, stringWriter);

        String result = stringWriter.toString();
        LOGGER.info(result);
        return result;
    }
}
