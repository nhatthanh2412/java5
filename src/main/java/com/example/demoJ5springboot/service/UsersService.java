package com.example.demoJ5springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demoJ5springboot.entity.Users;
import com.example.demoJ5springboot.repository.UsersRepository;


@Service
public class UsersService implements UsersRepository{
	@Autowired
	UsersRepository repository;
	
	
	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Users> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAllById(Iterable<String> ids) {
		return null;
	}

	@Override
	public <S extends Users> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Users> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Users> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users getOne(String id) {
		return repository.findById(id).get();
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<Users> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}

	@Override
	public void delete(Users entity) {
		repository.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Users> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Users> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Users> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean checkLogin(String user, String pass) {
		Users a=repository.findById(user).get();
		if(a==null||!pass.equals(a.getPassword())) {
			return false;
		}else {
			return true;
		}
	}

}
