package br.com.sbr.services;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<Pessoa> findAll(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 7; i++) {
			Pessoa pessoa = mockPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas ;
	}

	private Pessoa mockPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setName("Nome "+i);
		pessoa.setSobrenome("Sobre "+i);
		pessoa.setEndereco("city "+i);
		pessoa.setGenero("Masculino "+i);
		return pessoa ;
	}

}
