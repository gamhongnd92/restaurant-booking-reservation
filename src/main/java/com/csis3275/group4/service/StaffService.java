package com.csis3275.group4.service;

import com.csis3275.group4.entity.Staff;
import com.csis3275.group4.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffService implements IService<Staff> {

    @Autowired
    StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void add(Staff obj) {

    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public void update(String Id, Staff obj) {

    }

    @Override
    public List<Staff> getAll() {
        return this.staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getById(UUID Id) {
        return Optional.empty();
    }
}
