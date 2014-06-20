package classesDados;
//import java.util.ArrayList;
import java.sql.Date;

import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;


public class Paciente extends Pessoa{
	private Date data_diagnostico;
//	public ArrayList <Relacao> relacoes;
	private int nivelDoenca;
	private String nome_medico;
	private int telefone_medico;
	private Utilizador utilizador;
	
	public Paciente(int id, String nomeCompleto, Date data_nascimento, TipoEstadoCivil estado_civil, TipoGenero gen, int telefone, String email, Morada morada, String nome_medico, int telefone_medico, Date data_diagnostico, int nivelDoenca, Utilizador utilizador) {
		super(id, nomeCompleto, data_nascimento, estado_civil, gen, telefone, email, morada);
		this.nome_medico = nome_medico;
		this.telefone_medico = telefone_medico;
		this.data_diagnostico = data_diagnostico;
		this.nivelDoenca = nivelDoenca;
		this.utilizador = utilizador;
		
//		relacoes = new ArrayList<Relacao>();
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public String getNome_medico() {
		return nome_medico;
	}

	public void setNome_medico(String nome) {
		this.nome_medico = nome;
	}

	public int getTelefone_medico() {
		return telefone_medico;
	}

	public void setTelefone_medico(int telefone) {
		this.telefone_medico = telefone;
	}
	
	public Date getData_diagnostico() {
		return data_diagnostico;
	}

	public void setData_diagnostico(Date data_diagnostico) {
		this.data_diagnostico = data_diagnostico;
	}
	
	public int getNivelDoenca(){
		return nivelDoenca;
	}
	
	public void setNivelDoenca(int nivel){
		this.nivelDoenca = nivel;
	}
	@Override
	public int getId() {
		return super.getId();
	}
	@Override
	public void setId(int id) {
		super.setId(id);
	}
	@Override
	public String getNomeCompleto() {
		return super.getNomeCompleto();
	}
	@Override
	public void setNomeCompleto(String nome) {
		super.setNomeCompleto(nome);
	}
	
	@Override
	public String getNomeProprio() {
		return super.getNomeProprio();
	}
	@Override
	public void setNomeProprio(String nome) {
		super.setNomeProprio(nome);
	}
	
	@Override
	public String getApelido() {
		return super.getApelido();
	}
	@Override
	public void setApelido(String nome) {
		super.setApelido(nome);
	}
	
	@Override
	public Date getData_nascimento() {
		return super.getData_nascimento();
	}

	@Override
	public String getEstado_civil() {
		return super.getEstado_civil();
	}
	@Override
	public void setEstado_civil(TipoEstadoCivil estado_civil) {
		super.setEstado_civil(estado_civil);
	}
	
	@Override
	public String getGenero() {
		return super.getGenero();
	}
	
	@Override
	public int getTelefone() {
		return super.getTelefone();
	}
	@Override
	public void setTelefone(int telefone) {
		super.setTelefone(telefone);
	}
	
	@Override
	public String getEmail() {
		return super.getEmail();
	}
	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}
	
	@Override
	public Morada getMorada() {
		return super.getMorada();
	}
	@Override
	public void setMorada(Morada m) {
		super.setMorada(m);
	}
	
	@Override
	public Date getData_obito() {
		return super.getData_obito();
	}
	@Override
	public void setData_obito(Date data_obito) {
		super.setData_obito(data_obito);
	}
	


	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return super.toString() + "\nNome do médico: " + nome_medico + 
				" data de diagnostico " + data_diagnostico.getDate() + "/" + data_diagnostico.getMonth() + "/" + data_diagnostico.getYear() + " nível da doença: " + nivelDoenca;			
	}

}
