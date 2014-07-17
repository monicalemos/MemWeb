package gestor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import baseDados.Queries;
import classesDados.Familiar;
import classesDados.Morada;
import classesDados.Paciente;
import classesDados.Relacao;
import classesDados.Tecnico;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import enumerados.EspecialidadeMedico;
import enumerados.TipoEscolaridade;
import enumerados.TipoGenero;
import enumerados.TipoRelacao;

public class GestorBD {
	private PreparedStatement preparedStatement;
	//	private PreparedStatement preparedStatement2;
	private Connection connection;
	HttpSession session = null;

	public GestorBD(Connection connection) {
		this.connection = connection;
	}


	//PACIENTE
	public int insert_Paciente(Paciente u) {
		int row = 0;
		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Paciente);
			preparedStatement.setInt(1, u.getId());
			preparedStatement.setString(2, u.getNome_completo());
			preparedStatement.setString(3, u.getNomeProprio());
			preparedStatement.setString(4, u.getApelido());
			preparedStatement.setDate(5, (Date) u.getData_de_nascimento());
			preparedStatement.setInt(6, u.getLocal_nascimento().getId());
			preparedStatement.setInt(7, u.getMorada().getId());
			preparedStatement.setString(8, u.getGenero().toString());
			preparedStatement.setString(9, u.getProfissao());
			preparedStatement.setString(10, u.getEscolaridade().toString());
			preparedStatement.setString(11, u.getEstado_civil().toString());
			preparedStatement.setInt(12, u.getNivel_doenca());
			preparedStatement.setString(13, u.getNome_medico());
			preparedStatement.setString(14, u.getEspecialidade_medico().toString());
			preparedStatement.setString(15, u.getNome_utilizador());
			preparedStatement.setString(16, u.getPassword());
			preparedStatement.setInt(17, u.getNivel_sessao());
			preparedStatement.setInt(18, u.getTecnico().getId());

			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do paciente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o paciente " + u.getNome_completo());
		}
		return row;
	}

	public int verificaId_Paciente() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Paciente);
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

	public ArrayList<Paciente> selectAll_Pacientes(){
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_PacientesComMorada);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {	
				pacientes.add(new Paciente(resultSet.getInt("idPaciente"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("regiao")),
								new Morada(resultSet.getInt("idMorada"), 
										resultSet.getString("pais"),
										resultSet.getString("cidade"),
										resultSet.getString("regiao")), 
										TipoGenero.valueOf(resultSet.getString("genero")),
										resultSet.getString("profissao"),
										TipoEscolaridade.valueOf(resultSet.getString("escolaridade")),
										resultSet.getInt("nivel_de_doenca"), 
										resultSet.getString("nome_medico"),
										EspecialidadeMedico.valueOf(resultSet.getString("especialidade_medico")),
										resultSet.getString("nome_utilizador"),
										resultSet.getString("password"),
										resultSet.getInt("nivel_sessao"),
										select_TecnicoId(resultSet.getInt("Tecnico_idTecnico"))));
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

	public Paciente select_PacienteId(int id){
		Paciente paciente = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_PacienteId);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				paciente = new Paciente(resultSet.getInt("idPaciente"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("regiao")),
								new Morada(resultSet.getInt("idMorada"), 
										resultSet.getString("pais"),
										resultSet.getString("cidade"),
										resultSet.getString("regiao")), 
										TipoGenero.valueOf(resultSet.getString("genero")),
										resultSet.getString("profissao"),
										TipoEscolaridade.valueOf(resultSet.getString("escolaridade")),
										resultSet.getInt("nivel_de_doenca"), 
										resultSet.getString("nome_medico"),
										EspecialidadeMedico.valueOf(resultSet.getString("especialidade_medico")),
										resultSet.getString("nome_utilizador"),
										resultSet.getString("password"),
										resultSet.getInt("nivel_sessao"),
										select_TecnicoId(resultSet.getInt("Tecnico_idTecnico")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("O tecnico com id " + id + " não existe na BD");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return paciente;

	}
	public int delete_PacienteNome(String nomeCompleto){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_PacienteNome);
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

	public int delete_Paciente(Paciente p){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Paciente);
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

	//MORADA:
	public int insert_Morada(Morada m) {
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Morada);
			preparedStatement.setInt(1, m.getId());
			preparedStatement.setString(2, m.getPais());
			preparedStatement.setString(3, m.getCidade());
			preparedStatement.setString(4, m.getRegiao());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts da morada");
		} catch (Exception e) {
			System.out.println("Não conseguiu inserir a morada " + m);
			e.printStackTrace();
		}
		return row;
	}

	public int verificaId_Morada() throws SQLException {

		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Morada);
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

	public ArrayList<Morada> selectAll_Moradas(){
		ArrayList<Morada> moradas = new ArrayList<Morada>();

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Moradas);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				moradas.add(new Morada(resultSet.getInt("idMorada"), 
						resultSet.getString("pais"),
						resultSet.getString("cidade"), 
						resultSet.getString("regiao")));
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
	public int delete_Morada(Morada morada){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Tecnico);
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
	public int insert_Familiar(Familiar p) {
		int row = 0;
		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Familiar);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getNome_completo());
			preparedStatement.setString(3, p.getNomeProprio());
			preparedStatement.setString(4, p.getApelido());
			preparedStatement.setDate(5, (Date) p.getData_de_nascimento());
			preparedStatement.setInt(6, p.getLocal_nascimento().getId());
			preparedStatement.setString(7, p.getGenero().toString());
			preparedStatement.setString(8, p.getEstado_civil().toString());
			preparedStatement.setString(9, p.getProfissao());
			preparedStatement.setInt(10, p.getMorada().getId());
			preparedStatement.setBoolean(11, p.eCuidador());
			preparedStatement.setString(12, p.getNome_utilizador());
			preparedStatement.setString(13, p.getPassword());

			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do paciente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o paciente " + p.getNome_completo());
		}
		return row;		
	}


	//FAMILIAR
	public int verificaId_Familiar() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Familiar);
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


	public ArrayList<Familiar> selectAll_Familiares(){
		ArrayList<Familiar> familiares = new ArrayList<Familiar>();

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Familiares);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {	
				familiares.add(new Familiar(resultSet.getInt("idFamiliar"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("regiao")),
								TipoGenero.valueOf(resultSet.getString("genero")),
								resultSet.getString("profissao"),
								new Morada(resultSet.getInt("idMorada"), 
										resultSet.getString("pais"),
										resultSet.getString("cidade"),
										resultSet.getString("regiao")),
										resultSet.getBoolean("eCuidador")));
			}


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem familiares");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return familiares;
	}


	public Familiar select_FamiliarId(int id) {
		Familiar familiar = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_FamiliarId);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				familiar = new Familiar(resultSet.getInt("idFamiliar"),
						resultSet.getString("nome_completo"), 
						resultSet.getDate("data_de_nascimento"),
						new Morada(resultSet.getInt("idMorada"), 
								resultSet.getString("pais"),
								resultSet.getString("cidade"),
								resultSet.getString("regiao")),
								TipoGenero.valueOf(resultSet.getString("genero")),
								resultSet.getString("profissao"),
								new Morada(resultSet.getInt("idMorada"), 
										resultSet.getString("pais"),
										resultSet.getString("cidade"),
										resultSet.getString("regiao")), 
										resultSet.getBoolean("e_cuidador"));	

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return familiar;
	}

	public int delete_Familiar(Familiar familiar){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Familiar);
			preparedStatement.setInt(1, familiar.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar a familiar " + familiar.getNome_completo());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}


	//TECNICO
	public int verificaId_Tecnico() throws SQLException{
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Tecnico);
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

	public int insert_Tecnico(Tecnico rm) {

		int row;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Tecnico);
			preparedStatement.setInt(1, rm.getId());
			preparedStatement.setString(2, rm.getNome_completo());
			preparedStatement.setString(3, rm.getNomeProprio());
			preparedStatement.setString(4, rm.getApelido());
			preparedStatement.setString(5, rm.getNome_utilizador());	
			preparedStatement.setString(6, rm.getPassword());
			preparedStatement.setString(7, rm.getEmail());
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do tecnico");
			return row;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir o tecnico " + rm.getNome_completo());
			row=0;
		}
		return row;

	}


	public Tecnico select_TecnicoEmail(String email) {
		Tecnico tecnico = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_TecnicoEmail);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tecnico = new Tecnico(resultSet.getInt("idTecnico"),
						resultSet.getString("nome_completo"),
						resultSet.getString("nome_utilizador"),
						resultSet.getString("password"),
						resultSet.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem  o tecnico com o email " + email );
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tecnico;
	}

	public Tecnico select_TecnicoId(int idTecnico) {
		Tecnico tecnico = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_TecnicoId);
			preparedStatement.setInt(1, idTecnico);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tecnico = new Tecnico(resultSet.getInt("idTecnico"),
						resultSet.getString("nome_completo"),
						resultSet.getString("nome_utilizador"),
						resultSet.getString("password"),
						resultSet.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("O tecnico com id " + idTecnico + " não existe na BD");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tecnico;
	}

	public ArrayList<Tecnico> selectAll_Tecnicos(){
		ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Tecnicos);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {	
				tecnicos.add(new Tecnico(resultSet.getInt("idTecnico"),
						resultSet.getString("nome_completo"), 
						resultSet.getString("nome_utilizador"), 
						resultSet.getString("password"), 
						resultSet.getString("email")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem tecnicos");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tecnicos;
	}

	public int delete_Tecnico(Tecnico tecnico){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Tecnico);
			preparedStatement.setInt(1, tecnico.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NÃ£o conseguiu apagar o tecnico " + tecnico.getNome_completo());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public int insert_Relacao_Paciente_Familiar(Relacao r){
		int row = 0;
		try {
	
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Relacao_Paciente_Familiar);
			preparedStatement.setInt(1, r.getId());
			preparedStatement.setInt(2, r.getFamiliar_nivel1().getId());
			preparedStatement.setInt(3, r.getPaciente().getId());
			preparedStatement.setInt(4, r.getPaciente().getTecnico().getId());
			preparedStatement.setString(5, r.getTipo_relacao().toString());
	
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts do paciente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir a relação ");
		}
		return row;
	}


	//RELACAO_PACIENTE_FAMILIAR
	public int verificaId_Relacao_Paciente_Familiar() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Relacao_Paciente_Familiar);
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
	public Relacao select_Relacao_Paciente_FamiliarId(int id) {
		Relacao relacao = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_Relacao_Paciente_FamiliarId);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			Paciente paciente = select_PacienteId(resultSet.getInt("Paciente_idPaciente"));
			Familiar familiar = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar"));

			while (resultSet.next()) {	
				relacao = new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						paciente, familiar, 
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A relacao com id " + id + " não existe na BD");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return relacao;
	}

	public ArrayList<Relacao> selectAll_Relacao_Paciente_Familiar(){
		ArrayList<Relacao> relacao_Paciente_Familiar = new ArrayList<Relacao>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Relacao_Paciente_Familiar);
			ResultSet resultSet = preparedStatement.executeQuery();
			Paciente paciente = select_PacienteId(resultSet.getInt("Paciente_idPaciente"));
			Familiar familiar = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar"));

			while (resultSet.next()) {	
				relacao_Paciente_Familiar.add(new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						paciente, familiar, 
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao"))));

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
		return relacao_Paciente_Familiar;
	}

	public ArrayList<Relacao> selectAll_Relacao_Paciente_Familiar_Do_Paciente(Paciente p){

		ArrayList<Relacao> relacao_Paciente_Familiar = new ArrayList<Relacao>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Relacao_Paciente_Familiar_Do_Paciente);
			preparedStatement.setInt(1, p.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			Familiar familiar = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar"));

			while (resultSet.next()) {	
				relacao_Paciente_Familiar.add(new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						p, familiar, 
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao"))));

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
		return relacao_Paciente_Familiar;
	}

	public int delete_Relacao_Paciente_Familiar(Familiar familiar){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Relacao_Paciente_Familiar);
			preparedStatement.setInt(1, familiar.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar a relação familiar ");
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}


	public int insert_Relacao_Familiar_Familiar(Relacao r){
		int row = 0;
		try {
	
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.insert_Relacao_Familiar_Familiar);
			preparedStatement.setInt(1, r.getId());
			preparedStatement.setInt(2, r.getFamiliar_nivel1().getId());
			preparedStatement.setInt(3, r.getFamiliar_nivel2().getId());
			preparedStatement.setString(5, r.getTipo_relacao().toString());
	
			row = preparedStatement.executeUpdate();
			System.out.println("Fiz os inserts da relação");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não conseguiu inserir a relação ");
		}
		return row;
	}


	//RELACAO_FAMILIAR_FAMILIAR
	public int verificaId_Relacao_Familiar_Familiar() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.ultimoId_Relacao_Familiar_Familiar);
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
	public Relacao select_Relacao_Familiar_FamiliarId(int id) {
		Relacao relacao = null;
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.select_Relacao_Familiar_FamiliarId);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			Paciente paciente = select_PacienteId(resultSet.getInt("Paciente_idPaciente"));
			Familiar familiar = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar"));
			Familiar familiar1 = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar1"));

			while (resultSet.next()) {	
				relacao = new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						paciente, familiar, familiar1,
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A relacao com id " + id + " não existe na BD");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return relacao;
	}
	
	public ArrayList<Relacao> selectAll_Relacao_Familiar_Familiar(Paciente p){
		ArrayList<Relacao> relacao_Familiar_Familiar = new ArrayList<Relacao>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Relacao_Familiar_Familiar);
			ResultSet resultSet = preparedStatement.executeQuery();
			Familiar familiar1 = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar"));
			Familiar familiar2 = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar1"));

			while (resultSet.next()) {	
				relacao_Familiar_Familiar.add(new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						p, familiar1, familiar2, 
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao"))));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("A base de dados não tem relaçoes");
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return relacao_Familiar_Familiar;
	}

	public ArrayList<Relacao> selectAll_Relacao_Familiar_Familiar_Do_Familiar(Paciente p, Familiar f){

		ArrayList<Relacao> relacao_Paciente_Familiar = new ArrayList<Relacao>();

		try {

			preparedStatement = (PreparedStatement) connection
					.prepareStatement(Queries.selectAll_Relacao_Familiar_Familiar_Do_Familiar);
			preparedStatement.setInt(1, f.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			Familiar familiar = select_FamiliarId(resultSet.getInt("Familiar_idFamiliar1"));

			while (resultSet.next()) {	
				relacao_Paciente_Familiar.add(new Relacao(resultSet.getInt("idRelacao_Paciente_Familiar"),
						p, f, familiar, 
						TipoRelacao.valueOf(resultSet.getString("tipo_relacao"))));

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
		return relacao_Paciente_Familiar;
	}

	public int delete_Relacao_Familiar_Familiar(Familiar familiar){
		int row = 0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(Queries.delete_Relacao_Paciente_Familiar);
			preparedStatement.setInt(1, familiar.getId());
			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não conseguiu apagar a relação familiar ");
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}



}
