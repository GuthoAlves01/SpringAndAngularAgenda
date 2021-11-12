package br.eti.gutho.agenda.address.service;

import br.eti.gutho.agenda.address.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addressSaveTest() {
        Address address = addressValid();

        Address obtained = addressService.addressSave(address);

        assertEquals(address.getAddress(),obtained.getAddress());
        assertEquals(address.getState(),obtained.getState());

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