package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import com.example.instructors.City.CityRepository;
import com.example.instructors.Entity.Address;
import com.example.instructors.Exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;

    @Override
    public AddressResponse createNewAddress(AddressRequest addressRequest){
        Address address = addressMapper.mapToAddress(addressRequest);
        address.setCity(cityRepository.findById(addressRequest.getCityId())
                .orElseThrow(() -> new NotFoundException("City not found with id " + addressRequest.getCityId())));
        Address savedAddress = addressRepository.save(address);
        return addressMapper.mapToResponse(savedAddress);
    }

    @Override
    public AddressResponse updateAddres(Long addressId, AddressRequest addressRequest) {
        Address addressToUpdate = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("Address not found with id " + addressId));
        addressToUpdate.setCity(cityRepository.findById(addressRequest.getCityId())
                .orElseThrow(() -> new NotFoundException("City not found with id " + addressRequest.getCityId())));
        addressToUpdate.setNumber(addressRequest.getNumber());
        addressToUpdate.setStreet(addressRequest.getStreet());
        addressToUpdate.setZipcode(addressRequest.getZipcode());
        addressRepository.save(addressToUpdate);

        return addressMapper.mapToResponse(addressToUpdate);
    }

    @Override
    public Page<AddressResponse> getAllAddresses(Pageable pageable) {
        Page<Address> addresses = addressRepository.findAll(pageable);
        return addresses.map(addressMapper::mapToResponse);
    }

    @Override
    public void deleteAddress(Long addressId) {
        Address addressToDelete = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("Address not found with id " + addressId));
        addressRepository.delete(addressToDelete);
    }
}
