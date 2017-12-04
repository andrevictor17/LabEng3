package Main;

import java.io.IOException;

import Controle.LoginAcesso;
import Modelo.MainSistema;
import View.ViewGrafico;

public class Main {

	public static void main(String[] args) throws IOException {
		ViewGrafico view = new ViewGrafico();
		MainSistema modelo = new MainSistema(view);
		LoginAcesso	loginControle = new LoginAcesso(view, modelo);
		
		view.setLogin(loginControle);
	}

}
