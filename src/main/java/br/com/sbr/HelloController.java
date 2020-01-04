package br.com.sbr;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sbr.exception.UnsuportOperacaoException;

@RestController
public class HelloController {
	
	private static final String template = "Hollaaa mundaão, %s !";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public Hello ola(@RequestParam(value="nome", defaultValue="Jow") String nome) {
		return new Hello(counter.incrementAndGet(), String.format(template, nome));
	}
	
	@RequestMapping(value="/somar/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double somar(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		if(!isNumero(numeroUm) || !isNumero(numeroDois)) {
			throw new UnsuportOperacaoException("Por favor defina um valor numérico!");
		}
		
		return convertToDouble(numeroUm) + convertToDouble(numeroDois);
	}
	
	private Double convertToDouble(String strNumero) {
		if(strNumero == null) return 0D;
		String numero = strNumero.replaceAll(",", ".");
		if(isNumero(numero)) return Double.parseDouble(numero);
		return 0D;
	}

	private boolean isNumero(String strNumero) {
		if(strNumero == null) return false;
		String numero = strNumero.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
















