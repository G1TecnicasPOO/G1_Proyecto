package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import clase.Persona;

public class Avance1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_Nombre;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txt_Edad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblIngreseDni;
	private JTextField txt_DNI;
	private JLabel lblIngreseCelular;
	private JTextField txt_Celular;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_2;
	private JTextField txtApellido;
	private Persona[] listaPersonas = new Persona[100];
	private int contador = 0;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avance1 frame = new Avance1();
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
	public Avance1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txt_Nombre = new JTextField();
			txt_Nombre.setBounds(114, 25, 89, 20);
			contentPane.add(txt_Nombre);
			txt_Nombre.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("Ingrese Nombre");
			lblNewLabel.setBounds(10, 28, 94, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Ingrese Edad");
			lblNewLabel_1.setBounds(25, 64, 89, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txt_Edad = new JTextField();
			txt_Edad.setBounds(114, 61, 86, 20);
			contentPane.add(txt_Edad);
			txt_Edad.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(70, 157, 448, 180);
			contentPane.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			lblIngreseDni = new JLabel("Ingrese DNI");
			lblIngreseDni.setBounds(210, 64, 89, 14);
			contentPane.add(lblIngreseDni);
		}
		{
			txt_DNI = new JTextField();
			txt_DNI.setBounds(282, 61, 89, 20);
			txt_DNI.setColumns(10);
			contentPane.add(txt_DNI);
		}
		{
			lblIngreseCelular = new JLabel("Ingrese celular");
			lblIngreseCelular.setBounds(399, 64, 89, 14);
			contentPane.add(lblIngreseCelular);
		}
		{
			txt_Celular = new JTextField();
			txt_Celular.setBounds(498, 61, 86, 20);
			txt_Celular.setColumns(10);
			contentPane.add(txt_Celular);
		}
		{
			btnNewButton_3 = new JButton("Adicionar");
			btnNewButton_3.setBounds(10, 89, 99, 23);
			btnNewButton_3.addActionListener(this);
			contentPane.add(btnNewButton_3);
		}
		{
			lblNewLabel_2 = new JLabel("Ingrese Apellidos");
			lblNewLabel_2.setBounds(272, 28, 99, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(372, 25, 86, 20);
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			btnNewButton_2 = new JButton("Eliminar");
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setBounds(263, 89, 89, 23);
			contentPane.add(btnNewButton_2);
		}
		{
			btnNewButton = new JButton("Modificar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(385, 89, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Buscar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(136, 89, 89, 23);
			contentPane.add(btnNewButton_1);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_3) {
			do_btnNewButton_3_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
	txtS.setText("");
	Persona p=new Persona(txt_Nombre.getText(),txtApellido.getText(), txt_DNI.getText(), txt_Celular.getText(),txt_Edad.getText());
	listaPersonas[contador] = p;
	contador++;
	txtS.append("Nombres: " + p.getNombre() + "\n");
	txtS.append("Apellidos: " + p.getApellido() + "\n");
	txtS.append("DNI: " + p.getDni() + "\n");
	txtS.append("Celular: " + p.getNum_celular() + "\n");
	txtS.append("Edad: " + p.getEdad() + "\n");
	actualizarLista();
	limpiezatext();
	
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		try {
		String dniBus = txt_DNI.getText().trim();
		int pos = -1;
		
		for(int i= 0; i<contador;i++) {
			if(listaPersonas[i].getDni().equals(dniBus)) {
				pos = i;
				break;
			}
		}
		if (pos == -1) {
			MostrarError();
			return;
		}
		for(int i = pos; i < contador -1; i++) {
			listaPersonas[i] = listaPersonas[i+1];
		}
		contador --;
		JOptionPane.showMessageDialog(null, "La persona fue eliminada");
		limpiezatext();
		actualizarLista();
	} catch (Exception e2) {
		MostrarError();
	}
}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
		String buscarDni = txt_DNI.getText().trim();
		int pos = -1;
		for(int i=0 ; i < contador;i++) {
			if(listaPersonas[i].getDni().equals(buscarDni)) {
				pos = i;
				break;
			}
		}
		if(pos == -1) {
			MostrarError();
			return;
		}
		listaPersonas[pos].setNombre(txt_Nombre.getText());
		listaPersonas[pos].setApellido(txtApellido.getText());
		listaPersonas[pos].setNum_celular(txt_Celular.getText());
		listaPersonas[pos].setEdad(txt_Edad.getText());
		JOptionPane.showMessageDialog(null, "Datos de la persona modificado correctamente");
		actualizarLista();
	} catch (Exception e2) {
		MostrarError();
	}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		try {
		String buscarDni = txt_DNI.getText().trim();
		int pos = -1;
		for (int i =0; i< contador;i++) {
			if(listaPersonas[i].getDni().equals(buscarDni)) {
				pos = 1;
				break;
			}
		}
		if(pos == -1) {	
			MostrarError();
			return;
		}
		txt_Nombre.setText(listaPersonas[pos].getNombre());
		txtApellido.setText(listaPersonas[pos].getApellido());
		txt_Edad.setText(listaPersonas[pos].getEdad());
		txt_Celular.setText(listaPersonas[pos].getNum_celular());
		
	} catch (Exception e2) {
		MostrarError();
	}
	}
	void MostrarError() {
		JOptionPane.showMessageDialog(this, "DNI no encontrado o dato inválido");
	}
	void limpiezatext() {
		txt_Nombre.setText("");
		txtApellido.setText("");
		txt_Edad.setText("");
		txt_DNI.setText("");
		txt_Celular.setText("");}
	
	void actualizarLista() {
			txtS.setText("");
			for (int i = 0; i < contador; i++) {
				txtS.append("Nombres: " + listaPersonas[i].getNombre()+"\n"
						+ " Apellidos: " + listaPersonas[i].getApellido()+"\n"
						+ " Edad: " + listaPersonas[i].getEdad()+"\n"
						+ " DNI: " + listaPersonas[i].getDni()+"\n"
						+ " Celular: " + listaPersonas[i].getNum_celular()+"\n");
		}
	}
}