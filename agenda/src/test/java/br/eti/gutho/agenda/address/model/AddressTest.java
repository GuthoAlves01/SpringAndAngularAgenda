package br.eti.gutho.agenda.address.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void setAddressTest() {
        Address address = addressValid();

        address.setAddress(null);

        Set<ConstraintViolation<Address>> constraintViolations =
                validator.validate( address );

        assertEquals(1, constraintViolations.size());
    }

    @Test
    void setCepNullTest() {
        Address address = addressValid();

        address.setCep(null);

        Set<ConstraintViolation<Address>> constraintViolations =
                validator.validate( address );

        assertEquals(1, constraintViolations.size());
    }
    @Test
    void setCityNullTest() {
        Address address = addressValid();

        address.setCity(null);

        Set<ConstraintViolation<Address>> constraintViolations =
                validator.validate( address );

        assertEquals(1, constraintViolations.size());
    }
    @Test
    void setStateNullTest() {
        Address address = addressValid();
        address.setState(null);

        Set<ConstraintViolation<Address>> constraintViolations =
                validator.validate( address );

        assertEquals(1, constraintViolations.size());

    }

    private Address addressValid(){
        Address address = new Address();
        address.setAddress("Rua 3 Lote 09 QI 90");
        address.setCity("Palmas");
        address.setState("Tocantins");
        address.setCep("77270-000");
        return address;
    }
}