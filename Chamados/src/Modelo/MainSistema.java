package Modelo;

import java.io.IOException;
import java.util.ArrayList;

import Controle.ChamadoControle;
import Controle.ControleCliente;
import View.ViewGrafico;
import Controle.ControleAcesso;

/**
 * 
 */
public class MainSistema implements Observable{
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * Default contrutor
	 */
	private ViewGrafico observar ;

	public MainSistema(ViewGrafico view) {
		observar  = view;
	}

	/**
	 * @param String name 
	 * @param String senha
	 */
	public ControleAcesso authenticate(String name,  String senha) {
		UserDAO dao = new UserDAO();
		ArrayList<User> found = dao.searchUser(new User(name, senha, UserClass.CLIENT));//senha and Tipo does not matter in this line
		for (User u : found) {
			if(u.getNome().equals(name)){
				if(u.getSenha().equals(senha)){
					if(u.getTipo().equals(UserClass.CLIENT)){
						NotificarAutorizacao();
						return new ControleCliente(observar , this);
					}
					if(u.getTipo().equals(UserClass.CHAMADO)){
						NotificarAutorizacao();
						return new ChamadoControle(observar , this);
					}

				}
			}
		}
		return null;
	}

	/**
	 * @param i
	 * @throws IOException 
	 */
	public void addChamado(Chamado i ) throws IOException {
		ChamadoDAO dao = new ChamadoDAO();
		dao.addChamado(i);
		observers.add((Observer) observar);
		NotificarDAO("Chamado adicionado com sucesso!");
	}

	/**
	 * @param pnew
	 */
	public void updateChamado(Chamado pold ,Chamado pnew ) {
		ChamadoDAO dao = new ChamadoDAO();
		dao.updateChamado(pold, pnew);
		NotificarDAO("Chamado editado com sucesso!");
	}

	/**
	 * @param i
	 */
	public void removeChamado(Chamado i ) {
		ChamadoDAO dao = new ChamadoDAO();
		dao.removeChamado(i);
		observers.remove(observar);
		NotificarDAO("Chamado removido com sucesso!");
	}



	/**
	 * @param p
	 */
	public ArrayList<Chamado> PesquisarChamado(Chamado p) {
		ArrayList<Chamado> array;
		ChamadoDAO dao = new ChamadoDAO();
		array = dao.PesquisaChamado(p);
		observar .showMessage("A busca encontrou resultados!");
		return array;
	}

	/**
	 * @param u
	 * @throws IOException 
	 * @throws UsuarioJaExiste 
	 */
	public boolean registrarUsuario(User u) throws UsuarioJaExiste, IOException {
		UserDAO dao = new UserDAO();
		dao.addUser(u);
		return true;
	}

	/**
	 * @param acesso
	 */
	public void NotificarAutorizacao() {
		observar .showMessage("Logado com sucesso!");
	}

	/**
	 * @param message
	 */
	public void NotificarDAO(String message) {
		observar .showMessage(message);
	}

	/**
	 * @param p
	 */
	
	public ViewGrafico getobservar () {
		return observar ;
	}

	public void setObservar (ViewGrafico observar ) {
		this.observar  = observar ;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		
	}

}