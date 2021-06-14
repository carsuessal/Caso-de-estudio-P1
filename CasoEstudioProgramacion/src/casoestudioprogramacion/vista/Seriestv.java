package casoestudioprogramacion.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import casoestudioprogramacion.controlador.ConexionBD;
import casoestudioprogramacion.modelos.Serie;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author serhe
 */
public class Seriestv extends javax.swing.JFrame {

	/**
	 * Creación del id para manejo local de metodos locales
	 */
	int id_datase = 0;
	
	/**
	 * Serialización de lso paquetes
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * Creates new form Seriestv
	 * 
	 */
	public Seriestv() {
		initComponents();
	}

	/**
	 * Envia los datos de la serie a la BD
	 */

	public void enviarElemento(Serie serie) {
		PreparedStatement stmt = null;

		String query = "INSERT INTO seriestvitems (Codigo, Titulo, Fecha, Temporadas, Genero, Actores, Sinopsis ) VALUES (?,?,?,?,?,?,?)";

		try {
			System.out.println(serie);
			ConexionBD dbConexion = new ConexionBD();
			Connection con = dbConexion.getConnection();

			stmt = con.prepareStatement(query);
			stmt.setString(1, serie.getCodigo());
			stmt.setString(2, serie.getTitulo());
			stmt.setString(3, serie.getFecha());
			stmt.setInt(4, serie.getTemporadas());
			stmt.setString(5, serie.getGenero());
			stmt.setString(6, serie.getActores());
			stmt.setString(7, serie.getSinopsis());

			int retorno = stmt.executeUpdate();
			if (retorno > 0)
				System.out.println("Insertado correctamente");
			JOptionPane.showMessageDialog(null, "La serie " + serie.getTitulo() + "\n Se ha registrado con exito ");
			
			dbConexion.desconect();

		} catch (Exception e) {
			System.out.println("Error al conectar con la base de datos -Metodo:enviarElemento- ");
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param codigo
	 *
	 */
	public void actualizarSerie(int id) {
		
		PreparedStatement pstmt = null;
		int temporadas = Integer.parseInt(datoTemporadas.getText());
		String genero = (String) datoGenero.getSelectedItem();
		Serie serie = new Serie(datoCodigo.getText(), datoTitulo.getText(), datoFecha.getText(), temporadas,
				genero, datoActores.getText(), datoSinopsis.getText());
		String query = "UPDATE seriestvitems "
				+ "SET Codigo = ?,"
				+ "Titulo  = ?,"
				+ "Fecha  = ?,"
				+ "Temporadas = ?,"
				+ "Genero = ?,"
				+ "Actores = ?,"
				+ "Sinopsis = ? "
				+ " WHERE id = " + id ;

		try {
			ConexionBD dbConexion = new ConexionBD();
			Connection con = dbConexion.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, serie.getCodigo());
			pstmt.setString(2,  serie.getTitulo());
			pstmt.setString(3,  serie.getFecha());
			pstmt.setInt(4,  serie.getTemporadas());
			pstmt.setString(5,  serie.getGenero());
			pstmt.setString(6,  serie.getActores());
			pstmt.setString(7,  serie.getSinopsis());
			int n = pstmt.executeUpdate();
			System.out.println(n);
			//valida si se guardaron los datos; si pst>0 entonces se guardaron
			if (n > 0)
				System.out.println("Insertado correctamente");
			JOptionPane.showMessageDialog(null, "La serie " + serie.getTitulo() + "\n Se ha actulizado con exito ");
			
			dbConexion.desconect();
			

		} catch (Exception e) {
			
			System.out.println("Error editando serie" + e);
		}
	}
	public void eliminarSerie(int id) {
		
		PreparedStatement pstmt = null;
		int temporadas = Integer.parseInt(datoTemporadas.getText());
		String genero = (String) datoGenero.getSelectedItem();
		Serie serie = new Serie(datoCodigo.getText(), datoTitulo.getText(), datoFecha.getText(), temporadas,
				genero, datoActores.getText(), datoSinopsis.getText());
		String query = "DELETE FROM seriestvitems "
				+ " WHERE id = " + id ;

		try {
			ConexionBD dbConexion = new ConexionBD();
			Connection con = dbConexion.getConnection();
			pstmt = con.prepareStatement(query);
			int n = pstmt.executeUpdate();
			System.out.println(n);
			//valida si se guardaron los datos; si pst>0 entonces se guardaron
			if (n > 0)
				System.out.println("Insertado correctamente");
			JOptionPane.showMessageDialog(null, "La serie " + serie.getTitulo() + "\n Ha sido borrada");
			
			dbConexion.desconect();

		} catch (Exception e) {
			
			System.out.println("Error borrando serie" + e);
		}
	}


	public void disabelButton() {
		botonGuardar.setEnabled(true);
		btnBuscar.setEnabled(false);
		botonEditar.setEnabled(false);
		botonEliminar.setEnabled(false);

		datoCodigo.setEditable(true);
		datoTitulo.setEditable(true);
		datoFecha.setEditable(true);
		datoTemporadas.setEditable(true);
		datoGenero.setEditable(false);
		datoGenero.setEnabled(true);
		datoSinopsis.setEditable(true);
		datoActores.setEditable(true);
	}
public void borrarDatosIngresado() {
	datoCodigo.setText(null);
	datoTitulo.setText(null);
	datoFecha.setText(null);
	datoSinopsis.setText(null);
	datoTemporadas.setText(null);
	datoGenero.setSelectedIndex(0);
	datoActores.setText(null);
	datoCodigo.requestFocus();

	
}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// @SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		datoCodigo = new javax.swing.JTextField();
		btnBuscar = new javax.swing.JButton();
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = datoCodigo.getText().toString();
				ConexionBD conexion = new ConexionBD();
				ResultSet rs = conexion.consultarSerie(codigo);
			try {
				while(rs.next()) {
					borrarDatosIngresado();
					botonEditar.setEnabled(true);
					botonEliminar.setEnabled(true);
					
					datoCodigo.setEditable(true);
					datoTitulo.setEditable(true);
					datoFecha.setEditable(true);
					datoTemporadas.setEditable(true);
					datoGenero.setEditable(false);
					datoGenero.setEnabled(true);
					datoSinopsis.setEditable(true);
					datoActores.setEditable(true);
					
					id_datase = rs.getInt("id");
					System.out.println(id_datase);
					datoCodigo.setText(rs.getString("Codigo"));
					datoTitulo.setText(rs.getString("Titulo"));
					datoFecha.setText(rs.getString("Fecha"));
					datoTemporadas.setText(rs.getString("Temporadas"));
					datoGenero.setSelectedItem(rs.getString("Genero"));
					datoActores.setText(rs.getString("Actores"));
					datoSinopsis.setText(rs.getString("Sinopsis"));
					
				}
				conexion.desconect();
				
			if(datoActores.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El id Ingresdo no corresponde,\n a ninguna serie ");
			}else {
				JOptionPane.showMessageDialog(null, "Se ha encontrado datos de la Serie " + datoTitulo.getText());
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
				
			}
		});
		jLabel4 = new javax.swing.JLabel();
		datoTitulo = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		datoFecha = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		datoSinopsis = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		datoTemporadas = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		datoGenero = new javax.swing.JComboBox<>();
		jLabel10 = new javax.swing.JLabel();
		datoActores = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();
		botonGuardar = new javax.swing.JButton();
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int temporadas = Integer.parseInt(datoTemporadas.getText());
				String genero = (String) datoGenero.getSelectedItem();

				// Creación del objeto serie
				Serie serie = new Serie(datoCodigo.getText(), datoTitulo.getText(), datoFecha.getText(), temporadas,
						genero, datoActores.getText(), datoSinopsis.getText());

				// Envio del objeto a la base datos
				enviarElemento(serie);

				borrarDatosIngresado();
			}

		});
		botonEditar = new javax.swing.JButton();
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Creación del objeto serie
				actualizarSerie(id_datase);
				borrarDatosIngresado();

			}
		});
		btnLimpiar = new javax.swing.JButton();
		botonEliminar = new javax.swing.JButton();
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarSerie(id_datase);
				borrarDatosIngresado();
			}
		});
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		jLabel2.setText("jLabel2");

		jLabel5.setText("jLabel5");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel3.setText("Codigo");

		datoCodigo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		btnBuscar.setText("Buscar");

		jLabel4.setText("Titulo");

		datoTitulo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel6.setText(" Fecha");

		datoFecha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jLabel7.setText("Sinopsis");

		datoSinopsis.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField4ActionPerformed(evt);
			}
		});

		jLabel8.setText("Temporadas");

		datoTemporadas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField5ActionPerformed(evt);
			}
		});

		jLabel9.setText("Genero");

		datoGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Accion",
				"Ciencia Ficcion", "Comedia", "Drama", "Misterio", "Romantica", "Terror" }));

		jLabel10.setText("Actores");

		datoActores.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField6ActionPerformed(evt);
			}
		});

		JRadioButton btnrAgregarSerie = new JRadioButton("Agregar Serie");
		btnrAgregarSerie.setSelected(true);

		if (btnrAgregarSerie.isSelected()) {
			disabelButton();

		}

		btnrAgregarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disabelButton();

			}
		});

		JRadioButton btnBuscarSerie = new JRadioButton("Buscar serie");
		btnBuscarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar.setEnabled(false);
				btnBuscar.setEnabled(true);
				botonEditar.setEnabled(true);
				botonEliminar.setEnabled(true);

				datoCodigo.setEditable(true);
				datoTitulo.setEditable(false);
				datoFecha.setEditable(false);
				datoTemporadas.setEditable(false);
				datoGenero.setEditable(false);
				datoGenero.setEnabled(false);
				datoSinopsis.setEditable(false);
				datoActores.setEditable(false);

			}
		});

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnrAgregarSerie);
		btnGroup.add(btnBuscarSerie);

		JScrollPane scrollPane = new JScrollPane();

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
						.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel2Layout
								.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(datoActores, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
										.addComponent(datoTemporadas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171,
												Short.MAX_VALUE)
										.addComponent(datoFecha, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171,
												Short.MAX_VALUE)
										.addComponent(jLabel6).addComponent(jLabel8).addComponent(jLabel9)
										.addComponent(datoGenero, 0, 171, Short.MAX_VALUE).addComponent(jLabel10))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(datoSinopsis,
														GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
										.addGroup(jPanel2Layout.createSequentialGroup().addGap(81)
												.addComponent(jLabel7))))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnrAgregarSerie).addComponent(datoCodigo,
														GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(btnBuscarSerie).addGap(68))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 177,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))))
						.addGap(0))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(datoTitulo, 316, 316, 316)
								.addContainerGap(65, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel4).addContainerGap(355,
								Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3).addContainerGap(348,
								Short.MAX_VALUE)))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(btnrAgregarSerie)
						.addComponent(btnBuscarSerie))
				.addGap(15).addComponent(jLabel3).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(btnBuscar).addComponent(
						datoCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel4)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(
						datoTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
						.createSequentialGroup().addComponent(jLabel7)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(datoSinopsis, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(67).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(datoFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel8).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(datoTemporadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(jLabel9).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(datoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel10).addGap(11)
								.addComponent(datoActores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		jPanel2.setLayout(jPanel2Layout);

		jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		botonGuardar.setText("Gardar");
		botonGuardar.setPreferredSize(new java.awt.Dimension(66, 23));

		botonEditar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		botonEditar.setText("Editar");
		botonEditar.setPreferredSize(new java.awt.Dimension(66, 23));

		btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setPreferredSize(new java.awt.Dimension(66, 23));
		btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		botonEliminar.setText("Eliminar");
		botonEliminar.setPreferredSize(new java.awt.Dimension(66, 23));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(botonGuardar, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(botonEditar, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(botonEliminar, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(botonEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		jPanel3.setLayout(jPanel3Layout);

		jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		JLabel lblNewLabel = new JLabel("");
		// lblNewLabel.setIcon(new
		// ImageIcon(Seriestv.class.getResource("/casoestudioprogramacion/interfaz/series5.png")));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(103).addComponent(jLabel1).addGap(18)
						.addComponent(lblNewLabel).addContainerGap(135, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1))
								.addComponent(lblNewLabel))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
				.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField2ActionPerformed

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField3ActionPerformed

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField4ActionPerformed

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField5ActionPerformed

	private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField6ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField6ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		datoCodigo.setToolTipText("Ingrese el codigo");
		datoCodigo.setText(null);
		datoTitulo.setText(null);
		datoFecha.setText(null);
		datoSinopsis.setText(null);
		datoTemporadas.setText(null);
		datoGenero.setSelectedIndex(0);
		datoActores.setText(null);
		datoCodigo.requestFocus();

	}// GEN-LAST:event_jButton4ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Seriestv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Seriestv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Seriestv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Seriestv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Seriestv().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnBuscar;
	private javax.swing.JButton botonGuardar;
	private javax.swing.JButton botonEditar;
	private javax.swing.JButton btnLimpiar;
	private javax.swing.JButton botonEliminar;
	private javax.swing.JComboBox<String> datoGenero;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTextField datoCodigo;
	private javax.swing.JTextField datoTitulo;
	private javax.swing.JTextField datoFecha;
	private javax.swing.JTextField datoSinopsis;
	private javax.swing.JTextField datoTemporadas;
	private javax.swing.JTextField datoActores;
}
