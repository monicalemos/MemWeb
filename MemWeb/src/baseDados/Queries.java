package baseDados;

public class Queries {

	//FOTOS
	public static final String insert_Imagem = "insert into `memDb`.`Imagem` values(?,?,?);";
	
	public static final String ultimoId_Imagem = "select `idImagem` from `memDb`.`Imagem` order by `idImagem` desc limit 1;";
	
	// PACIENTE
	public static final String insert_Paciente = "insert into `memDb`.`Paciente` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	//public static final String insert_Paciente_2Morada = "insert into `memDb`.`Paciente` (`Morada_idMorada`) values (?) where `Paciente`.`idPaciente`= ?;";
	
	public static final String ultimoId_Paciente = "select `idPaciente` from `memDb`.`Paciente` order by `idPaciente` desc limit 1;";

	public static final String selectAll_PacientesComMorada = "select * from `memDb`.`Paciente`, `memDb`.`Morada` where `Paciente`.`LocalNascimento_idMorada` = `Morada`.`idMorada` and `Paciente`.`Tecnico_idTecnico` = ?;";

	public static final String select_PacienteId = "select * from `memDb`.`Paciente` where `Paciente`.`idPaciente`=? and `Paciente`.`Tecnico_idTecnico`= ?;";

	public static final String select_PacienteNomeUtilizador = "select * from `memDb`.`Paciente` where `Paciente`.`nome_utilizador`=?;";
	
	public static final String delete_PacienteNome = "delete from `memDb`.`Paciente` where `idPaciente` = ?;";

	public static final String delete_Paciente = "delete from `memDb`.`Paciente` where nomeCompleto = ?;";

	public static final String selectAll_Pacientes = "select * from `memDb`.`Paciente`;";

	public static final String select_PacienteNome = "select * from `memDb`.`Paciente` WHERE nomeCompleto = ?;";

	
	//MORADA
	
	public static final String insert_Morada = "insert into `memDb`.`Morada` values(?,?,?,?);";
	
	public static final String ultimoId_Morada = "select `idMorada` from `memDb`.`Morada` order by `idMorada` desc limit 1;";

	public static final String select_MoradaId = "select * from `memDb`.`Morada` where `Morada`.`idMorada`=?;";
	
	public static final String selectAll_Moradas = "select * from `memDb`.`Morada`;";

	public static final String delete_Morada = "delete from `memDb`.`Morada` where `idMorada` = ?;";
	
	public static final String selectAll_IdsMorada = "select `Morada_idMorada` from `memDb`.`Paciente`;";


	//Familiar:
	
	public static final String insert_Familiar = "insert into `memDb`.`Familiar` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public static final String ultimoId_Familiar = "select `idPaciente` from `memDb`.`Paciente` order by `idPaciente` desc limit 1;";

	public static final String selectAll_Familiares = "select * from `memDb`.`Familiar`, `memDb`.`relacao_paciente_familiar` where `relacao_paciente_familiar`.`Familiar_idFamiliar` = `Familiar`.`idFamiliar`and `relacao_paciente_familiar`.`Paciente_idPaciente` = ?;";

	public static final String select_FamiliarId = "select * from `memDb`.`Familiar` where `Familiar`.`idFamiliar`=?;";

	public static final String select_FamiliarNomeUtilizador = "select * from `memDb`.`Familiar` where `Familiar`.`nome_utilizador`=?;";
	
	public static final String delete_Familiar = "delete from `memDb`.`Familiar` where `idFamiliar` = ?;";

	//TECNICO
	
	public static final String insert_Tecnico = "insert into `memDb`.`Tecnico` values(?,?,?,?,?,?,?);";

	public static final String ultimoId_Tecnico = "select `idTecnico` from `memDb`.`Tecnico` order by `idTecnico` desc limit 1;";

	public static final String select_TecnicoEmail = "select * from `memDb`.`Tecnico` where `Tecnico`.`email`=?;";
	
	public static final String select_TecnicoNome_Utilizador = "select * from `memDb`.`Tecnico` where `Tecnico`.`nome_utilizador`=?;";

	public static final String select_TecnicoId = "select * from `memDb`.`Tecnico` where `Tecnico`.`idTecnico`=?;";

	public static final String selectAll_Tecnicos ="select * from `memDb`.`Tecnico`;";

	public static final String delete_Tecnico = "delete from `memDb`.`Tecnico` where `idTecnico` = ?;";

	//RELACAO_PACIENTE_FAMILIAR
	public static final String insert_Relacao_Paciente_Familiar = "insert into `memDb`.`Relacao_Paciente_Familiar` values(?,?,?,?,?);";

	public static final String ultimoId_Relacao_Paciente_Familiar = "select `idRelacao_Paciente_Familiar` from `memDb`.`Relacao_Paciente_Familiar` order by `idRelacao_Paciente_Familiar` desc limit 1;";

	public static final String select_Relacao_Paciente_FamiliarId ="select * from `memDb`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`idRelacao_Paciente_Familiar` = ? ;";
	
	public static final String selectAll_Relacao_Paciente_Familiar ="select * from `memDb`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`Paciente_Tecnico_idTecnico` = ? ;";

	public static final String selectAll_Relacao_Paciente_Familiar_Do_Paciente ="select * from `memDb`.`Relacao_Paciente_Familiar` where `Relacao_Paciente_Familiar`.`Paciente_idPaciente`=?;";

	public static final String delete_Relacao_Paciente_Familiar = "delete from `memDb`.`Relacao_Paciente_Familiar` where `idFamiliar` = ?;";

	
	//RELACAO_FAMILIAR_FAMILIAR
	public static final String insert_Relacao_Familiar_Familiar = "insert into `memDb`.`Relacao_Familiar_Familiar` values(?,?,?,?,?);";

	public static final String ultimoId_Relacao_Familiar_Familiar = "select `idRelacao_Familiar_Familiar` from `memDb`.`Relacao_Familiar_Familiar` order by `idRelacao_Familiar_Familiar` desc limit 1;";

	public static final String select_Relacao_Familiar_FamiliarId ="select * from `memDb`.`Relacao_Familiar_Familiar` where `Relacao_Familiar_Familiar`.`idRelacaoFamiliar_Familiar` = ? ;";
	
	public static final String selectAll_Relacao_Familiar_Familiar ="select * from `memDb`.`Relacao_Familiar_Familiar`;";

	public static final String selectAll_Relacao_Familiar_Familiar_Do_Familiar ="select * from `memDb`.`Relacao_Paciente_Familiar` where `Relacao_Familiar_Familiar`.`Familiar_idFamiliar`=?;";

	public static final String delete_Relacao_Familiar_Familiar = "delete from `memDb`.`Relacao_Familiar_Familiar` where `Familiar_idFamiliar` = ? or `Familiar_idFamiliar1 = ?;";
}