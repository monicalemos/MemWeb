package gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.BCrypt;
import baseDados.LigacaoBD;
import classesDados.Morada;
import classesDados.Paciente;
import classesDados.Pessoa;
import classesDados.Utilizador;


public class Utilitario {
	private LigacaoBD ligacaoBD;
	private GestorBD gestorBD;

	public Utilitario() {
		ligacaoBD = new LigacaoBD();
		ligacaoBD.connect();
		gestorBD = new GestorBD(ligacaoBD.getConnection());
	}

	public void registoPaciente(Paciente paciente){
		gestorBD.insertPaciente(paciente);
	}

	public int novoIdPaciente() throws SQLException{
		int iVelho = gestorBD.verificaIdPaciente();
		return iVelho+1;
	}

	public String verTodosPacientes(){
		ArrayList<Paciente> pacientes = gestorBD.selectAllPacientes();
		for(Paciente p : pacientes ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public void apagaPacienteNome(String nomeCompleto){
		gestorBD.deletePacienteNome(nomeCompleto);
	}

	public void apagaPaciente(Paciente p){
		gestorBD.deletePaciente(p);
	}

	public void registoMorada(Morada morada){
		gestorBD.insertMorada(morada);
	}
	public int novoIdMorada() throws SQLException {
		int iVelho = gestorBD.verificaIdMorada();
		return iVelho+1;
	}

	public String verTodasMoradas() {
		ArrayList<Morada> moradas = gestorBD.selectAllMoradas();
		for(Morada p : moradas ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}

	public void apagaMorada(Morada m){
		gestorBD.deleteMorada(m);
	}

	public boolean registoUtilizador(Utilizador utilizador) {
		return gestorBD.inserUtilizador(utilizador);

	}

	public int novoIdUtilizador() throws SQLException {
		int iVelho = gestorBD.verificaIdUtilizador();
		return iVelho+1;
	}

	public Utilizador devolveUtilizador(String email, String pass){
		Utilizador resp = gestorBD.selectUtilizadorEmail(email);

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

	public Utilizador devolveUtilizador(int id){
		return gestorBD.selectUtilizadorId(id);
	}

	public void apagaUtilizador(Utilizador u){
		gestorBD.deleteUtilizador(u);
	}

	public String verTodosUtilizadores() {
		ArrayList<Utilizador> utilizadores = gestorBD.selectAllUtilizadores();
		for(Utilizador p : utilizadores ){
			return p.toString() + "\n";
		}
		return "Não há pacientes a imprimir";
	}
	
	public void registoPessoa(Pessoa pessoa) {
		gestorBD.insertPessoa(pessoa);		
	}

	public int novoIdPessoa() throws SQLException {
		int iVelho = gestorBD.verificaIdPessoa();
		return iVelho+1;
	}
	
	public void apagaPessoa(Pessoa pessoa){
		gestorBD.deletePessoa(pessoa);
	}

	

}
