package Controle;

import java.io.IOException;
import java.util.ArrayList;

import Modelo.Chamado;
import Modelo.MainSistema;
import View.ViewGrafico;


public class ChamadoControle implements ControleAcesso {

	private ViewGrafico view;
	private MainSistema modelo;

	/**
	 * Default contrutor
	 * @param m 
	 * @param v 
	 */
	public ChamadoControle(ViewGrafico v, MainSistema m) {
		this.view = v;
		this.modelo = m;
	}

	/**
	 * @param p
	 */
	public void addChamado(Chamado p ) {
		if(view.getControle() instanceof ControleCliente ){
			view.showMessageError("Você não possui permissão!");
			return;
		}
		try {
			modelo.addChamado(p);
		} catch (IOException e) {
			view.showMessage("Erro BD");
			e.printStackTrace();
		}
	}

	/**
	 * @param old  
	 * @param new
	 */
	public void updateChamado(Chamado old , Chamado p ) {
		if(view.getControle() instanceof ControleCliente ){
			view.showMessageError("Você não possui permissão!");
			return;
		}
		modelo.updateChamado(old, p);
	}

	/**
	 * @param p
	 */
	public void removeChamado(Chamado p ) {
		if(view.getControle() instanceof ControleCliente ){
			view.showMessageError("Você não possui permissão!");
			return;
		}
		modelo.removeChamado(p);
	}

	/**
	 * @param p
	 */
	public void PesquisarChamados(Chamado p ) {
		ArrayList<Chamado> result = modelo.PesquisarChamado(p);
		view.resultadosAchados(result);
	}

}
