package br.eti.gutho.agenda.address.service;

import br.eti.gutho.agenda.address.model.Address;
import br.eti.gutho.agenda.address.model.AddressRepository;
import br.eti.gutho.agenda.address.model.AddressRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addressSave(AddressRequest address){
        if (!this.getByCep(address.getCep())){
            return addressRepository.save(convertedFrom(address));
        }else{
            throw new NullPointerException();
        }

    }
    public Address addressSave(Address address){
        return addressRepository.save(address);
    }
    public Address getById(Long id){
        return addressRepository.findById(id).get();
    }
    public List<Address> getAll(){
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }
    public boolean getByCep(String cep){
        var ref = new Object() {
            boolean exist;
        };
        addressRepository.findAll().forEach(x -> { ref.exist = (x.getCep().equals(cep)) ? true : false;});
        return ref.exist;
    }
    public Address addressUpdate(Long id, Address address){
        return addressRepository.save(address);
    }
    public void addressDelete(Long id, Address address){
        addressRepository.delete(address);
    }

    private Address convertedFrom(AddressRequest addressRequest){
        Address address = new Address();
        address.setAddress(addressRequest.getAddress());
        address.setCep(addressRequest.getCep());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        return address;
    }

}
