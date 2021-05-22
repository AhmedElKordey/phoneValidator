package com.jumia.validator.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jumia.validator.entity.CustomerEntitiy;

@Repository("customerRepository")
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntitiy, Integer>{
	List<CustomerEntitiy> findByPhoneStartsWith(String countryCode , Pageable page);// start with country code (237)
}
