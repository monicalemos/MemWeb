package classesDados;

public class Morada {
	private int id;
	private String pais;
	private String cidade;
	private String regiao;
	
	public Morada(int id, String pais, String cidade, String regiao) {
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.regiao = regiao;
	}
	
	public int getId() {
		return id;
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
	public void setId(int id) {
		this.id = id;
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
