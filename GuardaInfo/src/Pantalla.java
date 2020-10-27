import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Class.Conection;
import Class.Validaciones;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pantalla {

	private JFrame frame;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtFONO;
	private JTextField txtContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int ncarac =7;
				if(txtDNI.getText().length()>ncarac) {
					arg0.consume();
					//JOptionPane.showMessageDialog(null, "solo 8 digitos");

					
					
				}
	
			}
		});
		txtDNI.setBounds(138, 38, 146, 26);
		frame.getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 80, 146, 26);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFONO = new JTextField();
		txtFONO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int nfono=8;
				if (txtFONO.getText().length()>nfono) {
					e.consume();
				}
			}
		});
		txtFONO.setBounds(138, 123, 146, 26);
		frame.getContentPane().add(txtFONO);
		txtFONO.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setBounds(138, 165, 146, 26);
		frame.getContentPane().add(txtContact);
		txtContact.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String varDNI;
				String varNombre;
				String varFono;
				String varContact;
				varDNI= txtDNI.getText();
				varNombre= txtNombre.getText();			
				varFono= txtFONO.getText();
				varContact= txtContact.getText();
				
				Validaciones val = new Validaciones();
				boolean dnicorrecto = val.esNumero(varDNI);
							
				if(dnicorrecto==false){
					JOptionPane.showMessageDialog(null, "Error DNI contiene letras");
				}
				else if(varDNI.length()!=8) {
					JOptionPane.showMessageDialog(null, "Error DNI menos digitos");
				}				
				else if(varFono.length()!=9) {
					JOptionPane.showMessageDialog(null, "Error telefono");
				}
								
				else {						
				 Conection x = new Conection();
				 x.insertar(varDNI,varNombre,varFono,varContact);
				}		


				
				
				
				
			}
		});
		btnGuardar.setBounds(72, 207, 115, 29);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(202, 207, 115, 29);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(26, 41, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(26, 83, 69, 20);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(26, 126, 97, 20);
		frame.getContentPane().add(lblTelefono);
		
		JLabel lblContacto = new JLabel("CONTACTO:");
		lblContacto.setBounds(26, 168, 97, 20);
		frame.getContentPane().add(lblContacto);
		
		JLabel errorFono = new JLabel("");
		errorFono.setBounds(299, 126, 69, 20);
		frame.getContentPane().add(errorFono);
	}
}
