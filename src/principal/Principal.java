
package principal;

import dao.DAOCidade;
import dao.DAOGenerico;
import entidades.Cidade;
import entidades.Estado;
public class Principal {

    public static void main(String[] args) {
        
       TelaPrincipal telaP = new TelaPrincipal();
       telaP.setVisible(true);
       
       TelaLogin telaL = new TelaLogin(null, true);
       telaL.setVisible(true);
       
       telaP.setFuncionario(telaL.getFuncionario());
       
    }
    
}
