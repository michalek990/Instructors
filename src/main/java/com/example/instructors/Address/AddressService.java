package com.example.instructors.Address;

import com.example.instructors.Address.dto.AddressRequest;
import com.example.instructors.Address.dto.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {

  AddressResponse createNewAddress(AddressRequest addressRequest);
  AddressResponse updateAddres(Long addressId, AddressRequest addressRequest);
  Page<AddressResponse> getAllAddresses(Pageable pageable);
  void deleteAddress(Long addressId);
}
