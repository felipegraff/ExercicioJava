package Endpoint;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Request.RequestSaudacao;

@RestController
public class SaudacaoPessoa {

	@RequestMapping(
			value="Ola",
			method=RequestMethod.GET
	)
	public RequestSaudacao saudacaoGet(
				@RequestParam(
						value="nome", defaultValue="Teste"
				) String nome,
				@RequestParam(
						value="id", defaultValue="1"
				) int id
	){
		RequestSaudacao s = new RequestSaudacao(nome);
		s.setId(id);
		return s;
	}
	
	@RequestMapping(
			value="ola",
			method=RequestMethod.POST,
			consumes="teste aplcaçao"
			)
	public RequestSaudacao saudacaoPost(@RequestBody RequestSaudacao a){
		return a;
	}
	
}
