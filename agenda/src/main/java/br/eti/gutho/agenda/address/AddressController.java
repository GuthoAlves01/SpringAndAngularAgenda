package br.eti.gutho.agenda.address;

import br.eti.gutho.agenda.address.model.Address;
import br.eti.gutho.agenda.address.model.AddressRequest;
import br.eti.gutho.agenda.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    //            @GetMapping("/hello")
//        public String vhello(){
//
//            Address address = new Address();
//            address.setAddress("rua nova do lado da rua velha do outro lado");
//            address.setCep("77002-555");
//            address.setCity("Palmas");
//            address.setState("Tocantins");
//
//            return address.toString();
//        }
    @GetMapping("/address/{id}")
    public @ResponseBody
    Address findAddress(@PathVariable String id) {
        return service.getById(Long.parseLong(id));
    }

    @GetMapping("/address/addresses")
    public @ResponseBody
    List<Address> getAllAddress() {
        return service.getAll();
    }

    @PostMapping("/address/save")
    public Address saveAddress(@RequestBody AddressRequest address) {
        return service.addressSave(address);
    }

    @PutMapping("/address/{id}/update")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return service.addressUpdate(id, address);
    }

    @PutMapping("/address/{id}/delete")
    public void deleteAddress(@PathVariable Long id, @RequestBody Address address) {
        service.addressDelete(id, address);
    }

}
