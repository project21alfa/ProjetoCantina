
package principal;

import dao.DAOCidade;
import tela.TelaPrincipal;
import dao.DAOGenerico;
import entidades.Cidade;
import entidades.Estado;
public class Principal {

    public static void main(String[] args) {
        
       // TelaPrincipal telaP = new TelaPrincipal();
       // telaP.setVisible(true);
       
        Estado est = new Estado();
        est.setNome("SÃO PAULO");
        est.setSigla("SP");
        
        DAOGenerico<Estado> dao = new DAOGenerico<>();
        dao.salvar(est);
        
    }
    
}
