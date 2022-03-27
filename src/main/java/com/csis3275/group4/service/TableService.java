package com.csis3275.group4.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService implements IService<Table>{

	@Autowired
	private TableRepository tableRepository;

	public TableService(TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

	@Override
	public void add(Table obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String Id, Table obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Table> getAll() {
		// TODO Auto-generated method stub
		return this.tableRepository.findAll();
	}

	@Override
	public Optional<Table> getById(UUID Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Table> getAllAvailable() {
		return this.tableRepository.findByisAvailableIsTrue(true);
	}
	public  Table getThisTable(String id){return  this.tableRepository.findById(id).get();}
	public void updateAvailable(String Id, boolean isAvailable) {
		Table updateTable = this.tableRepository.findById(Id).orElse(null);
		if (updateTable != null) {
			updateTable.setAvailable(isAvailable);
			this.tableRepository.save(updateTable);
		}
	}
}
