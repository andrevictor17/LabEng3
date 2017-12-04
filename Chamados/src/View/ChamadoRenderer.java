package View;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Modelo.Chamado;

public class ChamadoRenderer  extends JLabel implements ListCellRenderer<Chamado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5486027206124736167L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Chamado> list, Chamado value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getNome()); 
		if(isSelected){
			setOpaque(true);
			setBackground(Color.BLACK);
			setForeground(Color.WHITE);
		}
		else{
			setOpaque(false);
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}
		return this;
	}

}
