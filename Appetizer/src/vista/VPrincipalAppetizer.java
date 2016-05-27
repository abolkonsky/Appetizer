package vista;
 
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import controlador.ControladorVentanas;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
 
public class VPrincipalAppetizer extends JFrame implements IVentana {
	private static final long serialVersionUID = -5420090540842422702L;
	private JMenuItem mntmConsultarPincho;
    private JMenuItem mntmConsultarIngrediente;
    private JMenuItem mntmConsultarRestaurante;
    private JMenuItem mntmEditarPincho;
    private JMenuItem mntmEditarIngrediente;
    private JMenuItem mntmEditarRestaurante;
    private JMenuItem mntmEliminarIngrediente;
    private JMenuItem mntmEliminarPincho;
    private JMenuItem mntmEliminarRestaurante;
    private JMenu mnAadir;
    private JMenuItem mntmA�adirPincho;
    private JMenuItem mntmA�adirIndrediente;
    private JMenuItem mntmA�adirRestaurante;
    private JMenuItem mntmInformeEconmico;
    private JScrollPane contenedorPnl;
     
    // constructor 
    public VPrincipalAppetizer() {
        super("APPETIZER");     
        crearMenu();
        inicializar();
         
    }
    
    public JMenuItem getMntmConsultarPincho() {
		return mntmConsultarPincho;
	}
    
    public JMenuItem getMntmA�adirPincho() {
		return mntmA�adirPincho;
	}


	// metodos
    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
         
        JMenu mnConsultar = new JMenu("Pincho");
        mnConsultar.setPreferredSize(new Dimension(160, 35));
        mnConsultar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuBar.add(mnConsultar);
        
        mntmA�adirPincho = new JMenuItem("A\u00F1adir Pincho");
        mnConsultar.add(mntmA�adirPincho);
        mntmA�adirPincho.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mntmA�adirPincho.setPreferredSize(new Dimension(190, 22));
         
        mntmConsultarPincho = new JMenuItem("Consultar Pincho");
        mntmConsultarPincho.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mntmConsultarPincho.setPreferredSize(new Dimension(150, 22));
        mnConsultar.add(mntmConsultarPincho);
        
        mntmEditarPincho = new JMenuItem("Editar Pincho");
        mnConsultar.add(mntmEditarPincho);
        mntmEditarPincho.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mntmEditarPincho.setPreferredSize(new Dimension(150, 22));
        
        mntmEliminarPincho = new JMenuItem("Eliminar Pincho");
        mnConsultar.add(mntmEliminarPincho);
        mntmEliminarPincho.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mntmEliminarPincho.setPreferredSize(new Dimension(150, 22));
         
        JMenu mnModificar = new JMenu("Ingrediente");
        mnModificar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        mnModificar.setPreferredSize(new Dimension(160, 22));
        menuBar.add(mnModificar);
        
        mntmA�adirIndrediente = new JMenuItem("A\u00F1adir Ingrediente");
        mnModificar.add(mntmA�adirIndrediente);
        mntmA�adirIndrediente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        mntmConsultarIngrediente = new JMenuItem("Consultar Ingrediente");
        mnModificar.add(mntmConsultarIngrediente);
        mntmConsultarIngrediente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
         
        mntmEditarIngrediente = new JMenuItem("Editar Ingrediente");
        mntmEditarIngrediente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mnModificar.add(mntmEditarIngrediente);
        
        mntmEliminarIngrediente = new JMenuItem("Eliminar Ingrediente");
        mnModificar.add(mntmEliminarIngrediente);
        mntmEliminarIngrediente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
         
        JMenu mnEliminar = new JMenu("Restaurante");
        mnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        mnEliminar.setPreferredSize(new Dimension(160, 22));
        menuBar.add(mnEliminar);
        
        mntmA�adirRestaurante = new JMenuItem("A\u00F1adir Restaurante");
        mnEliminar.add(mntmA�adirRestaurante);
        mntmA�adirRestaurante.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        mntmConsultarRestaurante = new JMenuItem("Consultar Restaurante");
        mnEliminar.add(mntmConsultarRestaurante);
        mntmConsultarRestaurante.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        mntmEditarRestaurante = new JMenuItem("Editar Restaurante");
        mnEliminar.add(mntmEditarRestaurante);
        mntmEditarRestaurante.setFont(new Font("Segoe UI", Font.PLAIN, 20));
         
        mntmEliminarRestaurante = new JMenuItem("Restaurante");
        mntmEliminarRestaurante.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mnEliminar.add(mntmEliminarRestaurante);
         
        mnAadir = new JMenu("Informe Econ\u00F3mico");
        mnAadir.setFont(new Font("Segoe UI", Font.BOLD, 20));
        mnAadir.setPreferredSize(new Dimension(160, 22));
        menuBar.add(mnAadir);
        
        mntmInformeEconmico = new JMenuItem("Informe econ\u00F3mico");
        mnAadir.add(mntmInformeEconmico);
        mntmInformeEconmico.setFont(new Font("Segoe UI", Font.PLAIN, 20));
         
        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 20));
        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(getContentPane(), 
                        "�Desea salir de la aplicaci�n?", 
                        "Confirmaci�n", 
                        JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
         
        menuBar.add(mntmSalir);
         
        contenedorPnl = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(contenedorPnl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(contenedorPnl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        getContentPane().setLayout(groupLayout);
    }
     
    public void inicializar() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
 
    }
 
    public void hacerVisible() {
        // Colocar autom�ticamente los componente en la ventana
        this.pack();
        // hace visible la ventana
        this.setVisible(true);
 
    }
     
    public void setControlador(ControladorVentanas c) {
        mntmConsultarIngrediente.addActionListener(c);
        mntmConsultarPincho.addActionListener(c);
        mntmConsultarRestaurante.addActionListener(c);
        mntmA�adirIndrediente.addActionListener(c);
        mntmA�adirPincho.addActionListener(c);
        mntmA�adirRestaurante.addActionListener(c);
        mntmEditarIngrediente.addActionListener(c);
        mntmEditarPincho.addActionListener(c);
        mntmEditarRestaurante.addActionListener(c);
        mntmEliminarPincho.addActionListener(c);
        mntmEliminarIngrediente.addActionListener(c);
        mntmEliminarRestaurante.addActionListener(c);
         
    }
 
    public void definirPanel(JPanel panel) {
        contenedorPnl.setViewportView(panel);
    }
}