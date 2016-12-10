package entity;

public class MensagemRequest {

	
	private String mensagem;
        private boolean sucesso;
	
	public boolean isSuccess() {
		return sucesso;
	}
	public void setSuccess(boolean success) {
		this.sucesso= sucesso;
	}
	public String getMessage() {
		return mensagem;
	}
	public void setMessage(String message) {
		this.mensagem = mensagem;
	}
	
	
}
