package classesDados;

import java.sql.Date;
import java.util.ArrayList;

import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;

public class Pessoa {

	private int idPessoa;
	private String nome_completo;
	private String[] nome;
	private String nomeProprio;
	private String apelido;
	private Date  data_de_nascimento;
	private Morada local_nascimento;
	private Morada morada;
	private TipoGenero genero;
	private TipoEstadoCivil estado_civil;
	private String profissao;
	
	private ArrayList <Relacao> relacoes;
	private ArrayList <Evento> eventos;
	
	public Pessoa(int idPessoa, String nome_completo, Date data_de_nascimento,
			Morada local_nascimento, TipoGenero genero, String profissao,
			Morada morada) {
		this.idPessoa = idPessoa;
		this.nome_completo = nome_completo;
		this.data_de_nascimento = data_de_nascimento;
		this.local_nascimento = local_nascimento;
		this.genero = genero;
		this.profissao = profissao;
		this.morada = morada;
		relacoes = new ArrayList<Relacao>();
		eventos = new ArrayList<Evento>();
	}
	
	public void novaRelacao(Relacao r){
		relacoes.add(r);
	}
	public boolean eliminaRelacao(Relacao r){
		for (Relacao rel : relacoes){
			if(rel == r){
				relacoes.remove(rel);
				return true;
			}
		}
		System.out.println("Essa relação não existe");
		return false;
	}

	public Relacao existeRelacaoPessoa(Pessoa p){
		for (Relacao rel : relacoes){
			if(rel.getFamiliar_nivel1().equals(p) || rel.getFamiliar_nivel2().equals(p)){
				System.out.println("Essa relação existe: \n");
				return rel;
			}
		}
		System.out.println("Essa relação não existe");
		return null;
	}
	public Relacao existeRelacaoPessoa_Pessoa(Pessoa p, Pessoa q){
		for(Relacao rel: relacoes){
			if((rel.getFamiliar_nivel1().equals(p) && rel.getFamiliar_nivel2().equals(q))
					|| (rel.getFamiliar_nivel1().equals(q) && rel.getFamiliar_nivel2().equals(p)))
				return rel;
		}
		return null;
	}
	
	public Relacao existeRelacaoPaciente(Paciente p){
		for (Relacao rel : relacoes){
			if(rel.getPaciente() == p){
				System.out.println("Essa relação existe: \n");
				return rel;
			}
		}
		System.out.println("Essa relação não existe");
		return null;
	}

	public String imprimeRelacoes(){
		for( Relacao r: relacoes){
			return r.toString() + ";\n";
		}
		System.out.println("não há relações entre esta pessoa");
		return null;
	}

	public void novoEvento(Evento e){
		eventos.add(e);
	}
	public boolean eliminaEvento(Evento e){
		for (Evento ev: eventos){
			if(ev == e){
				eventos.remove(ev);
				return true;
			}
		}
		System.out.println("Esse evento não existe");
		return false;
	}

	public Evento existeEvento(Evento e){
		for (Evento ev: eventos){
			if(ev == e){
				System.out.println("Esse evento existe: \n");
				return ev;
			}
		}
		System.out.println("Esse evento não existe");
		return null;
	}

	public String imprimeeventos(){
		for (Evento ev: eventos){
			return ev.toString() + ";\n";
		}
		System.out.println("não há eventos para esta pessoa");
		return null;
	}
	
	//GETTERS:
	public int getId() {
		return idPessoa;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public String[] getNome() {
		return nome;
	}

	public String getNomeProprio() {
		return nomeProprio;
	}

	public String getApelido() {
		return apelido;
	}

	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}

	public Morada getLocal_nascimento() {
		return local_nascimento;
	}

	public Morada getMorada() {
		return morada;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public TipoEstadoCivil getEstado_civil() {
		return estado_civil;
	}

	public String getProfissao() {
		return profissao;
	}

	public ArrayList<Relacao> getRelacoes() {
		return relacoes;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	
	//SETTERS:
	public void setNomeCompleto(String nome) {
		this.nome_completo = nome;
	}
	
	public void setApelido(String nome){
		String[] nomeTemp = nome.split(" ");
		this.apelido = nomeTemp[nomeTemp.length - 1];
	}

	public void setNomeProprio(String nome){
		String[] nomeTemp = nome.split(" ");
		this.nomeProprio = nomeTemp[0];
	}
		
	public void setEstado_civil(TipoEstadoCivil estado_civil) {
		this.estado_civil = estado_civil;
	}
	
	public void setMorada(Morada m){
		this.morada = m;
	}
	
	
}
