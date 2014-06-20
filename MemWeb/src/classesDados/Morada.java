package classesDados;

public class Morada {

	private int id;
	private String pais;
	private String cidade;
	private String rua;
	private String numPortaPredio;
	private int andar;
	private String numPortaAndar;
	private String codPostal;

	public Morada(int id, String pais, String cidade, String rua,
			String numPortaPredio, int andar, String numPortaAndar,
			String codPostal) {
		
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.rua = rua;
		this.numPortaPredio = numPortaPredio;
		this.andar = andar;
		this.numPortaAndar = numPortaAndar;
		this.codPostal = codPostal;
	}

	
	public Morada(int id, String pais, String cidade, String rua) {
		super();
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.rua = rua;
	}
	
	

	public Morada(int id, String pais, String cidade) {
		super();
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
	}

	public Morada(int id, String pais) {
		super();
		this.id = id;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumPortaPredio() {
		return numPortaPredio;
	}


	public void setNumPortaPredio(String numPortaPredio) {
		this.numPortaPredio = numPortaPredio;
	}


	public int getAndar() {
		return andar;
	}


	public void setAndar(int andar) {
		this.andar = andar;
	}


	public String getNumPortaAndar() {
		return numPortaAndar;
	}


	public void setNumPortaAndar(String numPortaAndar) {
		this.numPortaAndar = numPortaAndar;
	}


	public String getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}


	public String MoradaCompleta(){
		return "Morada:  [pais=" + pais + ", cidade=" + cidade + ", rua=" + rua
				+ ", numPortaPredio=" + numPortaPredio + ", andar=" + andar
				+ ", numPortaAndar=" + numPortaAndar + ", codPostal="
				+ codPostal + "]";
	}

	public String toString() {
		return "Pais: " + pais + ", cidade: " + cidade + ", rua: " + rua
				+ "\n";
	}
	
	
}
