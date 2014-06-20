package classesDados;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;

public class Pessoa {
	private int idPessoa;
	private String nome_completo;
	private String[] nome;
	private String nomeProprio;
	private String apelido;
	private Date  data_de_nascimento;
	private Date data_obito;
	private TipoEstadoCivil estado_civil;
	private TipoGenero genero;
	private String hojeString;
	private Date hoje;
	private Morada morada;
	private int telefone;
	private String email;
	private ArrayList <Relacao> relacoes;
	private ArrayList <Evento> eventos;


	public Pessoa(int id, String nomeCompleto, Date data_nascimento, TipoEstadoCivil estado_civil, TipoGenero gen, int telefone, String email, Morada morada) {
		this.idPessoa = id;
		this.nome_completo = nomeCompleto;
		this.nome = nomeCompleto.split(" ");
		this.nomeProprio = nome[0];
		this.apelido = nome[nome.length - 1];
		this.data_de_nascimento = data_nascimento;
		this.estado_civil = estado_civil;
		this.genero = gen;
		this.telefone = telefone;
		this.email = email;
		this.morada = morada;
		relacoes = new ArrayList<Relacao>();
		eventos = new ArrayList<Evento>();
		hojeString = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
		hoje = getDataHoje();
	}
	

	public Pessoa(int id, String nomeCompleto, Date data_nascimento, TipoGenero gen, int telefone, String email, Morada morada) {
		this.idPessoa = id;
		this.nome_completo = nomeCompleto;
		this.nome = nomeCompleto.split(" ");
		this.nomeProprio = nome[0];
		this.apelido = nome[nome.length - 1];
		this.data_de_nascimento = data_nascimento;
		this.genero = gen;
		this.telefone = telefone;
		this.email = email;
		this.morada = morada;
		relacoes = new ArrayList<Relacao>();
		eventos = new ArrayList<Evento>();
		hojeString = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
		//hoje = getDataHoje();
	}

	@SuppressWarnings("deprecation")
	private Date getDataHoje() {
		String dataCompletaHoje[] = hojeString.split(" ");
		String dataHoje[] = dataCompletaHoje[0].split("/");
	
		switch(dataHoje[1]){
		case "Jan":
			dataHoje[1] = "01";
			break;
		case "Feb":
			dataHoje[1] = "02";
			break;
		case "Mar":
			dataHoje[1] = "03";
			break;
		case "Apr":
			dataHoje[1] = "04";
			break;
		case "May":
			dataHoje[1] = "05";
			break;
		case "Jun":
			dataHoje[1] = "06";
			break;
		case "Jul":
			dataHoje[1] = "07";
			break;
		case "Aug":
			dataHoje[1] = "08";
			break;
		case "Sep":
			dataHoje[1] = "09";
			break;
		case "Oct":
			dataHoje[1] = "10";
			break;
		case "Nov":
			dataHoje[1] = "11";
			break;
		case "Dez":
			dataHoje[1] = "12";
			break;
		}
		Date date = new Date(Integer.parseInt(dataHoje[2]), Integer.parseInt(dataHoje[1]), Integer.parseInt(dataHoje[0]));		
		
		return date;
	}
	public Pessoa(String nomeCompleto, int telefone){
		this.nome_completo = nomeCompleto;
		this.nome = nomeCompleto.split(" ");
		this.nomeProprio = nome[0];
		this.apelido = nome[nome.length - 1];
		this.telefone = telefone;
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
			if(rel.getPessoa() == p){
				System.out.println("Essa relação existe: \n");
				return rel;
			}
		}
		System.out.println("Essa relação não existe");
		return null;
	}
	public Relacao existeRelacaoPessoa(Paciente p){
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
		System.out.println("Não há relações entre esta pessoa");
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
		System.out.println("Não há eventos para esta pessoa");
		return null;
	}

	//	public Date getDataHoje(){
	//		return hoje;
	//	}
	//	public void setDataHoje(Date d){
	//		this.hoje= d;
	//	}
	public int getId() {
		return idPessoa;
	}
	public void setId(int id) {
		this.idPessoa = id;
	}
	
	public String getNomeCompleto() {
		return nome_completo;
	}

	public void setNomeCompleto(String nome) {
		this.nome_completo = nome;
	}

	public String getNomeProprio(){
		return nomeProprio;
	}

	public String getApelido(){
		return apelido;
	}

	public void setApelido(String nome){
		String[] nomeTemp = nome.split(" ");
		this.apelido = nomeTemp[nomeTemp.length - 1];
	}

	public void setNomeProprio(String nome){
		String[] nomeTemp = nome.split(" ");
		this.nomeProprio = nomeTemp[0];
	}

	public Date getData_obito() {
		return data_obito;
	}

	public void setData_obito(Date data_obito) {
		this.data_obito = data_obito;
	}

	public String getEstado_civil() {
		return estado_civil.toString();
	}

	public void setEstado_civil(TipoEstadoCivil estado_civil) {
		this.estado_civil = estado_civil;
	}

	public Date getData_nascimento() {
		return data_de_nascimento;
	}

	public String getGenero() {
		return genero.toString();
	}

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Morada getMorada(){
		return morada;
	}

	public void setMorada(Morada m){
		this.morada = m;
	}

	@SuppressWarnings("deprecation")
		public int getIdade(){
	
			int idade = 0;
	
			int ano1 = hoje.getYear();
			int ano2 = data_de_nascimento.getYear();
	
			int mes1 = hoje.getMonth();
			int mes2 = data_de_nascimento.getMonth();
	
			int dia1 = hoje.getDate();
			int dia2 = data_de_nascimento.getDate();
	
			if(mes2 > mes1){
				idade = (ano1 - ano2) - 1;
			}
			else{
				System.out.println("o mês é inferior" + mes2);
				if (dia2 > dia1){
					System.out.println("o dia é inferior" + dia2);
					idade = (ano1 - ano2) - 1;
				}
				else
					idade = ano1 - ano2;
	
			}
			return idade;
	
		}

		@SuppressWarnings("deprecation")
		public String imprimeHoje(){
			return hoje.getDate() + "/" + hoje.getMonth() + "/" + hoje.getYear();
		}

	@SuppressWarnings("deprecation")
	public String toString(){
		if(data_obito == null){
			return "Data de Hoje: " + imprimeHoje() + 
					"\nPessoa: " + nome_completo + " (" + apelido + ", " +  nomeProprio + ") " + " é do género " + genero 
					+ "\nNasceu no dia: " + data_de_nascimento.getDate() + "/" + data_de_nascimento.getMonth() + "/" +  data_de_nascimento.getYear() + 
					", tem " + getIdade() + " anos e é " 
					+ estado_civil + 
					"\n" + morada;
		}
		else{
			return "Pessoa: " + nome_completo + " (" + apelido + ", " +  nomeProprio + ") " + " é do género " + genero 
					+ "\nNasceu no dia: " + data_de_nascimento.getDate() + "/" + data_de_nascimento.getMonth() + "/" +  data_de_nascimento.getYear() + 
					" e faleceu a: " +data_obito.getDate() + "/" + data_obito.getMonth() + "/" +  data_obito.getYear()  +"e era " + estado_civil + "\n" + morada;
		}
	}

}
