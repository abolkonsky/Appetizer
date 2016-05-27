package vista;

import javax.swing.JPanel;
import controlador.ControladorVentanas;

public interface IVentana {
	public void inicializar();
	public void hacerVisible();
	public void setControlador(ControladorVentanas c);
	public void definirPanel(JPanel panel);
}

