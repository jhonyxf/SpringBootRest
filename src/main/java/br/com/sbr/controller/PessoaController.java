package br.com.sbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sbr.model.Pessoa;
import br.com.sbr.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServices services;
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable("id") String id) {
		return services.findbyId(id);
	}

}

