package classesDados;

public class Morada {
	private String pais;
	private String cidade;
	private String regiao;
	
	public Morada(String pais, String cidade, String regiao) {
		super();
		this.pais = pais;
		this.cidade = cidade;
		this.regiao = regiao;
	}
	
	public String getPais() {
		return pais;
	}
	public String getCidade() {
		return cidade;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	

	
}
