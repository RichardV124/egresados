/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.ingesoft.egresados.vista.gui;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.AreaInteres;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.OfertaLaboral;
import co.edu.eam.ingesoft.desarrollo.egresados.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.egresados.vista.controladores.ControladorVentanaOfertasAbiertas;

/**
 *
 * @author 414pc04
 */
public class VentanaOfertasAbiertas extends javax.swing.JFrame {

	private ControladorVentanaOfertasAbiertas controlador;

	/**
	 * Creates new form VentanaOfertasAbiertas
	 */
	public VentanaOfertasAbiertas() {
		initComponents();
		try {
			this.getContentPane().setBackground(Color.GREEN);
			controlador = new ControladorVentanaOfertasAbiertas();
			llenarComboPrograma();
			llenarComboAreas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * M�todo para llenar el combo de programas
	 * 
	 * @throws Exception
	 */
	private void llenarComboPrograma() throws Exception {
		cbPrograma.removeAllItems();
		List<Programa> lista = controlador.listarProgramas();
//		cbPrograma.addItem("Seleccione un programa");
		for (Programa programa : lista) {
			cbPrograma.addItem(programa);
		}
	}

	 /**
		 * M�todo para llenar el combo de area de interes
		 * 
		 * @throws Exception
		 */
		private void llenarComboAreas() throws Exception {
			cbArea.removeAllItems();
			List<AreaInteres> lista = controlador.listarArea();
			cbArea.addItem("Seleccione un area de interes");
			for (AreaInteres area : lista) {
				cbArea.addItem(area);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbArea = new javax.swing.JComboBox();
        cbPrograma = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPPrimero = new javax.swing.JPanel();
        jPSegundo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dinero.png"))); // NOI18N
        jLabel1.setText("Ofertas Abiertas");

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Ofertas"));

        jLabel10.setText("Area de Conociemiento*");

        cbArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAreaItemStateChanged(evt);
            }
        });

        cbPrograma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProgramaItemStateChanged(evt);
            }
        });

        jLabel12.setText("Programa Academico*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPPrimero.setBackground(new java.awt.Color(0, 153, 0));
        jPPrimero.setBorder(javax.swing.BorderFactory.createTitledBorder("Gr�fica de Porcentajes"));

        javax.swing.GroupLayout jPPrimeroLayout = new javax.swing.GroupLayout(jPPrimero);
        jPPrimero.setLayout(jPPrimeroLayout);
        jPPrimeroLayout.setHorizontalGroup(
            jPPrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPPrimeroLayout.setVerticalGroup(
            jPPrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)
                    .addComponent(jPSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(206, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(19, 19, 19)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void cbAreaItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbAreaItemStateChanged
		// TODO add your handling code here:
	}// GEN-LAST:event_cbAreaItemStateChanged

	/**
	 * Grafica de barras
	 * 
	 * @param evt
	 */
	private void cbProgramaItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbProgramaItemStateChanged
		// TODO add your handling code here:
		
		ChartPanel panel;
		try {
			Programa programa = (Programa) cbPrograma.getSelectedItem();
			
			List<OfertaLaboral> listaOfertaLab = controlador.listarOfertas(programa);

			
			
			int contador = 0;
			AreaInteres areaAnterior = null;
			DefaultCategoryDataset ds = new DefaultCategoryDataset();

			for (int i = 0; i < listaOfertaLab.size(); i++) {
				jPSegundo.removeAll();
				// Validacion de oferta
				if (listaOfertaLab.get(i).isCerrarOferta() == false) {
					areaAnterior = listaOfertaLab.get(i).getAreaInteres();
					for (int j = 0; j < listaOfertaLab.size(); j++) {
						if (listaOfertaLab.get(j).getAreaInteres() == areaAnterior) {
							contador++;
						}
					}
					ds.addValue(contador, listaOfertaLab.get(i).getAreaInteres().getNombre(),
							listaOfertaLab.get(i).getAreaInteres().getNombre());
					contador = 0;
				}
			}

			JFreeChart jf = ChartFactory.createBarChart3D("Reporte de ofertas abiertas", "Nombre de las ofertas",
					"Numero de vacantes", ds, PlotOrientation.VERTICAL, true, true, true);

			panel = new ChartPanel(jf);
			panel.setBounds(20, 20, 230, 230);

			jPSegundo.add(panel);

		} catch (Exception e) {
			e.printStackTrace();
		}            
		
	}// GEN-LAST:event_cbProgramaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbArea;
    private javax.swing.JComboBox cbPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPPrimero;
    private javax.swing.JPanel jPSegundo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
