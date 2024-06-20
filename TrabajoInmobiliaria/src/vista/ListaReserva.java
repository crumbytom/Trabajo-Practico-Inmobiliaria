package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.ControladorCliente;
import controlador.ControladorEmpleado;
import controlador.InmuebleControlador;
import controlador.ReservaControlador;
import trabajoInmobiliaria.Inmueble;
import trabajoInmobiliaria.Reserva;

public class ListaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpBusqReserva;
	private JTextField inpBusqCliente;
	private JTextField inpBusqInmueble;
	private JTable tablaReserva;
	private DefaultTableModel modeloReserva;
	private ReservaControlador controladorReserva;
	private OpcionesReserva VolverMenu;
	private Reserva reservaseleccionada;
	private ControladorEmpleado empleadoselec;
	private ControladorCliente clienteselec;
	private InmuebleControlador inmuebleselec;
	private VerReserva verDetalles;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReserva frame = new ListaReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		if (controladorReserva == null) {
			
			controladorReserva = new ReservaControlador();
			
		}
		
		if (reservaseleccionada == null) {
			
			
			reservaseleccionada = new Reserva();
			
		}
		
		if (empleadoselec == null ) {
			
			empleadoselec = new ControladorEmpleado();
			
		}
		
		if (clienteselec == null) {
			
			clienteselec = new ControladorCliente();
			
		}
		
		if (inmuebleselec == null) {
			
			inmuebleselec = new InmuebleControlador();
			
		}
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 884, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -23, 884, 87);
		panel.add(tabbedPane);
		
		JButton btnReserva = new JButton("ID reserva");
		JButton btnIdCliente = new JButton("ID Cliente");
		JButton btnIdInmueble = new JButton("ID inmueble");
		JButton btnOperacion = new JButton("Operacion");
		
		
		if (tabbedPane.getSelectedIndex() == -1) {
			
			btnReserva.setForeground(Color.cyan);
			
		}
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Filtrar por ID reserva", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblBusquedaReserva = new JLabel("Ingresar el id de la reserva:");
		lblBusquedaReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusquedaReserva.setBounds(100, 13, 192, 26);
		panel_1.add(lblBusquedaReserva);
		
		inpBusqReserva = new JTextField();
		inpBusqReserva.setBounds(290, 15, 221, 26);
		panel_1.add(inpBusqReserva);
		inpBusqReserva.setColumns(10);
		
		JButton btnBuscarReserva = new JButton("Buscar");
		btnBuscarReserva.setBounds(535, 15, 113, 26);
		panel_1.add(btnBuscarReserva);
		
		JButton btnResetReserv = new JButton("Reset");
		btnResetReserv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarTabla();
			}
		});
		btnResetReserv.setBounds(670, 15, 109, 26);
		panel_1.add(btnResetReserv);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblBusquedaCliente = new JLabel("Ingresar el id del cliente:");
		lblBusquedaCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusquedaCliente.setBounds(100, 13, 192, 26);
		panel_3.add(lblBusquedaCliente);
		
		

		inpBusqCliente = new JTextField();
		inpBusqCliente.setColumns(10);
		inpBusqCliente.setBounds(290, 15, 221, 26);
		panel_3.add(inpBusqCliente);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(535, 15, 113, 26);
		panel_3.add(btnBuscarCliente);
		
		JButton btnResetCliente = new JButton("Reset");
		btnResetCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarTabla();
				
			}
		});
		btnResetCliente.setBounds(670, 15, 109, 26);
		panel_3.add(btnResetCliente);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblBusquedaInmueble = new JLabel("Ingresar el id del inmueble:");
		lblBusquedaInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusquedaInmueble.setBounds(100, 13, 192, 26);
		panel_4.add(lblBusquedaInmueble);
		
		inpBusqInmueble = new JTextField();
		inpBusqInmueble.setColumns(10);
		inpBusqInmueble.setBounds(290, 15, 221, 26);
		panel_4.add(inpBusqInmueble);
		
		JButton btnBuscarInmueble = new JButton("Buscar");
		btnBuscarInmueble.setBounds(535, 15, 113, 26);
		panel_4.add(btnBuscarInmueble);
		
		JButton btnResetInmueble = new JButton("Reset");
		btnResetInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarTabla();
				
			}
		});
		btnResetInmueble.setBounds(670, 15, 109, 26);
		panel_4.add(btnResetInmueble);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblBusqOperacion = new JLabel("Seleccionar el tipo de operacion:");
		lblBusqOperacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusqOperacion.setBounds(56, 13, 236, 26);
		panel_5.add(lblBusqOperacion);
		
		JButton btnBuscarOperacion = new JButton("Buscar");
		btnBuscarOperacion.setBounds(535, 15, 113, 26);
		panel_5.add(btnBuscarOperacion);
		
		JButton btnResetOperacion = new JButton("Reset");
		btnResetOperacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarTabla();
				
			}
		});
		btnResetOperacion.setBounds(670, 15, 109, 26);
		panel_5.add(btnResetOperacion);
		
		JComboBox<String> comboBoxOperacion = new JComboBox<String>();
		comboBoxOperacion.setBackground(new Color(255, 255, 255));
		comboBoxOperacion.setBounds(290, 15, 221, 26);
		panel_5.add(comboBoxOperacion);
		
		comboBoxOperacion.addItem("Venta");
		comboBoxOperacion.addItem("Alquiler");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 884, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(0);
				
				if (tabbedPane.getSelectedIndex() == 0) {
					
					
					btnReserva.setForeground(Color.cyan);
					btnIdCliente.setForeground(Color.black);
					btnIdInmueble.setForeground(Color.black);
					btnOperacion.setForeground(Color.black);
				} 
				
				
				
			}
		});
		
		
		
		
		btnReserva.setBounds(0, 0, 221, 46);
		panel_2.add(btnReserva);
		
		btnOperacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tabbedPane.setSelectedIndex(3);
				
				if (tabbedPane.getSelectedIndex()==3) {
					
					btnIdCliente.setForeground(Color.black);
					btnReserva.setForeground(Color.black);
					btnIdInmueble.setForeground(Color.black);
					btnOperacion.setForeground(Color.cyan);
					
				}
				
				
			}
		});
		btnOperacion.setBounds(664, 0, 220, 46);
		panel_2.add(btnOperacion);
		
		btnIdInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tabbedPane.setSelectedIndex(2);
				
				if (tabbedPane.getSelectedIndex() == 2) {
					
					btnIdCliente.setForeground(Color.black);
					btnReserva.setForeground(Color.black);
					btnIdInmueble.setForeground(Color.cyan);
					btnOperacion.setForeground(Color.black);
					
					
				}
				
				
			}
		});
		
		
		btnIdInmueble.setBounds(443, 0, 220, 46);
		panel_2.add(btnIdInmueble);
		
		btnIdCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			tabbedPane.setSelectedIndex(1);
			
			if (tabbedPane.getSelectedIndex() == 1) {
				
				btnIdCliente.setForeground(Color.cyan);
				btnReserva.setForeground(Color.black);
				btnIdInmueble.setForeground(Color.black);
				btnOperacion.setForeground(Color.black);
				
			}
			
			
			
			}
		});
		
		btnIdCliente.setBounds(222, 0, 220, 46);
		panel_2.add(btnIdCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Reservas");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(384, 110, 500, 53);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 169, 820, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 683, 820, 2);
		contentPane.add(separator_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (VolverMenu == null) {
					
					VolverMenu = new OpcionesReserva();
					
				}
				
				VolverMenu.setLocationRelativeTo(null);
				
				VolverMenu.setVisible(true);
				
				dispose();
				
			}
		});
		btnVolver.setBounds(250, 700, 107, 46);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 182, 820, 488);
		contentPane.add(scrollPane);
		
		
		String [] ColumnasReserva = {"Id reserva","Id inmueble","Id cliente","Fecha_operacion","Monto","Forma de pago","Empleado","Tipo de reserva"};
		modeloReserva = new DefaultTableModel(ColumnasReserva,0);
		tablaReserva = new JTable(modeloReserva);
		scrollPane.setViewportView(tablaReserva);
		
		JButton btnSeleccionar = new JButton("Detalles");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (reservaseleccionada.getId_reserva()!=0) {
					
					if (verDetalles == null) {
						
						verDetalles = new VerReserva(reservaseleccionada);
						
					}
					
				}
				
				verDetalles.setLocationRelativeTo(null);
				
				verDetalles.setVisible(true);
				
				dispose();
				
				
				
			}
		});
		btnSeleccionar.setBounds(500, 700, 107, 46);
		contentPane.add(btnSeleccionar);
		MostrarTabla();
		
		
		
		 ListSelectionModel selectionModelReserva= tablaReserva.getSelectionModel();
			
		 selectionModelReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		
		 selectionModelReserva.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tablaReserva.getSelectedRow();
                    if (selectedRow != -1) {
                    	int id = (int) tablaReserva.getValueAt(selectedRow, 0);
                        int id_inmueble = (int) tablaReserva.getValueAt(selectedRow, 1);
                        int id_cliente = (int) tablaReserva.getValueAt(selectedRow, 2);	           
                        LocalDate Fecha_pago = (LocalDate) tablaReserva.getValueAt(selectedRow, 3);
                        double Pago = (double) tablaReserva.getValueAt(selectedRow, 4);
                        String Forma_pago = (String) tablaReserva.getValueAt(selectedRow, 5);
                        int id_empleado = (int) tablaReserva.getValueAt(selectedRow, 6);
                        String Tipo_reserva = (String) tablaReserva.getValueAt(selectedRow, 7);                                 
                       
                                              
                        reservaseleccionada.setId_reserva(id);
                        reservaseleccionada.setInmueble(inmuebleselec.getInmuebleById(id_inmueble));
                        reservaseleccionada.setCliente(clienteselec.getClienteById(id_cliente));
                        reservaseleccionada.setFecha_pago(Fecha_pago);
                        reservaseleccionada.setPago(Pago);
                        reservaseleccionada.setForma_pago(Forma_pago);
                        reservaseleccionada.setEmpleado(empleadoselec.getEmpleadoById(id_empleado));
                        reservaseleccionada.setTipo_reserva(Tipo_reserva);
                        
                      
                    }
                }
            }
        });
		
		
		
		
		
		
	}
	
	
	public void MostrarTabla() {
		
		modeloReserva.setRowCount(0);
		
		List<Reserva> reservas = controladorReserva.getAllReserva();
		
		for (Reserva reserva : reservas) {
			
			modeloReserva.addRow( 
					
					new Object[] {
							
					
					reserva.getId_reserva(),
					reserva.getInmueble().getId_inmueble(),
					reserva.getCliente().getId_cliente(),
					reserva.getFecha_pago(),
					reserva.getPago(),
					reserva.getForma_pago(),
					reserva.getEmpleado().getId_empleado(),
					reserva.getTipo_reserva()
			
					}
					);
			
			
		}
		
		
		
		
		
		
		
	}
	
}