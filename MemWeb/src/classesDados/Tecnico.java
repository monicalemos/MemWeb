package classesDados;

import java.util.ArrayList;

import enumerados.TipoUtilizador;

public class Tecnico {

	private String nome;
	private String nome_utilizador;
	private String password;
	private TipoUtilizador tipo_utilizador;

	private ArrayList<Paciente> pacientes;

	public Tecnico(String nome, String nome_utilizador, String password) {
		this.nome = nome;
		this.nome_utilizador = nome_utilizador;
		this.password = password;

		this.tipo_utilizador = TipoUtilizador.TÉCNICO;
		this.pacientes = new ArrayList<Paciente>();
	}
	//LISTA PACIENTES:
	public void adicionaPaciente (Paciente p){
		pacientes.add(p);
	}
	public Paciente getPaciente(String nomeCompleto){
		for(Paciente pac : pacientes){
			if( pac.getNome_completo() == nomeCompleto)
				return pac;
		}
		return null;
	}
	public boolean encontraPaciente(String nome){
		boolean encontrou = false;
		for(Paciente pac : pacientes){
			if( pac.getNome_completo() == nome){
				System.out.println("Esse paciente existe: \n");
				encontrou = true;
			}
		}
		System.out.println("Esse paciente não existe: \n");
		return encontrou;
	}
	public boolean eliminaPaciente(Paciente p){
		boolean eliminou = false;
		if(pacientes.contains(p)){
			System.out.println("Eliminou paciente \n");
			pacientes.remove(p);
		}
		System.out.println("Não eliminou o paciente \n");
		return eliminou;
	}

	//GETTERS:
	public String getNome() {
		return nome;
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
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	//SETTERS:
	public void setNome_utilizador(String nome_utilizador) {
		this.nome_utilizador = nome_utilizador;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
