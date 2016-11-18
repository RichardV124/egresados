/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.ingesoft.egresados.vista.gui;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreasEgresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Egresado;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionAcademica;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.SectorLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.GeneroEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MaximoNivelEduEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.MesEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.SituacionLaboralEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoCorreoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoDocumentoEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoEmpresaEnum;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.TipoTelefonoEnum;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.egresados.vista.controladores.ControladorVentanaRegistroEgresados;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author 416pc03
 */
public class VentanaRegistroEgresados extends javax.swing.JFrame {

	/**
	 * controlador de la ventana donde se encuentra las operaciones logicas
	 */
	private ControladorVentanaRegistroEgresados controlador;
	
	/**
	 * numero actual de pagina del registro
	 */
	private int numPagina = 0;

	/**
	 * Creates new form VentanaRegistroEgresados
	 */
	public VentanaRegistroEgresados() {
		controlador = new ControladorVentanaRegistroEgresados();
		initComponents();
		this.getContentPane().setBackground(Color.orange);
		btnAtras.setVisible(false);
		btnGuardar.setVisible(false);
		cargarTipoDocumento();
		cargarTipoCorreo();
		cargarGenero();
		cargarTipoTelefono();
		cargarMaximoNivelEducacion();
		cargarMes();
		cargarSituacionLaboral();
		cargarTipoEmpresa();
		try {
			cargarComboFacultad();
			cargarComboAreaInteres();
			cargarComboSectorLaboral();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método para llenar el combo de programa
	 * 
	 * @param facultad,
	 *            facultad ala cual pertenecen los programas
	 * @throws Exception
	 */
	private void llenarComboPrograma(String facultad) throws Exception {
		cbPrograma.removeAllItems();
		List<Programa> programas = controlador.listarPrograma(facultad);
		cbPrograma.addItem("Seleccione un programa");
		for (Programa programa : programas) {
			cbPrograma.addItem(programa);
		}
	}

	/**
	 * Método para llenar el combo de facultad
	 * 
	 * @throws Exception
	 */
	private void cargarComboFacultad() throws Exception {

		List<Facultad> facultades = controlador.listarFacultad();
		cbFacultad.addItem("Seleccione una facultad");
		for (Facultad facultad : facultades) {
			cbFacultad.addItem(facultad);
			// cbFacultad.addItem(facultad.getCodigo()+" -
			// "+facultad.getNombre());
		}
	}

	/**
	 * Método para llenar el combo de area de interes
	 * 
	 * @throws Exception
	 */
	private void cargarComboAreaInteres() throws Exception {

		List<AreaInteres> areasInteres = controlador.listarAreasInteres();
		cbAreasInteres.addItem("Seleccione un area de interes");
		for (AreaInteres areaInteres : areasInteres) {
			cbAreasInteres.addItem(areaInteres);
		}
	}

	/**
	 * Método para llenar el combo de sector laboral
	 * 
	 * @throws Exception
	 */
	private void cargarComboSectorLaboral() throws Exception {
		// cbPais.removeAllItems();
		List<SectorLaboral> sectores = controlador.listarSectoresLaborales();
		cbSectorLaboral.addItem("Seleccione un sector laboral");
		for (SectorLaboral sector : sectores) {
			cbSectorLaboral.addItem(sector);
		}
	}

	public void cargarTipoDocumento() {
		for (TipoDocumentoEnum lista : TipoDocumentoEnum.values()) {
			cbTipoDocumento.addItem(lista);
		}
	}

	public void cargarTipoCorreo() {
		for (TipoCorreoEnum lista : TipoCorreoEnum.values()) {
			cbTipoCorreo.addItem(lista);
		}
	}

	public void cargarGenero() {
		for (GeneroEnum lista : GeneroEnum.values()) {
			cbGenero.addItem(lista);
		}
	}

	public void cargarTipoTelefono() {
		for (TipoTelefonoEnum lista : TipoTelefonoEnum.values()) {
			cbTipoTelefono.addItem(lista);
		}
	}

	public void cargarMaximoNivelEducacion() {
		for (MaximoNivelEduEnum lista : MaximoNivelEduEnum.values()) {
			cbMaximoNivelEducativo.addItem(lista);
		}
	}

	public void cargarMes() {
		for (MesEnum lista : MesEnum.values()) {
			cbMes.addItem(lista);
		}
	}

	public void cargarSituacionLaboral() {
		for (SituacionLaboralEnum lista : SituacionLaboralEnum.values()) {
			cbSituacionLaboral.addItem(lista);
		}
	}

	public void cargarTipoEmpresa() {
		for (TipoEmpresaEnum lista : TipoEmpresaEnum.values()) {
			cbTipoEmpresa.addItem(lista);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSiguiente = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLPasos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jTPEgresados = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPrimerApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSegundoApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfPrefijo = new javax.swing.JTextField();
        tfNumeroTel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfExtension = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbTipoDocumento = new javax.swing.JComboBox();
        tfNumeroDocumento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbTipoTelefono = new javax.swing.JComboBox();
        jRBFijo = new javax.swing.JRadioButton();
        jRBMovil = new javax.swing.JRadioButton();
        tfCorreo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbTipoCorreo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        cbMaximoNivelEducativo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cbPrograma = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbNivelAcademicoPrograma = new javax.swing.JTextField();
        jSFechaGrado = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        cbMes = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        tfNumeroDiploma = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbFacultad = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cbTipoEmpresa = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cbSectorLaboral = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jDFechaIngreso = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jDFechaSalida = new com.toedter.calendar.JDateChooser();
        cbSituacionLaboral = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cbAreasInteres = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha-derecha.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cientifico.png"))); // NOI18N

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disquete32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLPasos.setText("Paso 1/3");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo.png"))); // NOI18N
        jLabel2.setText("Registro de egresados");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha-izquierda.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jTPEgresados.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jLabel3.setText("Nombres*");

        jLabel4.setText("Primer Apellido*");

        jLabel5.setText("Segundo Apellido");

        jLabel6.setText("Telefono de Contacto*");

        jLabel7.setText("Prefijo");

        jLabel8.setText("Número*");

        jLabel9.setText("Extensión");

        jLabel10.setText("Tipo de Documento*");

        jLabel11.setText("Número*");

        jLabel12.setText("Genero*");

        jLabel13.setText("Tipo de Telefono");

        jRBFijo.setText("Fijo");

        jRBMovil.setText("Movil");

        jLabel14.setText("Correo Electrónico*");

        jLabel15.setText("Tipo de Correo*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfNombres, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfPrimerApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfPrefijo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(tfNumeroTel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(tfExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(tfSegundoApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cbGenero, 0, 180, Short.MAX_VALUE)
                    .addComponent(tfNumeroDocumento)
                    .addComponent(cbTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTipoTelefono, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRBFijo)
                            .addComponent(jRBMovil)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(tfCorreo)
                            .addComponent(jLabel15)
                            .addComponent(cbTipoCorreo, 0, 172, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel10))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(26, 26, 26))))
                                .addComponent(cbTipoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(26, 26, 26)))
                    .addComponent(cbGenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfNumeroTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBFijo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBMovil)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTPEgresados.addTab("1. Datos personales", new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombre-de-negocios-papel-de-datos-personales.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        jLabel17.setText("Facultad*");

        jLabel18.setText("Programa*");

        jLabel19.setText("Nivel Academico del Programa");

        jSFechaGrado.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2016, 1));

        jLabel20.setText("Fecha de Grado*");

        jLabel21.setText("Número del Diploma*");

        jLabel22.setText("Máximo Nivel Educativo*");

        cbFacultad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFacultadItemStateChanged(evt);
            }
        });

        jLabel26.setText("Mes*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(cbPrograma, 0, 180, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addComponent(cbNivelAcademicoPrograma)
                    .addComponent(cbFacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSFechaGrado))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel21)
                    .addComponent(tfNumeroDiploma)
                    .addComponent(jLabel22)
                    .addComponent(cbMaximoNivelEducativo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSFechaGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel20)
                        .addComponent(jLabel26)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroDiploma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNivelAcademicoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMaximoNivelEducativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTPEgresados.addTab("2. Educacion", new javax.swing.ImageIcon(getClass().getResource("/imagenes/birrete.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));

        jLabel24.setText("Tipo de Empresa*");

        jLabel25.setText("Sector Laboral*");

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));

        jLabel27.setText("Situacion LaboralActual*");

        jPanel5.setBackground(new java.awt.Color(255, 204, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Ingreso"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Salida"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel28.setText("Área de conocimiento interesada*");

        jLabel29.setText("Tipo de Empresa*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel28))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(cbSituacionLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel29)))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbAreasInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(cbSituacionLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(cbAreasInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cbTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSectorLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSectorLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPEgresados.addTab("3. Ocupacion actual", new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboral.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(129, 129, 129)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLPasos)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTPEgresados)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(74, 74, 74)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel16))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLPasos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTPEgresados, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSiguienteActionPerformed
		numPagina++;
		jLPasos.setText("Paso " + (numPagina + 1) + "/3");
		jTPEgresados.setSelectedIndex(numPagina);
		btnAtras.setVisible(true);
		if (numPagina == 2) {
			btnSiguiente.setVisible(false);
			btnGuardar.setVisible(true);
		}
	}// GEN-LAST:event_btnSiguienteActionPerformed

	private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtrasActionPerformed
		// TODO add your handling code here:
		numPagina--;
		jLPasos.setText("Paso " + (numPagina + 1) + "/3");
		jTPEgresados.setSelectedIndex(numPagina);
		btnSiguiente.setVisible(true);
		if (numPagina == 0) {
			btnAtras.setVisible(false);
		}
		btnGuardar.setVisible(false);
	}// GEN-LAST:event_btnAtrasActionPerformed

	private void cbFacultadItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbFacultadItemStateChanged
		// TODO add your handling code here:
		try {
			if (cbFacultad.getSelectedItem() == null) {
				return;
			}
			if (cbFacultad.getSelectedIndex() != 0) {
				Facultad facu = (Facultad) cbFacultad.getSelectedItem();
				// String datos[] = facu.split(" - ");
				llenarComboPrograma(facu.getCodigo());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}// GEN-LAST:event_cbFacultadItemStateChanged

	private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
		// TODO add your handling code here:
		try {
			// Validar que los campos no esten vacios
			if (tfCorreo.getText().isEmpty() || tfExtension.getText().isEmpty() || cbFacultad.getSelectedIndex() == 0
					|| cbPrograma.getSelectedIndex() == 0 || cbSectorLaboral.getSelectedIndex() == 0
					|| tfNombres.getText().isEmpty() || tfNumeroDiploma.getText().isEmpty()
					|| tfNumeroDocumento.getText().isEmpty() || tfNumeroTel.getText().isEmpty()
					|| tfPrefijo.getText().isEmpty() || tfCorreo.getText().isEmpty()
					|| tfPrimerApellido.getText().isEmpty() || tfSegundoApellido.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Debe completar todos los campos");

			} else {
				String documento = tfNumeroDocumento.getText();
				// Informacion Academica
				Facultad facultad = (Facultad) cbFacultad.getSelectedItem();
				Programa programa = (Programa) cbPrograma.getSelectedItem();
				String nivelAcademicoProg = cbNivelAcademicoPrograma.getText();
				int fecha = (Integer) jSFechaGrado.getValue();
				MesEnum mes = (MesEnum) cbMes.getSelectedItem();
				String numeroDiploma = tfNumeroDiploma.getText();
				MaximoNivelEduEnum maximoNivelEdu = (MaximoNivelEduEnum) cbMaximoNivelEducativo.getSelectedItem();

				InformacionAcademica infoAcademica = new InformacionAcademica(documento, facultad, programa,
						nivelAcademicoProg, fecha, mes, numeroDiploma, maximoNivelEdu);

				// Informacion Laboral
				SituacionLaboralEnum situcaionLaboral = (SituacionLaboralEnum) cbSituacionLaboral.getSelectedItem();
				TipoEmpresaEnum tipoEmpresa = (TipoEmpresaEnum) cbTipoEmpresa.getSelectedItem();
				SectorLaboral sectorLaboral = (SectorLaboral) cbSectorLaboral.getSelectedItem();
				Date fechaIngreso = jDFechaIngreso.getDate();
				Date fechaSalida = jDFechaSalida.getDate();
				InformacionLaboral infoLaboral = new InformacionLaboral(documento, situcaionLaboral, tipoEmpresa,
						sectorLaboral, "no se", fechaIngreso, fechaSalida, "no se");

				// Egresado
				String nombres = tfNombres.getText();
				String primerApellido = tfPrimerApellido.getText();
				TipoDocumentoEnum tipoDocumento = (TipoDocumentoEnum) cbTipoDocumento.getSelectedItem();
				String segundoApellido = tfSegundoApellido.getText();
				String telefono = tfPrefijo.getText() +" - "+ tfNumeroTel.getText() +" - "+ tfExtension.getText();
				GeneroEnum genero = (GeneroEnum) cbGenero.getSelectedItem();
				TipoTelefonoEnum tipoTelefono = (TipoTelefonoEnum) cbTipoTelefono.getSelectedItem();
				String correo = tfCorreo.getText();
				TipoCorreoEnum tipoCorreo = (TipoCorreoEnum) cbTipoCorreo.getSelectedItem();

				Egresado egresado = new Egresado(documento, programa, nombres, primerApellido, segundoApellido,
						tipoDocumento, genero, correo, tipoCorreo, telefono, tipoTelefono, infoAcademica, infoLaboral);

				// Area de Egresado
				AreaInteres area = (AreaInteres) cbAreasInteres.getSelectedItem();
				AreasEgresado areaEgresado = new AreasEgresado(egresado, area);

				infoAcademica.setEgresado(egresado);
				infoLaboral.setEgresado(egresado);
				controlador.crearEgresado(egresado);
				controlador.crearAreaEgresado(areaEgresado);
				controlador.crearInformacionLaboral(infoLaboral);
				controlador.crearInformacionAcademica(infoAcademica);

				JOptionPane.showMessageDialog(null, "Se creo correctamente el egresado");
			}
		} catch (ExcepcionNegocio e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}// GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox cbAreasInteres;
    private javax.swing.JComboBox cbFacultad;
    private javax.swing.JComboBox cbGenero;
    private javax.swing.JComboBox cbMaximoNivelEducativo;
    private javax.swing.JComboBox cbMes;
    private javax.swing.JTextField cbNivelAcademicoPrograma;
    private javax.swing.JComboBox cbPrograma;
    private javax.swing.JComboBox cbSectorLaboral;
    private javax.swing.JComboBox cbSituacionLaboral;
    private javax.swing.JComboBox cbTipoCorreo;
    private javax.swing.JComboBox cbTipoDocumento;
    private javax.swing.JComboBox cbTipoEmpresa;
    private javax.swing.JComboBox cbTipoTelefono;
    private com.toedter.calendar.JDateChooser jDFechaIngreso;
    private com.toedter.calendar.JDateChooser jDFechaSalida;
    private javax.swing.JLabel jLPasos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRBFijo;
    private javax.swing.JRadioButton jRBMovil;
    private javax.swing.JSpinner jSFechaGrado;
    private javax.swing.JTabbedPane jTPEgresados;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfExtension;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfNumeroDiploma;
    private javax.swing.JTextField tfNumeroDocumento;
    private javax.swing.JTextField tfNumeroTel;
    private javax.swing.JTextField tfPrefijo;
    private javax.swing.JTextField tfPrimerApellido;
    private javax.swing.JTextField tfSegundoApellido;
    // End of variables declaration//GEN-END:variables
}
