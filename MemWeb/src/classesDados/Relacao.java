package classesDados;

import java.util.ArrayList;

import enumerados.TipoParentesco;
import enumerados.TipoRelacao;

public class Relacao {

	private Paciente paciente;
	private ArrayList<Familiar> familiares;
	private TipoRelacao tipo_relacao;
	
	public Relacao(Paciente paciente, TipoRelacao tipo_relacao) {
		this.paciente = paciente;
		this.familiares = new ArrayList<Familiar>();
		this.tipo_relacao = tipo_relacao;
	}
	
	//GETTERS:
	public Paciente getPaciente() {
		return paciente;
	}
	public ArrayList<Familiar> getFamiliares() {
		return familiares;
	}
	public TipoRelacao getTipo_relacao() {
		return tipo_relacao;
	}
	
	//SETTERS:
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setTipo_relacao(TipoRelacao tipo_relacao) {
		this.tipo_relacao = tipo_relacao;
	}
	
	public void adicionaFamilar(Familiar f){
		familiares.add(f);
	}
	public boolean removeFamiliar(Familiar f){
		boolean removeu = false;
		
		if(familiares.contains(f)){
			familiares.remove(f);
			removeu = true;
		}
		return removeu;
	}

	public Pessoa getFamiliar(Pessoa p) {
		if(familiares.contains(p)){
			return p;
		}
		return null;
	}	
}
