package dao;

import entidades.Cliente;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DAOCliente {
    private EntityManager em;
    private EntityTransaction t;
    
    public List<Cliente> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();
        List<Cliente> listClientes = new ArrayList<>();
        
        Query query = em.createQuery("from Cliente as Cliente where Cliente.nome like 'param%'");
        query.setParameter("param", nome);
        
        listClientes = query.getResultList();
        
        em.close();
        
        return listClientes;
        
    }
    
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Cliente c = em.find(new Cliente().getClass(), id);
           em.remove(c);
           t.commit();
           return true;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            t.rollback();
            return false;
        }
        finally{
            em.close();
        }
    }
}
