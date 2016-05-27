package vista;
 
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorVentanas;
import modelo.Ciudad;
import modelo.Ingrediente;
import modelo.Pincho;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
 
public class PnlAñadirPincho extends JPanel {
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JComboBox cmbProcedencia;
    private DefaultComboBoxModel<Ciudad> cmbBoxModelCiudad;
    private JButton btnAddPincho;
    private JList listaIngredientesDisponibles;
    private JList listaIngredientesSeleccionados;
    private DefaultListModel<Ingrediente> modeloListaIngredientes;
    private DefaultListModel<Ingrediente> modeloListaIngSeleccionados;
    private JButton btnIncluirIngrediente;
    private JButton btnQuitarIngrediente;
    
    // constructor
    public PnlAñadirPincho() {     
        inicializarComponentes();
    }
    
    // devuelve los botones del panel
    public JButton getBtnAddPincho() {
        return btnAddPincho;
    }
    
    public JButton getBtnIncluirIng(){
    	return btnIncluirIngrediente;
    }
    
    public JButton getBtnQuitarIng(){
    	return btnQuitarIngrediente;
    }
    
    // devuelve el modelo del comboBox
    public DefaultComboBoxModel<Ciudad> getModeloCiudad(){
    	return cmbBoxModelCiudad;
    }
    
    // devuelve el modelo de la lista de ingredientes
    public DefaultListModel<Ingrediente> getModeloListaIng(){
    	return modeloListaIngredientes;
    }
    
    // devuelve el modelo de la lista de ingredientes seleccionados
    public DefaultListModel<Ingrediente> getModeloListaIngSeleccionados(){
    	return modeloListaIngSeleccionados;
    }
    
    public JList getListaIng(){
    	return listaIngredientesDisponibles;
    }
 
    public void inicializarComponentes() {
        setPreferredSize(new Dimension(760, 500));
        JLabel lblConsultas = new JLabel("A\u00D1ADIR PINCHO");
        lblConsultas.setBounds(282, 38, 186, 27);
        lblConsultas.setFont(new Font("Sylfaen", Font.BOLD, 20));
         
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(202, 93, 50, 14);
         
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(210, 142, 42, 14);
         
        JLabel lblLugarDeProcedencia = new JLabel("Lugar de procedencia:");
        lblLugarDeProcedencia.setBounds(136, 193, 128, 14);
         
        JLabel lblIngredientes = new JLabel("Todos los Ingredientes:");
        lblIngredientes.setBounds(46, 234, 141, 14);
         
        txtNombre = new JTextField();
        txtNombre.setBounds(276, 90, 298, 20);
        txtNombre.setColumns(10);
         
        txtPrecio = new JTextField();
        txtPrecio.setBounds(276, 139, 298, 20);
        txtPrecio.setColumns(10);
         
        cmbProcedencia = new JComboBox();
        cmbBoxModelCiudad = new DefaultComboBoxModel<Ciudad>();
        cmbProcedencia.setModel(cmbBoxModelCiudad);
        cmbProcedencia.setBounds(276, 190, 298, 20);
         
        btnAddPincho = new JButton("A\u00F1adir Pincho");
        btnAddPincho.setBounds(307, 400, 161, 52);
        setLayout(null);
        add(lblConsultas);
        add(lblIngredientes);
        add(lblLugarDeProcedencia);
        add(lblPrecio);
        add(lblNombre);
        add(cmbProcedencia);
        add(txtPrecio);
        add(txtNombre);
        add(btnAddPincho);
         
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(46, 261, 231, 108);
        add(scrollPane);
         
        // configura el modelo de lista y lo añade a la lista de ingredientes
        listaIngredientesDisponibles = new JList();
        modeloListaIngredientes = new DefaultListModel<Ingrediente>();
        listaIngredientesDisponibles.setModel(modeloListaIngredientes);
        scrollPane.setViewportView(listaIngredientesDisponibles);
         
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(487, 261, 231, 108);
        add(scrollPane_1);
        
        // configura el modelo de lista y lo añade a la lista de ingredientes seleccionados
        listaIngredientesSeleccionados = new JList();
        modeloListaIngSeleccionados = new DefaultListModel<Ingrediente>();
        listaIngredientesSeleccionados.setModel(modeloListaIngSeleccionados);
        scrollPane_1.setViewportView(listaIngredientesSeleccionados);
        
        // ACTION PERFOMED: USUARIO QUIERE AÑADIR INGREDIENTES A LA OTRA LISTA
        btnIncluirIngrediente = new JButton(">>>");
        btnIncluirIngrediente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// consigue el indice del elemento seleccionado
        		int ingIndex = listaIngredientesDisponibles.getSelectedIndex();
        		// consigue el ingrediente en ese indice y guardalo en el objeto ingrediente
        		Ingrediente ing = modeloListaIngredientes.getElementAt(ingIndex);
        		// añadelo al modelo de lista de ingredientes
        		modeloListaIngSeleccionados.addElement(ing);
        		// y eliminalo de la lista de ingredientes disponibles
        		modeloListaIngredientes.remove(ingIndex);
        	}
        });
        btnIncluirIngrediente.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnIncluirIngrediente.setBounds(303, 278, 165, 23);
        add(btnIncluirIngrediente);
        
        //ACTION PERFOMED: usuario quiere quitar ingredientes de la lista de ingredientes
        btnQuitarIngrediente = new JButton("<<<");
        btnQuitarIngrediente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int ingIndex = listaIngredientesSeleccionados.getSelectedIndex();
        		// consigue el ingrediente en ese indice y guardalo en el objeto ingrediente
        		Ingrediente ing = modeloListaIngSeleccionados.getElementAt(ingIndex);
        		// añadelo al modelo de lista de ingredientes
        		modeloListaIngredientes.addElement(ing);
        		// y eliminalo de la lista de ingredientes disponibles
        		modeloListaIngSeleccionados.remove(ingIndex);
        	}
        });
        btnQuitarIngrediente.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnQuitarIngrediente.setBounds(299, 325, 169, 23);
        add(btnQuitarIngrediente);
        
        JLabel lblIngredientesSeleccionados = new JLabel("Ingredientes seleccionados:");
        lblIngredientesSeleccionados.setBounds(487, 233, 169, 16);
        add(lblIngredientesSeleccionados);
         
         
    }
         
    public void setControlador(ControladorVentanas c) {
        btnAddPincho.addActionListener(c);
        btnIncluirIngrediente.addActionListener(c);
        btnQuitarIngrediente.addActionListener(c);
         
    }
    
    public Pincho getDatosPincho(){
    	Pincho pincho = null;
    	String nombre = "";
    	double precio = 0;
    	Ciudad procedencia = null;
    	ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
    	
    	// recupera datos para crear el pincho
    	nombre = txtNombre.getText().toUpperCase();
    	try{
    		precio = Double.parseDouble(txtPrecio.getText());
    	}
    	catch(NumberFormatException nfe){
    		mostrarMsgErrorPrecio();
    	}
    	
    	// convierte de Objeto a Ciudad
    	procedencia = (Ciudad)(cmbBoxModelCiudad.getSelectedItem());
    	listaIngredientes = getIngredientesSeleccionados();
    	
    	// asigna los valores al nuevo pincho
    	pincho = new Pincho();
    	pincho.setNombre(nombre);
    	pincho.setPrecio(precio);
    	pincho.setProcedencia(procedencia);
    	pincho.setIngredientes(listaIngredientes);
    	
    	// devuelve el nuevo pincho
    	return pincho;
    }
    
    private void mostrarMsgErrorPrecio(){
    	JOptionPane.showMessageDialog(this, "El precio introducido no es válido", "Precio incorrecto", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarMsgPinchoOk(){
    	JOptionPane.showMessageDialog(this, "Pincho guardado correctamente", "Pincho guardado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarMsgPinchoError(){
    	JOptionPane.showMessageDialog(this, "Error al guardar el pincho, vuelve a intentarlo", "No se pudo guardar el pincho",
    			 																					+ JOptionPane.ERROR_MESSAGE);
    }
    
    private ArrayList<Ingrediente> getIngredientesSeleccionados(){
    	ArrayList<Ingrediente> listaIngSeleccionados = new ArrayList<Ingrediente>();
    	Ingrediente ingrediente = null;
    	if(!modeloListaIngSeleccionados.isEmpty()){
    		for(int i = 0; i < modeloListaIngSeleccionados.size(); i++){
    			ingrediente = modeloListaIngSeleccionados.getElementAt(i);
    			listaIngSeleccionados.add(ingrediente);
    		}
    	}
    	
    	return listaIngSeleccionados;
    }
    
    
    //TODO: calcular el coste del pincho en funcion de sus ingredientes
}
