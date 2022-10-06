package com.microservice.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	public List<Worker> findAll(){
		return workerRepository.findAll();
	}
	
	public Worker findById(Long id){
		return workerRepository.findById(id).orElse(null);
	}
}
