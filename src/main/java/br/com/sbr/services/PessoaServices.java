package br.com.sbr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sbr.exception.ResourceNotFoundOperacaoException;
import br.com.sbr.model.Pessoa;
import br.com.sbr.repository.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	PessoaRepository repository;
	
	public Pessoa create(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		Pessoa entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
		entity.setName(pessoa.getName());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		return repository.save(entity) ;
	}
	
	public void delete(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
		repository.delete(entity);
	}
	
	public Pessoa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
	}
	
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}


}
