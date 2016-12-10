package Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Dao.DaoPessoa;
import entity.EntidadePessoa;
import entity.MensagemRequest;
import Request.RequestSaudacao;

@RestController
@RequestMapping(value="Pessoa")
public class ControlePessoa {

	@Autowired
	DaoPessoa dao;
	
	@RequestMapping(
			value="/list",
			method=RequestMethod.GET
	)
	public List<EntidadePessoa> list(
			@RequestParam(
					value="idPessoa", defaultValue="1"
			) int id
	){
		return dao.list(id);
		
	}
	
	@RequestMapping(
			value="Inserir",
			method=RequestMethod.POST,
			consumes="Aplicacao json",
			produces="Aplicacao json"
			)
	public EntidadePessoa insert(@RequestBody EntidadePessoa p){
		return dao.insert(p);
	}
	
	@RequestMapping(
			value="Atualizar",
			method=RequestMethod.PUT,
			consumes="Aplicacao json",
			produces="Aplicacao json"
			)
	public MensagemRequest update(@RequestBody EntidadePessoa p){
		MensagemRequest resp = new MensagemRequest();
		
		if (p.getPessoa() == 0){
			resp.setSuccess(false);
			resp.setMessage("Campo Pessoa é obrigatorio");
			return resp;
		}
		
		boolean success = dao.update(p);
		
		if (success){
			resp.setSuccess(success);
			resp.setMessage("Atualizado com sucesso.");
		}else{
			resp.setSuccess(false);
			resp.setMessage("Erro ao atualizar");
		}
		return resp;
	}
	
	
}
