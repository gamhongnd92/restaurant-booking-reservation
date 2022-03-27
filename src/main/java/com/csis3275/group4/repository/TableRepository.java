package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.Table;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends MongoRepository<Table, String>{

    List<Table> findByisAvailableIsTrue(boolean isAvailable);
}
