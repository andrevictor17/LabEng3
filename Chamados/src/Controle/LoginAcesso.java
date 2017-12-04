package Controle;

import java.io.IOException;

import Modelo.MainSistema;
import Modelo.User;
import Modelo.UsuarioJaExiste;
import View.ViewGrafico;


/**
 * 
 */
public class LoginAcesso {

	private MainSistema modelo;
	private ViewGrafico view;

	/**
	 * Default contrutor
	 */
	public LoginAcesso(ViewGrafico g, MainSistema m) {
		this.modelo = m;
		this.view = g;
	}



	/**
	 * @param nome  
	 * @param senha
	 */
	public void acesso(String nome , char[] senha ) {
		ControleAcesso autenticacao = modelo.authenticate(nome, String.valueOf(senha));
		if(autenticacao == null)view.showMessageError("Usu�rio ou senha inv�lidas.");
		else{
			view.Permitido(autenticacao);
		}
	}
	
	public void registrarNovoUsuario(String nome , char[] senha ) {
		try {
			if(modelo.registrarUsuario(new User(nome,String.valueOf(senha )))){
				view.showMessage("O usu�rio "+ nome + " foi registrado com sucesso!");
			}
		} catch (IOException e) {
			view.showMessage("Erro BD");
			e.printStackTrace();
		}
		catch(UsuarioJaExiste e){
			view.showMessageError("Usu�rio j� cadastrado!");
		}
	}
}