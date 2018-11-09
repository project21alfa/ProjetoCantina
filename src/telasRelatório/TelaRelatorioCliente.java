
package telasRelatório;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class TelaRelatorioCliente extends javax.swing.JDialog {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public TelaRelatorioCliente() {

		super(new JFrame(), "Relatório Cliente", true);
                setSize(1024, 768);

		try {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sistemacantina", "root", "mysql");
			
		Statement st = conn.createStatement();
			
		ResultSet rs = st.executeQuery("SELECT * FROM Cliente");
		
		JRResultSetDataSource ds = new JRResultSetDataSource(rs);
		String enderecoProjeto = System.getProperty("user.dir");
			
		JasperReport jr = JasperCompileManager.compileReport(enderecoProjeto+"/Relatórios/relatorioCliente.jrxml");

		JasperPrint jp = JasperFillManager.fillReport(jr, null,ds);
		JasperViewer jv = new JasperViewer(jp);

		getContentPane().add(jv.getContentPane());

		} catch (Exception e) {
			e.printStackTrace();
		}
        }	
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

