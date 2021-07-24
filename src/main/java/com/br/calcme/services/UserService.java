package com.br.calcme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.calcme.models.User;
import com.br.calcme.repositories.UserRepository;
import com.br.calcme.services.exceptions.UserException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return this.repository.findAll();
	}

	public User findById(String id) {
		return this.repository.findById(id).orElseThrow(() -> new UserException("Error ao achar usuário"));
	}

	public User save(User obj) {
		obj.setId(null);
		try {
			return this.repository.save(obj);
		} catch (Exception e) {
			throw new UserException("Erro ao salvar usuário");
		}
	}

	public User update(User obj) {
		this.findById(obj.getId());
		try {
			return this.repository.save(obj);
		} catch (Exception e) {
			throw new UserException("Erro ao atualizar usuário");
		}
	}

	public void delete(String id) {
		this.findById(id);
		try {
			this.repository.deleteById(id);
		} catch (Exception e) {
			throw new UserException("Erro ao deleter usuário");
		}
	}
}
