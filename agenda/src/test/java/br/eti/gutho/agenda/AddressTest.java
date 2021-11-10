package br.eti.gutho.agenda;

/**
 * classe para exemplo de como fazer testes unitários para campos
 **/

import br.eti.gutho.agenda.model.address.Address;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void addressAddressVerifyNullAddressTest(){
        Address address = addressGetToTest();

        address.setAddress(null);

        Set<ConstraintViolation<Address>> constraintViolations =
                validator.validate( address);

        assertEquals(1, constraintViolations.size());


    }
    private Address addressGetToTest(){
        Address address = new Address();
        address.setAddress("rua nova do lado da rua velha");
        address.setCity("Palmas");
        address.setState("Tocantins");
        return address;
    }
}
