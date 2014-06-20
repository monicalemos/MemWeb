package baseDados;

public class Queries {

	// PACIENTE
	public static final String selectAllPacientes = "select * from `memDataBase`.`Paciente`;";
	
	public static final String selectAllPacientesComMorada = "select * from memDataBase.Paciente, memDataBase.Morada where Paciente.idMorada = Morada.idMorada;";
	
	public static final String selectPaciente = "select * from `memDataBase`.`Paciente` WHERE nomeCompleto = ?;";

	public static final String insertPaciente = "insert into `memDataBase`.`Paciente` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public static final String deletePacienteNome = "delete from `memDataBase`.`Paciente` where `idPaciente` = ?;";
	
	public static final String deletePaciente = "delete from `memDataBase`.`Paciente` where nomeCompleto = ?;";

	public static final String ultimoIdPaciente = "select `idPaciente` from `memDataBase`.`Paciente` order by `idPaciente` desc limit 1;";

	public static final String selectAllIdsMorada = "select `Morada_idMorada` from `memDataBase`.`Paciente`;";
	
	//PESSOA:
	public static final String ultimoIdPessoa = "select `idPaciente` from `memDataBase`.`Paciente` order by `idPaciente` desc limit 1;";
	
	public static final String insertPessoa = "insert into `memDataBase`.`Pessoa` values(?,?,?,?,?,?,?,?,?,?,?);";;

	public static final String deletePessoa = "delete from `memDataBase`.`Pessoa` where `idPessoa` = ?;";
	
	public static final String selectAllPessoas = "select * from `memDataBase`.`Pessoa`;";
	//MORADA	
	public static final String ultimoIdMorada = "select `idMorada` from `memDataBase`.`Morada` order by `idMorada` desc limit 1;";
	
	public static final String insertMorada = "insert into `memDataBase`.`Morada` values(?,?,?,?,?,?,?,?);";

	public static final String selectAllMoradas = "select * from `memDataBase`.`Morada`;";

	public static final String deleteMorada = "delete from `memDataBase`.`Morada` where `idMorada` = ?;";
	
	//RESPONSAVEL MEDICO
	public static final String ultimoIdUtilizador = "select `idUtilizador` from `memDataBase`.`Utilizador` order by `idUtilizador` desc limit 1;";

	public static final String insertUtilizador = "insert into `memDataBase`.`Utilizador` values(?,?,?,?,?,?,?,?,?,?,?);";

	public static final String selectUtilizadorEmail = "select * from `memDataBase`.`Utilizador`, `memDataBase`.`Morada` where `Utilizador`.`idMorada` = `Morada`.`idMorada` and `Utilizador`.`email`=?;";

	public static final String selectUtilizadorId = "select * from `memDataBase`.`Utilizador`, `memDataBase`.`Morada` where `Utilizador`.`idMorada` = `Morada`.`idMorada` and `Utilizador`.`idUtilizador`=?;";
	
	public static final String selectAllUtilizadores ="select * from `memDataBase`.`Utilizador`;";
	
	public static final String selectAllUtilizadorComMoradas ="select * from `memDataBase`.`Utilizador`, `memDataBase`.`Morada` where `Utilizador`.`idMorada` = `Morada.idMorada`;";

	public static final String deleteUtilizador = "delete from `memDataBase`.`Utilizador` where `idUtilizador` = ?;";
}