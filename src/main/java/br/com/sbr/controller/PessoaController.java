package br.com.sbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sbr.data.vo.PessoaVO;
import br.com.sbr.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServices services;
	
	@GetMapping
	public List<PessoaVO> findAll() {
		return services.findAll();
	}
	
	@GetMapping(value="/{id}")
	public PessoaVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	@PostMapping
	public PessoaVO create(@RequestBody PessoaVO pessoa) {
		return services.create(pessoa);
	}
	
	@PutMapping
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		return services.update(pessoa);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
		
	}
	

}


