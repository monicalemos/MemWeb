package classesDados;

import java.sql.Date;

import enumerados.TipoGenero;

public class Familiar extends Pessoa{

	private boolean eCuidador;
	private Date data_obito;
	private String nome_utilizador;
	private String password;
	
	public Familiar(int id, String nome_completo,
			Date data_de_nascimento, Morada local_nascimento, Morada morada,
			TipoGenero genero, String profissao, boolean eCuidador) {
		super(id, nome_completo, data_de_nascimento, local_nascimento,
				genero, profissao, morada);
		this.eCuidador = eCuidador;
	}

	public Familiar(int id, String nome_completo,
			Date data_de_nascimento, Morada local_nascimento, Morada morada,
			TipoGenero genero, String profissao, boolean eCuidador,
			String nome_utilizador, String password) {
		super(id, nome_completo, data_de_nascimento, local_nascimento,
				genero, profissao, morada);
		this.eCuidador = eCuidador;
		
		if(eCuidador == true){
			this.nome_utilizador = nome_utilizador;
			this.password = password;
		}
	}

	//GETTERS:
	public boolean eCuidador() {
		return eCuidador;
	}

	public Date getData_obito() {
		return data_obito;
	}

	public String getNome_utilizador() {
		return nome_utilizador;
	}
	
	public String getPassword() {
		return password;
	}

	//SETTERS

	public void seteCuidador(boolean eCuidador) {
		this.eCuidador = eCuidador;
	}

	public void setData_obito(Date data_obito) {
		this.data_obito = data_obito;
	}

	public void setNome_utilizador(String nome_utilizador) {
		this.nome_utilizador = nome_utilizador;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
