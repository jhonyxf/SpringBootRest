package br.com.sbr;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static final String template = "Hollaaa mundaão, %s !";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public Hello ola(@RequestParam(value="nome", defaultValue="Jow") String nome) {
		return new Hello(counter.incrementAndGet(), String.format(template, nome));
	}

}
