package classesDados;
import enumerados.TipoParentesco;
import enumerados.TipoRelacao;


public class Categoria {

	private TipoRelacao tipoRelacao;
	private TipoParentesco especificaParentesco;
	private int nivelAfinidade;
	
	public Categoria(TipoRelacao tipo, TipoParentesco parentesco, int nivelAfinidade) {
		this.tipoRelacao = tipo;
		this.nivelAfinidade = nivelAfinidade;
		if(tipo == TipoRelacao.FAMILIA && parentesco != TipoParentesco.N_A)
			this.especificaParentesco = parentesco;	
	}

	public TipoRelacao getTipoRelacao() {
		return tipoRelacao;
	}

	public void setTipoRelacao(TipoRelacao tipoRelacao) {
		this.tipoRelacao = tipoRelacao;
	}

	public TipoParentesco getEspecificaRelacao() {
		return especificaParentesco;
	}

	public void setEspecificaRelacao(TipoParentesco especificaRelacao) {
		this.especificaParentesco = especificaRelacao;
	}

	public int getNivelAfinidade() {
		return nivelAfinidade;
	}

	public void setNivelAfinidade(int nivelAfinidade) {
		this.nivelAfinidade = nivelAfinidade;
	}

	@Override
	public String toString() {
		return "Categoria de rela��o do tipo " + tipoRelacao + ", com o seguinte grau de parentesco "
				+ especificaParentesco + " e com o nivel de afinidade " + nivelAfinidade
				+ "\n";
	}
	

}
