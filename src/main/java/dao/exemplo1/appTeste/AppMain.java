package dao.exemplo1.appTeste;

import java.util.List;

import dao.exemplo1.Usuario;
import dao.exemplo1.UsuarioDAO;

public class AppMain {

	public static void main(String[] args) {
		System.out.println("TESTES COM DAO - Banco de dados ");
		
		UsuarioDAO daoUser = new UsuarioDAO();
	
		// pesquisando o cliente 1
		Usuario u1 = daoUser.findById(1);

		System.out.println("Usuario id = " + u1.getId() + " " + u1.getNome()
		   + "      email = "+u1.getEmail());
		
		// inclui um novo usuario
		Usuario userNew = new Usuario("ANTONIO DE JESUS", "ajesus@abc.com", "1223");
	 	daoUser.insert(userNew);
		
		// altera o Usuario cujo ID= 3 ("PEDRO SILVA" para "KLEBER ...")
		Usuario userUp = daoUser.findById(3);
		userUp.setNome("KLEBER GUIMARÃES");
		daoUser.update(userUp);
 
		// Deleta o usuario cujo ID=5 (ALBERTO FARIA)
		Usuario userDel = daoUser.findById(5);
		if (userDel !=null) {
		    System.out.println("** Usuário Excluido  " + userDel.getNome());
		    daoUser.delete(userDel);
		}    
		
		// pesquisando todos os usuarios
		System.out.println("* pesquisando todos os usuarios...");
		List<Usuario> lista = daoUser.findAll();
		for (Usuario user: lista) {
			System.out.println("Usuario id = " + user.getId() + " " + user.getNome()
			   + " incluido em "+user.getDataInclusao());
		}
		
		daoUser.close();
	}

}
