package classesDados;

public class Evento {

	private Paciente paciente;
	private Morada local_evento;
	private Familiar familiar;
	private String descricao;
	
	public Evento(Paciente p, Morada local, Familiar f, String desc) {
		this.paciente = p;
		this.local_evento = local;
		this.familiar = f;
		this.descricao = desc;
	}
	
	public Evento(Paciente p, Morada local, String desc) {
		this.paciente = p;
		this.local_evento = local;
		this.descricao = desc;
	}

	//GETTERS
	public Paciente getPaciente() {
		return paciente;
	}

	public Morada getLocal_evento() {
		return local_evento;
	}

	public Familiar getFamiliar() {
		return familiar;
	}

	public String getDescricao() {
		return descricao;
	}

	//SETTERS
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setLocal_evento(Morada local_evento) {
		this.local_evento = local_evento;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
