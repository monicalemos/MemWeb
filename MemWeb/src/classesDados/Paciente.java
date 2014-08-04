package classesDados;

import java.io.Serializable;
import java.sql.Date;

import enumerados.TipoEscolaridade;
import enumerados.EspecialidadeMedico;
import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;
import enumerados.TipoUtilizador;

public class Paciente extends Pessoa implements Serializable {

	private TipoEscolaridade escolaridade;
	private int nivel_doenca;
	private String nome_medico;
	private EspecialidadeMedico especialidade_medico;
	private String nome_utilizador;
	private String password;
	private TipoUtilizador tipo_utilizador;
	private int nivel_sessao;
	private Cuidador cuidador; //Pensar como fazer
	private Tecnico tecnico;
	private TipoEstadoCivil estado_civil;
	
	public Paciente(int idPessoa, String nome_completo,
			Date data_de_nascimento, Morada local_nascimento, Morada morada,
			TipoGenero genero, String profissao, TipoEscolaridade escolaridade, TipoEstadoCivil estado_civil, int nivel_doenca, String nome_medico,
			EspecialidadeMedico especialidade_medico, String nome_utilizador,
			String password, int nivel_sessao, Tecnico tecnico) {
		
		super(idPessoa, nome_completo, data_de_nascimento, local_nascimento,
				genero, profissao, morada);
		
		this.escolaridade = escolaridade;
		this.nivel_doenca = nivel_doenca;
		this.nome_medico = nome_medico;
		this.especialidade_medico = especialidade_medico;
		this.nome_utilizador = nome_utilizador;
		this.password = password;
		this.tipo_utilizador = TipoUtilizador.PACIENTE;
		this.nivel_sessao = nivel_sessao;
		//this.cuidador = cuidador;
		this.tecnico = tecnico;
		setEstado_civil(estado_civil);
	}
	
	//GETTERS:
	public TipoEscolaridade getEscolaridade() {
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
	public Cuidador getCuidador() {
		return cuidador;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	
	//SETTERS:
	public void setEscolaridade(TipoEscolaridade escolaridade) {
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
	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
