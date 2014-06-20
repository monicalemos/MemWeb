package classesDados;
import java.util.Date;

import enumerados.TipoEvento;

public class Evento {

	private Pessoa pessoa;
	private Paciente paciente;
	private Morada morada;
	private Date data;
	private TipoEvento tipo_evento;
	private String descricao;
	
	

	public Evento(Pessoa pessoa, Paciente paciente, Morada morada, Date data, TipoEvento tipoEvento, String descricao) {
		this.pessoa = pessoa;
		this.paciente = paciente;
		this.morada = morada;
		this.data = data;
		this.tipo_evento = tipoEvento;
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Morada getMorada() {
		return morada;
	}

	public void setMorada(Morada morada) {
		this.morada = morada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoEvento getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(TipoEvento tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Evento entre a pessoa " + pessoa.getNomeCompleto() + " e o  paciente " + paciente.getNomeCompleto()
				+ "\nna morada " + morada + " na data " + data.getDay() + "/" + data.getMonth() + "/" + data.getYear() + "\nTipo de evento "
				+ tipo_evento + "\n";
	}
	
	
}
