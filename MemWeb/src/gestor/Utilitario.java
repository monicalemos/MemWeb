package gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.BCrypt;
import baseDados.LigacaoBD;
import classesDados.Familiar;
import classesDados.Morada;
import classesDados.Paciente;
import classesDados.Relacao;
import classesDados.Tecnico;


public class Utilitario {
	private LigacaoBD ligacaoBD;
	private GestorBD gestorBD;

	public Utilitario() {
		ligacaoBD = new LigacaoBD();
		ligacaoBD.connect();
		gestorBD = new GestorBD(ligacaoBD.getConnection());
	}

	//PACIENTE
	public void registo_Paciente(Paciente paciente){
		gestorBD.insert_Paciente(paciente);
	}

	public int novoId_Paciente() throws SQLException{
		int iVelho = gestorBD.verificaId_Paciente();
		return iVelho+1;
	}

	public String verTodos_Pacientes(){
		ArrayList<Paciente> pacientes = gestorBD.selectAll_Pacientes();
		for(Paciente p : pacientes ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}
	
	public Paciente devolve_Paciente(int id){
		return gestorBD.select_PacienteId(id);
	}
	
	public Paciente devolve_Paciente(String user, String pass){
		Paciente p = gestorBD.select_PacienteNomeUtilizador(user);

		if (p != null) {
			if (BCrypt.checkpw(pass, p.getPassword())) {
				System.out.println("Password matches");
				return p;
			} else {
				System.out.println("Password does not match");
			}
		}

		return p;
	}
	
	public void apaga_PacienteNome(String nomeCompleto){
		gestorBD.delete_PacienteNome(nomeCompleto);
	}

	public void apaga_Paciente(Paciente p){
		gestorBD.delete_Paciente(p);
	}

	//MORADA
	public void registo_Morada(Morada morada){
		gestorBD.insert_Morada(morada);
	}
	
	public int novoId_Morada() throws SQLException {
		int iVelho = gestorBD.verificaId_Morada();
		return iVelho+1;
	}

	public String verTodos_Moradas() {
		ArrayList<Morada> moradas = gestorBD.selectAll_Moradas();
		for(Morada p : moradas ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public void apaga_Morada(Morada m){
		gestorBD.delete_Morada(m);
	}

	//FAMILIAR
	public void registo_Familiar(Familiar pessoa) {
		gestorBD.insert_Familiar(pessoa);		
	}

	public int novoId_Familiar() throws SQLException {
		int iVelho = gestorBD.verificaId_Familiar();
		return iVelho+1;
	}

	public String verTodos_Familiares(){
		ArrayList<Familiar> familiares = gestorBD.selectAll_Familiares();
		for(Familiar p : familiares ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}
	
	public Familiar devolve_Familiar(int id){
		return gestorBD.select_FamiliarId(id);
	}
	
	public Familiar devolve_Familiar(String user, String pass){
		Familiar f = gestorBD.select_FamiliarNomeUtilizador(user);

		if (f != null) {
			if (BCrypt.checkpw(pass, f.getPassword())) {
				System.out.println("Password matches");
				return f;
			} else {
				System.out.println("Password does not match");
			}
		}

		return f;
	}
	
	public void apaga_Familiar(Familiar pessoa){
		gestorBD.delete_Familiar(pessoa);
	}

	//TECNICO
	public int registo_Tecnico(Tecnico utilizador) {
		return gestorBD.insert_Tecnico(utilizador);

	}

	public int novoId_Tecnico() throws SQLException {
		int iVelho = gestorBD.verificaId_Tecnico();
		return iVelho+1;
	}

	public Tecnico devolve_Tecnico(String email, String pass){
		Tecnico resp = gestorBD.select_TecnicoEmail(email);

		if (resp != null) {
			if (BCrypt.checkpw(pass, resp.getPassword())) {
				System.out.println("Password matches");
				return resp;
			} else {
				System.out.println("Password does not match");
			}
		}

		return resp;
	}

	public Tecnico devolve_Tecnico(int id){
		return gestorBD.select_TecnicoId(id);
	}

	public String verTodos_Tecnicos() {
		ArrayList<Tecnico> tecnicos = gestorBD.selectAll_Tecnicos();
		for(Tecnico p : tecnicos ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public void apaga_Tecnico(Tecnico u){
		gestorBD.delete_Tecnico(u);
	}
	
	
	//RELACAO_PACIENTE_FAMILIAR
	
	public int registo_Relacao_Paciente_Familiar(Relacao relacao) {
		return gestorBD.insert_Relacao_Paciente_Familiar(relacao);

	}

	public int novoId_Relacao_Paciente_Familiar() throws SQLException {
		int iVelho = gestorBD.verificaId_Relacao_Paciente_Familiar();
		return iVelho+1;
	}


	public Relacao devolve_Relacao_Paciente_Familiar(int id){
		return gestorBD.select_Relacao_Paciente_FamiliarId(id);
	}

	public String verTodos_Relacao_Paciente_Familiar() {
		ArrayList<Relacao> relacoes = gestorBD.selectAll_Relacao_Paciente_Familiar();
		for(Relacao p : relacoes ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public String verTodos_Relacao_Paciente_Familiar_Do_Paciente(Paciente p) {
		ArrayList<Relacao> relacoes = gestorBD.selectAll_Relacao_Paciente_Familiar_Do_Paciente(p);
		for(Relacao r : relacoes ){
			return r.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}
	
	public void apaga_Relacao_Paciente_Familiar(Familiar f){
		gestorBD.delete_Relacao_Paciente_Familiar(f);
	}
	
	//RELACAO_Familiar_FAMILIAR
	
	public int registo_Relacao_Familiar_Familiar(Relacao relacao) {
		return gestorBD.insert_Relacao_Familiar_Familiar(relacao);

	}

	public int novoId_Relacao_Familiar_Familiar() throws SQLException {
		int iVelho = gestorBD.verificaId_Relacao_Familiar_Familiar();
		return iVelho+1;
	}


	public Relacao devolve_Relacao_Familiar_Familiar(int id){
		return gestorBD.select_Relacao_Familiar_FamiliarId(id);
	}

	public String verTodos_Relacao_Familiar_Familiar(Paciente pac) {
		ArrayList<Relacao> relacoes = gestorBD.selectAll_Relacao_Familiar_Familiar(pac);
		for(Relacao p : relacoes ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public String verTodos_Relacao_Familiar_Familiar_Do_Familiar(Paciente p, Familiar f) {
		ArrayList<Relacao> relacoes = gestorBD.selectAll_Relacao_Familiar_Familiar_Do_Familiar(p, f);
		for(Relacao r : relacoes ){
			return r.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}
	
	public void apaga_Relacao_Familiar_Familiar(Familiar f){
		gestorBD.delete_Relacao_Familiar_Familiar(f);
	}

}
