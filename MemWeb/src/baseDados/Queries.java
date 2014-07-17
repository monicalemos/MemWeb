package baseDados;

public class Queries {

	// PACIENTE
	public static final String insert_Paciente = "insert into `memDB`.`Paciente` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public static final String ultimoId_Paciente = "select `idPaciente` from `memDB`.`Paciente` order by `idPaciente` desc limit 1;";

	public static final String selectAll_PacientesComMorada = "select * from memDB.Paciente, memDB.Morada where Paciente.idMorada = Morada.idMorada;";

	public static final String select_PacienteId = "select * from `memDB`.`Paciente`, `memDB`.`Morada` where `Paciente`.`idMorada` = `Morada`.`idMorada` and `Paciente`.`idPaciente`=?;";

	public static final String delete_PacienteNome = "delete from `memDB`.`Paciente` where `idPaciente` = ?;";

	public static final String delete_Paciente = "delete from `memDB`.`Paciente` where nomeCompleto = ?;";

	public static final String selectAll_Pacientes = "select * from `memDB`.`Paciente`;";

	public static final String select_PacienteNome = "select * from `memDB`.`Paciente` WHERE nomeCompleto = ?;";

	
	//MORADA
	
	public static final String insert_Morada = "insert into `memDB`.`Morada` values(?,?,?,?,?,?,?,?);";
	
	public static final String ultimoId_Morada = "select `idMorada` from `memDB`.`Morada` order by `idMorada` desc limit 1;";

	public static final String selectAll_Moradas = "select * from `memDB`.`Morada`;";

	public static final String delete_Morada = "delete from `memDB`.`Morada` where `idMorada` = ?;";
	
	public static final String selectAll_IdsMorada = "select `Morada_idMorada` from `memDB`.`Paciente`;";


	//Familiar:
	
	public static final String insert_Familiar = "insert into `memDB`.`Familiar` values(?,?,?,?,?,?,?,?,?,?,?);";

	public static final String ultimoId_Familiar = "select `idPaciente` from `memDB`.`Paciente` order by `idPaciente` desc limit 1;";

	public static final String selectAll_Familiares = "select * from `memDB`.`Familiar`, `memDB`.`relacao_paciente_familiar` where `relacao_paciente_familiar`.`Familiar_idFamiliar` = `Familiar`.`idFamiliar`and `relacao_paciente_familiar`.`Paciente_idPaciente` = ?;";

	public static final String select_FamiliarId = "select * from `memDB`.`Familiar`, `memDB`.`Morada` where `Familiar`.`Local_Nascimento_idMorada` = `Morada`.`idMorada` and `Familiar`.`idFamiliar`=?;";

	public static final String delete_Familiar = "delete from `memDB`.`Familiar` where `idFamiliar` = ?;";

	//TECNICO
	
	public static final String insert_Tecnico = "insert into `memDB`.`Tecnico` values(?,?,?,?,?,?,?);";

	public static final String ultimoId_Tecnico = "select `idTecnico` from `memDB`.`Tecnico` order by `idTecnico` desc limit 1;";

	public static final String select_TecnicoEmail = "select * from `memDB`.`Tecnico`, `memDB`.`Morada` where `Tecnico`.`idMorada` = `Morada`.`idMorada` and `Tecnico`.`email`=?;";

	public static final String select_TecnicoId = "select * from `memDB`.`Tecnico`, `memDB`.`Morada` where `Tecnico`.`idMorada` = `Morada`.`idMorada` and `Tecnico`.`idTecnico`=?;";

	public static final String selectAll_Tecnicos ="select * from `memDB`.`Tecnico`;";

	public static final String delete_Tecnico = "delete from `memDB`.`Tecnico` where `idTecnico` = ?;";

	//RELACAO_PACIENTE_FAMILIAR
	public static final String insert_Relacao_Paciente_Familiar = "insert into `memDB`.`Relacao_Paciente_Familiar` values(?,?,?,?,?);";

	public static final String ultimoId_Relacao_Paciente_Familiar = "select `idRelacao_Paciente_Familiar` from `memDB`.`Relacao_Paciente_Familiar` order by `idRelacao_Paciente_Familiar` desc limit 1;";

	public static final String select_Relacao_Paciente_FamiliarId ="select * from `memDB`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`idRelacao_Paciente_Familiar` = ? ;";
	
	public static final String selectAll_Relacao_Paciente_Familiar ="select * from `memDB`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`Paciente_Tecnico_idTecnico` = ? ;";

	public static final String selectAll_Relacao_Paciente_Familiar_Do_Paciente ="select * from `memDB`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`Paciente_idPaciente`=?;";

	public static final String delete_Relacao_Paciente_Familiar = "delete from `memDB`.`Relacao_Paciente_Familiar` where `idFamiliar` = ?;";

	
	//RELACAO_FAMILIAR_FAMILIAR
	public static final String insert_Relacao_Familiar_Familiar = "insert into `memDB`.`Relacao_Familiar_Familiar` values(?,?,?);";

	public static final String ultimoId_Relacao_Familiar_Familiar = "select `idRelacao_Familiar_Familiar` from `memDB`.`Relacao_Familiar_Familiar` order by `idRelacao_Familiar_Familiar` desc limit 1;";

	public static final String select_Relacao_Familiar_FamiliarId ="select * from `memDB`.`Relacao_Familiar_Familiar` where `Relacao_Familiar_Familiar`.`idRelacaoFamiliar_Familiar` = ? ;";
	
	public static final String selectAll_Relacao_Familiar_Familiar ="select * from `memDB`.`Relacao_Familiar_Familiar`;";

	public static final String selectAll_Relacao_Familiar_Familiar_Do_Familiar ="select * from `memDB`.`Relacao_Paciente_Familiar` where `Relacao_Familiar_Familiar`.`Familiar_idFamiliar`=?;";

	public static final String delete_Relacao_Familiar_Familiar = "delete from `memDB`.`Relacao_Familiar_Familiar` where `Familiar_idFamiliar` = ? or `Familiar_idFamiliar1 = ?;";
}