package classesDados;

import java.sql.Date;

import enumerados.Escolaridade;
import enumerados.EspecialidadeMedico;
import enumerados.TipoGenero;
import enumerados.TipoUtilizador;

public class Paciente extends Pessoa {

	private Escolaridade escolaridade;
	private int nivel_doenca;
	private String nome_medico;
	private EspecialidadeMedico especialidade_medico;
	private String nome_utilizador;
	private String password;
	private TipoUtilizador tipo_utilizador;
	private int nivel_sessao;
	
	public Paciente(int idPessoa, String nome_completo,
			Date data_de_nascimento, Morada local_nascimento,
			TipoGenero genero, String profissão, Morada morada,
			Escolaridade escolaridade, int nivel_doenca, String nome_medico,
			EspecialidadeMedico especialidade_medico, String nome_utilizador,
			String password, int nivel_sessao) {
		
		super(idPessoa, nome_completo, data_de_nascimento, local_nascimento,
				genero, profissão, morada);
		
		this.escolaridade = escolaridade;
		this.nivel_doenca = nivel_doenca;
		this.nome_medico = nome_medico;
		this.especialidade_medico = especialidade_medico;
		this.nome_utilizador = nome_utilizador;
		this.password = password;
		this.tipo_utilizador = TipoUtilizador.PACIENTE;
		this.nivel_sessao = nivel_sessao;
	}
	
	//GETTERS:
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public int getNivel_doenca() {
		return nivel_doenca;
	}
	public String getNome_medico() {
		return nome_medico;
	}
	public EspecialidadeMedico getEspecialidade_medico() {
		return especialidade_medico;
	}
	public String getNome_utilizador() {
		return nome_utilizador;
	}
	public String getPassword() {
		return password;
	}
	public TipoUtilizador getTipo_utilizador() {
		return tipo_utilizador;
	}
	public int getNivel_sessao() {
		return nivel_sessao;
	}
	
	//SETTERS:
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public void setNivel_doenca(int nivel_doenca) {
		this.nivel_doenca = nivel_doenca;
	}
	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}
	public void setEspecialidade_medico(EspecialidadeMedico especialidade_medico) {
		this.especialidade_medico = especialidade_medico;
	}
	public void setNome_utilizador(String nome_utilizador) {
		this.nome_utilizador = nome_utilizador;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNivel_sessao(int nivel_sessao) {
		this.nivel_sessao = nivel_sessao;
	}
}
