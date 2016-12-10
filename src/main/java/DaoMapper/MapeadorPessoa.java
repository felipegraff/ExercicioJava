package DaoMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.EntidadePessoa;

public class MapeadorPessoa implements RowMapper<EntidadePessoa>{

	@Override
	public EntidadePessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
		EntidadePessoa a = new EntidadePessoa();
		
		a.setPessoa(rs.getInt("Pessoa"));
		a.setNome(rs.getString("nome da pessoa"));
		a.setIdade(rs.getInt("idade da pessoa"));
		
		return a;
	}

}
