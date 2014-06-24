package gestor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import baseDados.Queries;
import classesDados.Morada;
import classesDados.Paciente;
import classesDados.Pessoa;
import classesDados.Utilizador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import enumerados.TipoEstadoCivil;
import enumerados.TipoGenero;
import enumerados.TipoUtilizador;

public class GestorBD {
	private PreparedStatement preparedStatement;
	//	private PreparedStatement preparedStatement2;
	private Connection connection;
	HttpSession session = null;

	public GestorBD(Connection connection) {
		this.connection = connection;
	}

	public int insertPaciente(Paciente u) {
		int row = 0;
		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insertPaciente);
			preparedStatement.setInt(1, u.getId());
			preparedStatement.setString(2, u.getNome_completo());
			preparedStatement.setString(3, u.getNomeProprio());
			preparedStatement.setString(4, u.getApelido());
			preparedStatement.setDate(5, (Date) u.getData_de_nascimento());
			preparedStatement.setString(6, u.getEstado_civil());
			preparedStatement.setString(7, u.getGenero());
			preparedStatement.setDate(10, null );
			preparedStatement.setString(11, u.getNome_medico());
			preparedStatement.setInt(14, u.getNivelDoenca());
			preparedStatement.setInt(15, u.getMorada().getId());
			preparedStatement.setInt(16, u.getUtilizador().getId());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do paciente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o paciente " + u.getNome_completo());
		}
		return row;
	}

	public int verificaIdPaciente() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoIdPaciente);
		ResultSet resultSet = preparedStatement.executeQuery();
		int lastInsertedId = 0;

		if (resultSet != null) {
			if (resultSet.next()) {
				lastInsertedId=resultSet.getInt(1);
			}
			resultSet.close();
		}
		return lastInsertedId;
	}

	public ArrayList<Paciente> selectAllPacientes(){
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAllPacientesComMorada);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {	
				pacientes.add(new Paciente(resultSet.getInt("idPaciente"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						TipoEstadoCivil.valueOf(resultSet.getString("estado_civil")), 
						TipoGenero.valueOf(resultSet.getString("genero")), 
						resultSet.getInt("telefone"), 
						resultSet.getString("email"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("rua"),
								resultSet.getString("num_de_porta"),
								resultSet.getInt("andar"),
								resultSet.getString("num_porta_andar"),
								resultSet.getString("cod_postal")), 
								resultSet.getString("nome_medico"),
								resultSet.getInt("telefone_medico"),
								resultSet.getDate("data_de_diagnostico"),
								resultSet.getInt("nivel_de_doenca"),
								selectUtilizadorId(resultSet.getInt("IdUtilizador"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem pacientes");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pacientes;
	}
	public int deletePacienteNome(String nomeCompleto){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.deletePacienteNome);
			preparedStatement.setString(1, nomeCompleto);
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar o paciete " + nomeCompleto);
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public int deletePaciente(Paciente p){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.deletePaciente);
			preparedStatement.setInt(1, p.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar o paciete " + p.getNome_completo());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	public int insertMorada(Morada m) {
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insertMorada);
			preparedStatement.setInt(1, m.getId());
			preparedStatement.setString(2, m.getPais());
			preparedStatement.setString(3, m.getCidade());
			preparedStatement.setString(4, m.getRua());
			preparedStatement.setString(5, m.getPais());
			preparedStatement.setString(5, m.getNumPortaPredio());
			preparedStatement.setInt(6, m.getAndar());
			preparedStatement.setString(7, m.getNumPortaAndar());
			preparedStatement.setString(8, m.getCodPostal());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts da morada");
		} catch (Exception e) {
			System.out.println("Não conseguiu inserir a morada " + m);
			e.printStackTrace();
		}
		return row;
	}

	public int verificaIdMorada() throws SQLException {

		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoIdMorada);
		ResultSet resultSet = preparedStatement.executeQuery();
		int lastInsertedId = 0;

		if (resultSet != null) {
			if (resultSet.next()) {
				lastInsertedId=resultSet.getInt(1);
			}
			resultSet.close();
		}
		return lastInsertedId;
	}

	public ArrayList<Morada> selectAllMoradas(){
		ArrayList<Morada> moradas = new ArrayList<Morada>();

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAllMoradas);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				moradas.add(new Morada(resultSet.getInt("idMorada"), 
						resultSet.getString("pais"),
						resultSet.getString("cidade"), 
						resultSet.getString("rua"), 
						resultSet.getString("num_de_porta"), 
						resultSet.getInt("andar"),
						resultSet.getString("num_porta_andar"),
						resultSet.getString("cod_postal")));
			}
		} catch (SQLException e) {
			System.out.println("A base de dados não tem moradas");
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return moradas;
	}
	public int deleteMorada(Morada morada){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.deleteUtilizador);
			preparedStatement.setInt(1, morada.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não conseguiu apagar a morada " + morada);
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	public boolean inserUtilizador(Utilizador rm) {
		boolean resultado = false;
		int row;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insertUtilizador);
			preparedStatement.setInt(1, rm.getId());
			preparedStatement.setString(2, rm.getNomeCompleto());
			preparedStatement.setString(3, rm.getNomeProprio());
			preparedStatement.setString(4, rm.getApelido());
			preparedStatement.setDate(5, (Date) rm.getData_nascimento());
			preparedStatement.setString(6, rm.getGenero());
			preparedStatement.setInt(7, rm.getTelefone() );
			preparedStatement.setString(8, rm.getEmail() );	
			preparedStatement.setInt(9, rm.getMorada().getId());
			preparedStatement.setString(10, rm.getPassword());
			preparedStatement.setString(11, rm.getTipoUtilizador());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do responsavel medicos");
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o utilizador " + rm.getNomeCompleto());
			resultado=false;
		}
		return resultado;

	}

	public int verificaIdUtilizador() throws SQLException{
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoIdUtilizador);
		ResultSet resultSet = preparedStatement.executeQuery();
		int lastInsertedId = 0;

		if (resultSet != null) {
			if (resultSet.next()) {
				lastInsertedId=resultSet.getInt(1);
			}
			resultSet.close();
		}
		return lastInsertedId;
	}

	public Utilizador selectUtilizadorEmail(String email) {
		Utilizador utilizador = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectUtilizadorEmail);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Morada morada = new Morada(resultSet.getInt("idMorada"),
						resultSet.getString("pais"),
						resultSet.getString("cidade"),
						resultSet.getString("rua"),
						resultSet.getString("num_de_porta"),
						resultSet.getInt("andar"),
						resultSet.getString("num_porta_andar"),
						resultSet.getString("cod_postal"));

				utilizador = new Utilizador(resultSet.getInt("idUtilizador"),
						resultSet.getString("nome_completo"),
						resultSet.getDate("data_de_nascimento"),
						TipoGenero.valueOf(resultSet.getString("genero")),
						resultSet.getInt("telefone"),
						resultSet.getString("email"), 
						morada,
						resultSet.getString("pass"),
						TipoUtilizador.valueOf(resultSet.getString("tipo_utilizador")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem  o utilizador com o email " + email );
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return utilizador;
	}

	public Utilizador selectUtilizadorId(int idUtilizador) {
		Utilizador utilizador = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectUtilizadorId);
			preparedStatement.setInt(1, idUtilizador);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Morada morada = new Morada(resultSet.getInt("idMorada"),
						resultSet.getString("pais"),
						resultSet.getString("cidade"),
						resultSet.getString("rua"),
						resultSet.getString("num_de_porta"),
						resultSet.getInt("andar"),
						resultSet.getString("num_porta_andar"),
						resultSet.getString("cod_postal"));

				utilizador = new Utilizador(resultSet.getInt("idUtilizador"),
						resultSet.getString("nome_completo"),
						resultSet.getDate("data_de_nascimento"),
						TipoGenero.valueOf(resultSet.getString("genero")),
						resultSet.getInt("telefone"),
						resultSet.getString("email"), 
						morada,
						resultSet.getString("pass"),
						TipoUtilizador.valueOf(resultSet.getString("tipo_utilizador")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("O utilizador com id " + idUtilizador + " não existe na BD");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return utilizador;
	}

	public ArrayList<Utilizador> selectAllUtilizadores(){
		ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAllUtilizadores);
			ResultSet resultSet = preparedStatement.executeQuery();
	
			while (resultSet.next()) {	
				utilizadores.add(new Utilizador(resultSet.getInt("idUtilizador"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						TipoGenero.valueOf(resultSet.getString("genero")), 
						resultSet.getInt("telefone"), 
						resultSet.getString("email"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("rua"),
								resultSet.getString("num_de_porta"),
								resultSet.getInt("andar"),
								resultSet.getString("num_porta_andar"),
								resultSet.getString("cod_postal")),
								resultSet.getString("pass"),
								TipoUtilizador.valueOf(resultSet.getString("tipo_utilizador"))));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem utilizadores");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return utilizadores;
	}

	public int deleteUtilizador(Utilizador utilizador){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.deleteUtilizador);
			preparedStatement.setInt(1, utilizador.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar o utilizador " + utilizador.getNomeCompleto());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public int insertPessoa(Pessoa p) {
		int row = 0;
		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insertPessoa);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getNome_completo());
			preparedStatement.setString(3, p.getNomeProprio());
			preparedStatement.setString(4, p.getApelido());
			preparedStatement.setDate(5, (Date) p.getData_de_nascimento());
			preparedStatement.setString(6, p.getEstado_civil());
			preparedStatement.setString(7, p.getGenero());
			preparedStatement.setInt(8, p.getTelefone() );
			preparedStatement.setString(9, p.getEmail() );	
			preparedStatement.setInt(15, p.getMorada().getId());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do paciente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o paciente " + p.getNome_completo());
		}
		return row;		
	}

	public int verificaIdPessoa() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoIdPessoa);
		ResultSet resultSet = preparedStatement.executeQuery();
		int lastInsertedId = 0;

		if (resultSet != null) {
			if (resultSet.next()) {
				lastInsertedId=resultSet.getInt(1);
			}
			resultSet.close();
		}
		return lastInsertedId;
	}

	public int deletePessoa(Pessoa pessoa){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.deletePessoa);
			preparedStatement.setInt(1, pessoa.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar a pessoa " + pessoa.getNome_completo());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public ArrayList<Pessoa> selectAllPessoas(){
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAllPessoas);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {	
				pessoas.add(new Pessoa(resultSet.getInt("idUtilizador"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						TipoEstadoCivil.valueOf(resultSet.getString("estado_civil")),
						TipoGenero.valueOf(resultSet.getString("genero")),
						resultSet.getInt("telefone"), 
						resultSet.getString("email"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("rua"),
								resultSet.getString("num_de_porta"),
								resultSet.getInt("andar"),
								resultSet.getString("num_porta_andar"),
								resultSet.getString("cod_postal"))));
			}


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem pessoas");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pessoas;
	}
}
