package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.CiudadPersistencia;
import db.IngredientePersistencia;
import db.PinchoPersistencia;
import db.UsuarioLoginPersistencia;
import modelo.Ciudad;
import modelo.FiltroPincho;
import modelo.Ingrediente;
import modelo.Pincho;
import vista.PnlAñadirPincho;
import vista.PnlConsultaPincho;
import vista.VLogin_Main;
import vista.VPrincipalAppetizer;

public class ControladorVentanas implements ActionListener, KeyListener {
	private VLogin_Main vistaInicial;
	private VPrincipalAppetizer vistaPrincipal;
	private PnlConsultaPincho panelConsultarPincho;
	private PnlAñadirPincho panelAddPincho;
	
	// para controlar las veces que el usuario se intenta logear
	int intentosLogin;
	
	public ControladorVentanas(VLogin_Main vistaInicial, VPrincipalAppetizer ventanaPrin){
		this.vistaInicial = vistaInicial;
		this.vistaPrincipal = ventanaPrin;
		intentosLogin = 0;
	}
	
	public void setPanelConsultarPincho(PnlConsultaPincho panelConsultarPincho) {
		this.panelConsultarPincho = panelConsultarPincho;
	}
	
	public void setPanelAddPincho(PnlAñadirPincho panel){
		this.panelAddPincho = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj instanceof JButton){
			// boton login
			if(obj.equals(vistaInicial.getBotonLogin())){
				comprobarUsuario();
			}
			// TODO: boton consultar pincho
			else if(obj.equals(panelConsultarPincho.getBtnConsConsultarPincho())){
				FiltroPincho filtroPincho = panelConsultarPincho.getDatosPincho();
				String[] registroPincho = new String[3];
			}
			else if(obj.equals(panelAddPincho.getBtnAddPincho())){
				// GUARDA UN PINCHO NUEVO
				Pincho pincho = panelAddPincho.getDatosPincho();
				PinchoPersistencia pinchoPers = new PinchoPersistencia();
				int resp = 0;
				
				resp = pinchoPers.introducePinchoNuevo(pincho);
				if(resp == 1)
					panelAddPincho.mostrarMsgPinchoOk();
				else
					panelAddPincho.mostrarMsgPinchoError();
			}
			
		}
		else if(obj instanceof JMenuItem){
			if(obj.equals(vistaPrincipal.getMntmConsultarPincho())){
				cargaListaIngredientes(); // para el combo box de ingredientes
				vistaPrincipal.definirPanel(panelConsultarPincho);
			}
			else if(obj.equals(vistaPrincipal.getMntmAñadirPincho())){
				// carga lista de ingredientes
				cargaListaIngredientes_ModeloListaIng();
				// carga lista de ciudades
				cargaCiudadesCmbBox();
				// define el panel en la ventana principal
				vistaPrincipal.definirPanel(panelAddPincho);
			}
		}

	}

	// comprueba si el usuario y la contraseña es correcta
	private void comprobarUsuario() {
		boolean usuarioOk = false;
		UsuarioLoginPersistencia usuarioLoginPers = new UsuarioLoginPersistencia();
		String[] datosLogin = vistaInicial.getDatosLogin();
		
		usuarioOk = usuarioLoginPers.ConectaA_DB(datosLogin[0], datosLogin[1]);
		if(usuarioOk && intentosLogin < 3){
			vistaInicial.dispose();
			vistaPrincipal.hacerVisible();
		}
		else{
			vistaInicial.mostratrMsgError();
			intentosLogin++;
		}
		
		if(intentosLogin >= 3){
			vistaInicial.mostrarMsgCierre();
			vistaInicial.dispose();
		}
	}
	
	private void cargaListaIngredientes(){
		List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		IngredientePersistencia ingredPers = new IngredientePersistencia();
		
		// consigue todos los ingredientes guardados en la base de datos
		listaIngredientes = ingredPers.getIngredientesTodos();
		// itera sobre todos los ingredientes y añade cada uno al combobox model
		for(Ingrediente ingrediente : listaIngredientes){
			panelConsultarPincho.getCbmBoxIngredientes().addElement(ingrediente);
		}
	}
	
	private void cargaListaIngredientes_ModeloListaIng(){
		List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		IngredientePersistencia ingredPers = new IngredientePersistencia();
		
		// consigue todos los ingredientes guardados en la base de datos
		listaIngredientes = ingredPers.getIngredientesTodos();
		// itera sobre todos los ingredientes y añade cada uno a la lista de ingredientes
		for(Ingrediente ingrediente : listaIngredientes){
			panelAddPincho.getModeloListaIng().addElement(ingrediente);
		}
	}
	
	private void cargaCiudadesCmbBox(){
		ArrayList<Ciudad> listaCiudades = null;
		DefaultComboBoxModel<Ciudad> modeloCmbBox = panelAddPincho.getModeloCiudad();
		CiudadPersistencia ciudadPers = new CiudadPersistencia();
		listaCiudades = ciudadPers.getCiudades();
		
		for(Ciudad ciudad : listaCiudades){
			modeloCmbBox.addElement(ciudad);
		}
		
	}

	// implementacion de keyListener
	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_ENTER){
			comprobarUsuario();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

}
