package classesDados;

import java.sql.Date;
import java.util.ArrayList;

import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;
import enumerados.TipoUtilizador;

public class Utilizador extends Pessoa {


	private String password;
	private TipoUtilizador tipoUtilizador;
	private ArrayList<Paciente> pacientes;
	public Utilizador(int id, String nomeCompleto, Date data_nascimento, TipoGenero gen, int telefone, String email, Morada morada, String password, TipoUtilizador tipoUtilizador
			) {
		super(id, nomeCompleto, data_nascimento, gen, telefone, email, morada);
		this.password = password;
		this.tipoUtilizador = tipoUtilizador;
		this.pacientes = new ArrayList<Paciente>();
	}
	
	public void inserePaciente(Paciente p){
		pacientes.add(p);
	}
	
	public String removePaciente(int idPaciente){
		for(Paciente p: pacientes){
			if(p.getId() == idPaciente){
				pacientes.remove(p);
				return "Paciente removido com sucesso";		
			}
		}
		return "Paciente não encontrado";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUtilizador() {
		return tipoUtilizador.toString();
	}

	public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador;
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
	public String toString(){
		return "nome: " + getNomeCompleto();
	}

}
