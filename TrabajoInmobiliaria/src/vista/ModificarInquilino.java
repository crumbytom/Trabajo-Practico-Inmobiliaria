package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.InquilinoControlador;
import trabajoInmobiliaria.Cliente;
import trabajoInmobiliaria.Inquilino;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ModificarInquilino extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDni;
	private JTextField textFechaNacimiento;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JTextField textDireccion;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ModificarInquilino(Inquilino cliente) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 109, 106));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InquilinoControlador inquilinocont = new InquilinoControlador();

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(48, 109, 106));
		panel.setBounds(0, 11, 784, 32);
		contentPane.add(panel);
		
		JLabel lblModificarCliente = new JLabel("Modificar Cliente");
		lblModificarCliente.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModificarCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		panel.add(lblModificarCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(48, 109, 106));
		panel_1.setBounds(10, 54, 764, 388);
		contentPane.add(panel_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(10, 61, 349, 29);
		panel_1.add(textNombre);
		textNombre.setText(cliente.getNombre());
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (YYYY-MM-DD)");
		lblFechaDeNacimiento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFechaDeNacimiento.setBounds(10, 277, 332, 14);
		panel_1.add(lblFechaDeNacimiento);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDni.setBounds(10, 203, 166, 14);
		panel_1.add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblApellido.setBounds(10, 119, 166, 14);
		panel_1.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(10, 36, 166, 14);
		panel_1.add(lblNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(10, 141, 349, 29);
		panel_1.add(textApellido);
		textApellido.setText(cliente.getApellido());

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(10, 225, 349, 29);
		panel_1.add(textDni);
		textDni.setText(String.valueOf(cliente.getDni()));
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		textFechaNacimiento.setBounds(10, 302, 349, 29);
		panel_1.add(textFechaNacimiento);
		String fechaString = cliente.getFecha_nacimiento().getYear() + "-" + cliente.getFecha_nacimiento().getMonthValue() + "-" + cliente.getFecha_nacimiento().getDayOfMonth();
		if(cliente.getFecha_nacimiento().getMonthValue() < 10) {
			 fechaString = cliente.getFecha_nacimiento().getYear() + "-0" + cliente.getFecha_nacimiento().getMonthValue() + "-" + cliente.getFecha_nacimiento().getDayOfMonth();
		} if(cliente.getFecha_nacimiento().getDayOfMonth() < 10) {
			 fechaString = cliente.getFecha_nacimiento().getYear() + "-" + cliente.getFecha_nacimiento().getMonthValue() + "-0" + cliente.getFecha_nacimiento().getDayOfMonth();

		}
		if(cliente.getFecha_nacimiento().getDayOfMonth() < 10 &&  cliente.getFecha_nacimiento().getMonthValue() < 10) {
			 fechaString = cliente.getFecha_nacimiento().getYear() + "-0" + cliente.getFecha_nacimiento().getMonthValue() + "-0" + cliente.getFecha_nacimiento().getDayOfMonth();

		}
		textFechaNacimiento.setText(fechaString);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(405, 61, 349, 29);
		panel_1.add(textTelefono);
		textTelefono.setText(String.valueOf(cliente.getTelefono()));

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTelefono.setBounds(405, 37, 166, 14);
		panel_1.add(lblTelefono);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(405, 141, 349, 29);
		panel_1.add(textCorreo);
		textCorreo.setText(cliente.getCorreo());
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCorreo.setBounds(405, 120, 166, 14);
		panel_1.add(lblCorreo);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(405, 225, 349, 29);
		panel_1.add(textDireccion);
		textDireccion.setText(cliente.getDireccion());

		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDireccion.setBounds(405, 204, 166, 14);
		panel_1.add(lblDireccion);
		
		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente");
		lblTipoDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTipoDeCliente.setBounds(405, 278, 166, 14);
		panel_1.add(lblTipoDeCliente);
		
		JComboBox cbTipoCliente = new JComboBox();
		cbTipoCliente.setBounds(405, 305, 349, 26);
		panel_1.add(cbTipoCliente);
		cbTipoCliente.addItem("Inquilino");

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.LIGHT_GRAY);
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(34, 79, 75));
		btnModificar.setBounds(353, 348, 117, 29);
		panel_1.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setNombre(textNombre.getText());
				cliente.setApellido(textApellido.getText());
				cliente.setDni(Integer.parseInt(textDni.getText()));
				cliente.setFecha_nacimiento(LocalDate.parse(textFechaNacimiento.getText()));
				cliente.setTelefono(Integer.parseInt(textTelefono.getText()));
				cliente.setCorreo(textCorreo.getText());
				cliente.setDireccion(textDireccion.getText());
				
				inquilinocont.updateInquilino(cliente);
				JOptionPane.showMessageDialog(null, "Modificacion exitosa");
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.LIGHT_GRAY);
		btnVolver.setBorder(null);
		btnVolver.setBackground(new Color(34, 79, 75));
		btnVolver.setBounds(225, 351, 117, 26);
		panel_1.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCliente pantallacliente =  new PantallaCliente();
				dispose();
			}
		});
		
		
		
	}
}
