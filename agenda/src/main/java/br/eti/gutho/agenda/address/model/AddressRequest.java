package br.eti.gutho.agenda.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    String address;
    String cep;
    String city;
    String state;
}
