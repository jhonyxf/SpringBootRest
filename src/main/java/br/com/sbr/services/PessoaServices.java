package br.com.sbr.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.sbr.model.Pessoa;

@Service
public class PessoaServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Pessoa findbyId(String id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setName("Jhony");
		pessoa.setSobrenome("Dias");
		pessoa.setEndereco("Udi");
		pessoa.setGenero("Masculino");
		return pessoa ;
	}

}
