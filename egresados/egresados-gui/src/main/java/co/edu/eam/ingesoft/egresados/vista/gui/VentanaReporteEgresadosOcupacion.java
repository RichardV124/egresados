/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.ingesoft.egresados.vista.gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.InformacionLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.enumeraciones.SituacionLaboralEnum;
import co.edu.eam.ingesoft.egresados.vista.controladores.ControladorReporteEgresadosOcupacion;

/**
 *
 * @author 414pc04
 */
public class VentanaReporteEgresadosOcupacion extends javax.swing.JFrame {

	/**
	 * controlador de la ventana donde se encuentra las operaciones logicas de reporte egresados ocupacion
	 */
	private ControladorReporteEgresadosOcupacion controlador;

	/**
	 * Creates new form VentanaReporteEgresadosOcupacion
	 */
	public VentanaReporteEgresadosOcupacion() {
		
		try {
		initComponents();
		this.getContentPane().setBackground(Color.GREEN);
		controlador = new ControladorReporteEgresadosOcupacion();
			llenarComboPrograma();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		global();
	}

	/**
	 * M�todo para llenar el combo de programa
	 * 
	 * @param facultad,
	 *            facultad ala cual pertenecen los programas
	 * @throws Exception
	 */
	private void llenarComboPrograma() throws Exception {
		cbPrograma.removeAllItems();
		List<Programa> programas = controlador.listarProgamas();
		cbPrograma.addItem("Seleccione un programa");
		for (Programa programa : programas) {
			cbPrograma.addItem(programa);
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

        jLabel1 = new javax.swing.JLabel();
        jPPrimero = new javax.swing.JPanel();
        jPSegundo = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbPrograma = new javax.swing.JComboBox();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/presentacion.png"))); // NOI18N
        jLabel1.setText("Reporte de empleados por Ocupacion");

        jPPrimero.setBackground(new java.awt.Color(0, 153, 0));
        jPPrimero.setBorder(javax.swing.BorderFactory.createTitledBorder("Gr�fica de Porcentajes"));

        javax.swing.GroupLayout jPPrimeroLayout = new javax.swing.GroupLayout(jPPrimero);
        jPPrimero.setLayout(jPPrimeroLayout);
        jPPrimeroLayout.setHorizontalGroup(
            jPPrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        jPPrimeroLayout.setVerticalGroup(
            jPPrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPSegundo.setBackground(new java.awt.Color(0, 153, 0));
        jPSegundo.setBorder(javax.swing.BorderFactory.createTitledBorder("Gr�fica de Porcentajes"));

        javax.swing.GroupLayout jPSegundoLayout = new javax.swing.GroupLayout(jPSegundo);
        jPSegundo.setLayout(jPSegundoLayout);
        jPSegundoLayout.setHorizontalGroup(
            jPSegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPSegundoLayout.setVerticalGroup(
            jPSegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        jLabel18.setText("Programa*");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(cbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(btnGenerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGenerarActionPerformed
		// TODO add your handling code here:
System.out.println((Programa)cbPrograma.getSelectedItem());
		ChartPanel panel;
		try {
			Programa p = (Programa) cbPrograma.getSelectedItem();
			List<InformacionLaboral> listaInfoLab = controlador.listarInformacionLaboralPorPrograma(p);
			jPPrimero.removeAll();
			jPSegundo.removeAll();
			double empleado = 0;
			double desempleado = 0;
			double independiente = 0;
			double empresario = 0;
			System.out.println((Programa)cbPrograma.getSelectedItem());
			int contadorEmpleado = 0;
			int contadordDesempleado = 0;
			int contadorIndependiente = 0;
			int contadorEmpresario = 0;

			for (int i = 0; i < listaInfoLab.size(); i++) {
				if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.EMPLEADO)) {
					contadorEmpleado++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.DESEMPLEADO)) {
					contadordDesempleado++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.INDEPENDIENTE)) {
					contadorIndependiente++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.EMPRESARIO)) {
					contadorEmpresario++;
				} else {
					JOptionPane.showMessageDialog(null, "No hay empleados registrados");
				}

				empleado = (contadorEmpleado * 100) / listaInfoLab.size();
				desempleado = (contadordDesempleado * 100) / listaInfoLab.size();
				independiente = (contadorIndependiente * 100) / listaInfoLab.size();
				empresario = (contadorEmpresario * 100) / listaInfoLab.size();
			}
			DefaultPieDataset ds = new DefaultPieDataset();
			ds.setValue("Empleado: " + empleado + "%", empleado);
			ds.setValue("Desempleado: " + desempleado + "%", desempleado);
			ds.setValue("Independiente: " + independiente + "%", independiente);
			ds.setValue("Empresario: " + empresario + "%", empresario);

			JFreeChart jf = ChartFactory.createPieChart3D("Reporte de egresados por tipo de ocupaci�n", ds, true, true,
					true);

			panel = new ChartPanel(jf);
			panel.setBounds(20, 50, 280, 280);

			jPSegundo.removeAll();
			jPSegundo.add(panel);
			jPSegundo.updateUI();

		} catch (Exception e) {
e.printStackTrace();
		}

	}// GEN-LAST:event_btnGenerarActionPerformed

	/**
	 * metodo para cargar la grafica de reporte
	 */
	public void global(){
		ChartPanel panel;
		try {
			List<InformacionLaboral> listaInfoLab = controlador.listarInformacionLaboral();
			jPPrimero.removeAll();
			jPSegundo.removeAll();
			double empleado = 0;
			double desempleado = 0;
			double independiente = 0;
			double empresario = 0;

			int contadorEmpleado = 0;
			int contadordDesempleado = 0;
			int contadorIndependiente = 0;
			int contadorEmpresario = 0;

			for (int i = 0; i < listaInfoLab.size(); i++) {
				if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.EMPLEADO)) {
					contadorEmpleado++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.DESEMPLEADO)) {
					contadordDesempleado++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.INDEPENDIENTE)) {
					contadorIndependiente++;
				} else if (listaInfoLab.get(i).getSituacionAct().equals(SituacionLaboralEnum.EMPRESARIO)) {
					contadorEmpresario++;
				} else {
					JOptionPane.showMessageDialog(null, "No hay empleados registrados");
				}

				empleado = (contadorEmpleado * 100) / listaInfoLab.size();
				desempleado = (contadordDesempleado * 100) / listaInfoLab.size();
				independiente = (contadorIndependiente * 100) / listaInfoLab.size();
				empresario = (contadorEmpresario * 100) / listaInfoLab.size();
			}
			DefaultPieDataset ds = new DefaultPieDataset();
			ds.setValue("Empleado: " + empleado + "%", empleado);
			ds.setValue("Desempleado: " + desempleado + "%", desempleado);
			ds.setValue("Independiente: " + independiente + "%", independiente);
			ds.setValue("Empresario: " + empresario + "%", empresario);

			JFreeChart jf = ChartFactory.createPieChart3D("Reporte de egresados por tipo de ocupaci�n", ds, true, true,
					true);

			panel = new ChartPanel(jf);
			panel.setBounds(20, 50, 280, 280);

			jPPrimero.add(panel);
		} catch (Exception e) {

		}
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox cbPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPPrimero;
    private javax.swing.JPanel jPSegundo;
    // End of variables declaration//GEN-END:variables
}
