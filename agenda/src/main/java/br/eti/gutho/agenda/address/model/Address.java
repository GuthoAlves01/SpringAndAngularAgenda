package br.eti.gutho.agenda.address.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @NotBlank(message = "Erro no campo Endereço, verifique o valor informado")
    String address;

    @NotNull
    @NotBlank(message = "Erro no campo CEP, verifique o valor informado")
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "O Cep deve conter o seguinte formato 00000-000")
    String cep;

    @NotNull
    @NotBlank(message = "Erro no campo Cidade, verifique o valor informado")
    String city;

    @NotNull
    @NotBlank(message = "Erro no campo Estado, verifique o valor informado")
    String state;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", cep='" + cep + '\'' +
                ", City='" + city + '\'' +
                ", State='" + state + '\'' +
                '}';
    }

}
