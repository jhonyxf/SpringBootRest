package br.com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sbr.data.model.Pessoa;
import br.com.sbr.data.vo.PessoaVO;
import br.com.sbr.erudio.converter.DozerConverter;
import br.com.sbr.exception.ResourceNotFoundOperacaoException;
import br.com.sbr.repository.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	PessoaRepository repository;
	
	public PessoaVO create(PessoaVO pessoa) {
		Pessoa entity = DozerConverter.parseObject(pessoa, Pessoa.class);
		PessoaVO vo = DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
		return vo;
	}
	
	public PessoaVO update(PessoaVO pessoa) {
		Pessoa entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
		entity.setName(pessoa.getName());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		PessoaVO vo = DozerConverter.parseObject(repository.save(entity),PessoaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
		repository.delete(entity);
	}
	
	public PessoaVO findById(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundOperacaoException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PessoaVO.class);
	}
	
	
	public List<PessoaVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PessoaVO.class);
	}


}
