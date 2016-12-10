package Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import DaoMapper.MapeadorPessoa;
import entity.EntidadePessoa;

@Repository
public class DaoPessoa extends DaoBase{

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	private ArrayList<String> columns = new ArrayList<String>();
	
	public DaoPessoa(){
		columns.add("nome");
		columns.add("idade");
	}
	
	public List<EntidadePessoa> list(int id){
		List<EntidadePessoa> result = new  ArrayList<EntidadePessoa>();
		String sql = "SELECT * FROM " + tableName + " ";
		
		if (id == 0){
			result = jdbcTemplate.query(sql, new MapeadorPessoa());
		}else{
			sql += " WHERE " + primaryKey + "=?";
			result = jdbcTemplate.query(sql, new MapeadorPessoa(), id);
		}
		
		return result;
	}
	
	public EntidadePessoa insert(EntidadePessoa a){
		
		SimpleJdbcInsert i = new SimpleJdbcInsert(jdbcTemplate);
		i.setTableName(tableName);
		i.setColumnNames(columns);
		i.setGeneratedKeyName(primaryKey);
		
		Number key = i.executeAndReturnKey(new BeanPropertySqlParameterSource(a));
		
		a.setPessoa(key.intValue());
				
		return a;
	}
	
	public boolean update(EntidadePessoa a){
		String sql = "UPDATE " + tableName + " set nome = ?, idade = ?  WHERE idPessoa = ?";
		
		//qtdLineUpdate -> quantidade de linhas atualizadas no banco, deve ser maior que 1 se atualizou
		int qtdLineUpdated = jdbcTemplate.update(sql, a.getNome(), a.getIdade(), a.getPessoa());
		
		if (qtdLineUpdated > 0)
			return true;
		
		return false;
	}
}
