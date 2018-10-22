
package tela;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class RelFuncionario extends JDialog{
    public RelFuncionario(){
      super(new JFrame(), "Relatório Teste", true);
        setSize(1024, 768);
		try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Cantina", "root", "mysql");

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Estado");
                    JRResultSetDataSource ds = new JRResultSetDataSource(rs);
                    String enderecoProjeto = System.getProperty("user.dir");
                    JasperReport jr = JasperCompileManager.compileReport(enderecoProjeto+"/relatorioEstado.jrxml");
                    JasperPrint jp = JasperFillManager.fillReport("", null,ds);
                    JasperViewer jv = new JasperViewer(jp);

			getContentPane().add(jv.getContentPane());

		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
        }

	public static void main(String[] main) {
		new RelFuncionario();
	}
        
        
        
        
    }
    
    
    
    
}
