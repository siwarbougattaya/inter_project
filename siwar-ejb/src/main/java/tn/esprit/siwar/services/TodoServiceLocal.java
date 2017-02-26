package tn.esprit.siwar.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.siwar.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
