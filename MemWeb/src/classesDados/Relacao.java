package classesDados;

public class Relacao {

	private Pessoa pessoa;
	private Paciente paciente;
	private Categoria tipoRelacao;

	public Relacao(Pessoa pes, Paciente pac, Categoria tipoRelacao){
		this.pessoa = pes;
		this.paciente = pac;
		this.tipoRelacao = tipoRelacao;
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


	@Override
	public String toString() {
		return "Relacao entre a pessoa " + pessoa.getNomeCompleto() + " e o paciente " + paciente.getNomeCompleto()
				+ "\ncom o seguinte tipo de relacao: " + tipoRelacao + "\n";
	}

}
