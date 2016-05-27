package vista;

import javax.swing.JPanel;

import controlador.ControladorVentanas;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;




import modelo.FiltroIngrediente;
import modelo.Ingrediente;



public class PnlAñadirIngrediente extends JPanel {

	private JTextField textIngrediente;
	private JButton btnAñadir;
	private JComboBox comboBoxCoste;
	private DefaultComboBoxModel<FiltroIngrediente> modelMgr;

	
	
	
	
	public JComboBox getComboBoxCoste() {
		return comboBoxCoste;
	}


	public JButton getBtnAñadir() {
		return btnAñadir;
	}


	public PnlAñadirIngrediente() {
		setSize(new Dimension(760, 500));
		setLayout(null);
		
		JLabel lblAadirIngredientes = new JLabel("A\u00F1adir Ingredientes:");
		lblAadirIngredientes.setBounds(244, 73, 108, 14);
		add(lblAadirIngredientes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(188, 143, 68, 14);
		add(lblNombre);
		
		JLabel lblCoste = new JLabel("Coste:");
		lblCoste.setBounds(188, 210, 68, 14);
		add(lblCoste);
		
		textIngrediente = new JTextField();
		textIngrediente.setBounds(266, 140, 86, 20);
		add(textIngrediente);
		textIngrediente.setColumns(10);
		
		comboBoxCoste = new JComboBox();
		modelMgr = new DefaultComboBoxModel<FiltroIngrediente>();
		comboBoxCoste.setModel(modelMgr);
		comboBoxCoste.setModel(new DefaultComboBoxModel(new String[] {"-", "0.50", "0.75", "1.00", "1.25", "1.50"}));
		comboBoxCoste.setBounds(268, 207, 84, 20);
		add(comboBoxCoste);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(285, 318, 89, 23);
		add(btnAñadir);
	}


	public void setControlador(ControladorVentanas c) {
		btnAñadir.addActionListener(c);
		
	}

	public Ingrediente getDatosIngre(){
		Ingrediente ingre = new Ingrediente();
		ingre.setNombre(textIngrediente.getText());
		//AQUI HAY ERROR
		ingre.setCoste(Double.parseDouble(comboBoxCoste.getSelectedItem().toString()));
		
		return ingre;
		
	}
	

}
