package dao;

import entidades.Cidade;
import entidades.Estado;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOCidade {
    EntityManager em;    
    
    public List<Cidade> buscarCidade(Estado est){
        List<Cidade> listCidade = new ArrayList<>();
        em = Fabrica.getFabrica().createEntityManager();
        
        try{
            listCidade = em.createQuery("from cidade where id_estado = " + est.getId() + "order by nome").getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            em.close();
        }
        
        
        return listCidade;  
    }
    
}
