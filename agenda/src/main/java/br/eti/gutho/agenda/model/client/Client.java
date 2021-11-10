package br.eti.gutho.agenda.model.client;

import br.eti.gutho.agenda.model.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client {
    String name;
    String cpf;
    Address address;
}
