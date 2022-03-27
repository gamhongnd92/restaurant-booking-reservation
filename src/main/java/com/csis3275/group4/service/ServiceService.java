package com.csis3275.group4.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.csis3275.group4.entity.Service;
import com.csis3275.group4.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceService implements IService<Service> {

	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public void add(Service obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String Id, Service obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Service> getAll() {
		// TODO Auto-generated method stub
		return this.serviceRepository.findAll();
	}

	@Override
	public Optional<Service> getById(UUID Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
