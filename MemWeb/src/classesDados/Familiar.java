package classesDados;

import java.sql.Date;

import enumerados.TipoGenero;
import enumerados.TipoParentesco;

public class Familiar extends Pessoa{

	private TipoParentesco parentesco;
	private boolean eCuidador;
	private Date data_obito;
	
	private Paciente paciente;

	public Familiar(int idPessoa, String nome_completo,
			Date data_de_nascimento, Morada local_nascimento,
			TipoGenero genero, String profissão, Morada morada,
			TipoParentesco parentesco, boolean eCuidador, Date data_obito,
			Paciente paciente) {
		super(idPessoa, nome_completo, data_de_nascimento, local_nascimento,
				genero, profissão, morada);
		this.parentesco = parentesco;
		this.eCuidador = eCuidador;
		this.data_obito = data_obito;
		this.paciente = paciente;
	}

	//GETTERS:
	public TipoParentesco getParentesco() {
		return parentesco;
	}

	public boolean iseCuidador() {
		return eCuidador;
	}

	public Date getData_obito() {
		return data_obito;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	//SETTERS
	public void setParentesco(TipoParentesco parentesco) {
		this.parentesco = parentesco;
	}

	public void seteCuidador(boolean eCuidador) {
		this.eCuidador = eCuidador;
	}

	public void setData_obito(Date data_obito) {
		this.data_obito = data_obito;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
