package com.laisleal.desafiotecnico.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laisleal.desafiotecnico.domain.Terminal;

@Repository
@Transactional
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {

	Terminal findByLogic(Integer logic);
	void deleteByLogic(Integer logic);
	
}
