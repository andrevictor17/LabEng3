package Controle;

import Modelo.Chamado;
import Modelo.MainSistema;
import View.ViewGrafico;

public class ControleCliente implements ControleAcesso{
	
	private MainSistema Modelo;
	private ViewGrafico view;
	
	/**
	 * Default contrutor
	 */
	public ControleCliente(ViewGrafico g, MainSistema m) {
		this.Modelo = m;
		this.view = g;
	}

	/**
	 * @param p
	 */
	public void PesquisarChamados(Chamado p ) {
		view.resultadosAchados(Modelo.PesquisarChamado(p));
	}

}
