package Request;

public class RequestSaudacao {

	private String nome;
	private int id;
	
	public RequestSaudacao(){
		
	}

	public RequestSaudacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
