package vista;
 
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
 
import java.awt.Dimension;
 
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
 
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorVentanas;
import modelo.Ciudad;
import modelo.FiltroPincho;
import modelo.Ingrediente;
import modelo.Pincho;

import javax.swing.JTextField;
 
public class PnlConsultaPincho extends JPanel {
    private JTable tablaConsultaPinchos;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JComboBox cmbIngredientes;
    private JButton btnConsConsultarPincho;
    
    private DefaultTableModel modeloTabla;
    private DefaultComboBoxModel<Ingrediente> modeloCmbBoxIngrediente;
     
    // constructor
    public PnlConsultaPincho() {
        inicializarComponentes();
    }
 
    public DefaultComboBoxModel<Ingrediente> getCbmBoxIngredientes(){
    	return modeloCmbBoxIngrediente;
    }
    
    // metodos
    private void inicializarComponentes() {
    	
    	// componentes
        JLabel lblConsultas = new JLabel("CONSULTA DE PINCHOS");
        lblConsultas.setBounds(255, 13, 248, 27);
        lblConsultas.setFont(new Font("Sylfaen", Font.BOLD, 20));
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(200, 61, 50, 16);
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(210, 96, 40, 16);
        JLabel lblIngredientes = new JLabel("Ingrediente:");
        lblIngredientes.setBounds(180, 138, 70, 16);
         
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(66, 257, 634, 230);
         
        txtNombre = new JTextField();
        txtNombre.setBounds(255, 58, 298, 22);
        txtNombre.setColumns(10);
         
        txtPrecio = new JTextField();
        txtPrecio.setBounds(255, 93, 298, 22);
        txtPrecio.setColumns(10);
        
        // configuracion combobox ingredientes
        cmbIngredientes = new JComboBox();
        modeloCmbBoxIngrediente = new DefaultComboBoxModel<Ingrediente>();
        cmbIngredientes.setModel(modeloCmbBoxIngrediente);
        cmbIngredientes.setBounds(255, 135, 298, 22);
         
        btnConsConsultarPincho = new JButton("CONSULTAR");
        btnConsConsultarPincho.setBounds(341, 193, 112, 34);
        
        // configuracion de la tabla
        tablaConsultaPinchos = new JTable();
        modeloTabla = new DefaultTableModel(){
			private static final long serialVersionUID = -4153929540378817720L;
			boolean[] columsEditable = {false, false, false, false};
        	
        	public boolean isCellEditable(int row, int col){
        		return columsEditable[col];
        	}
        };
        
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Lugar de Procedencia");
        modeloTabla.addColumn("Popularidad");
        tablaConsultaPinchos.setModel(modeloTabla);
        scrollPane.setViewportView(tablaConsultaPinchos);
        
        // tamaño de panel
        setPreferredSize(new Dimension(760, 500));
        setLayout(null);
        add(lblConsultas);
        add(lblIngredientes);
        add(lblPrecio);
        add(lblNombre);
        add(cmbIngredientes);
        add(txtPrecio);
        add(txtNombre);
        add(scrollPane);
        add(btnConsConsultarPincho);
    }
 
     
    public void setControlador(ControladorVentanas c) {
        btnConsConsultarPincho.addActionListener(c);
         
    }

	public JButton getBtnConsConsultarPincho() {
		return btnConsConsultarPincho;
	}
    
    public FiltroPincho getDatosPincho(){
    	// variables
    	FiltroPincho filtro = new FiltroPincho();
    	String nombrePincho = txtNombre.getText();
    	String precioPinchoStr = txtPrecio.getText();
    	double precioPincho = 0;
    	String ingrediente = cmbIngredientes.getSelectedItem().toString();
    	
    	// asigna valores a filtro dependiento si el usuario ha introducido datos o no
    	if (!nombrePincho.equals(null)){
    		filtro.setNombre(nombrePincho);
    	}
    	if(!precioPinchoStr.equals(null)){
    		try{
    			precioPincho = Double.parseDouble(precioPinchoStr);
    			filtro.setPrecio(precioPincho);
    		}
    		catch(NumberFormatException nfe){
    			mostrarErrorNumerico();
    		}
    	}
    	if(!ingrediente.equals("-")){
    		filtro.setIngrediente(cmbIngredientes.getSelectedItem().toString());
    	}
    	
    	
    	return filtro;
    }
    
    public void mostrarErrorNumerico(){
    	JOptionPane.showMessageDialog(this, "Precio debe ser un numero", "Error en el precio", JOptionPane.ERROR_MESSAGE);
    }
 
}
