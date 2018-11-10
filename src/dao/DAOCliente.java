package dao;

import entidades.Cliente;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DAOCliente {
    private EntityManager em;
    private EntityTransaction t;
    
    private List<Cliente> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();
        List<Cliente> listClientes = new ArrayList<>();
        
        Query query = em.createQuery("from Cliente as Cliente where Cliente.nome like 'param%'");
        query.setParameter("param", nome);
        
        listClientes = query.getResultList();
        
        em.close();
        
        return listClientes;
        
    }
}
