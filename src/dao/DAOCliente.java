package dao;

import entidades.Cliente;
import entidades.Estado;
import entidades.Funcionario;
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
        
        Query query = em.createQuery("from Cliente as Cliente where Cliente.nome like '"+nome+"'");
        listClientes = query.getResultList();
        
        em.close();
        
        return listClientes;
        
    }
     public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           em.remove(t);
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
    /*public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<Cliente>();
        EntityManager em = Fabrica.getFabrica().createEntityManager();
	EntityTransaction t = em.getTransaction();
        try {
            lista = em.createQuery("from Cliente").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }*/
     public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<Cliente>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Cliente").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }

    public Cliente alterar(Cliente clii){
        EntityManager em = Fabrica.getFabrica().createEntityManager();
	EntityTransaction t = em.getTransaction();
        Cliente cli = new Cliente();
        cli = clii;
        try {
             t.begin();
                 em.merge(cli);//alterar a entidade
	         t.commit();
	          
            
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        return cli;
    }

    public Estado alterar(Estado estadoAlterar) {
		EntityManager em = Fabrica.getFabrica().createEntityManager();
		EntityTransaction t = em.getTransaction();
		Estado estadoBanco = null;
		try {
			estadoBanco = em.find(Estado.class, estadoAlterar.getId());
			t.begin();
			estadoBanco.setNome(estadoAlterar.getNome());
			estadoBanco.setSigla(estadoAlterar.getSigla());
			em.merge(estadoBanco);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return estadoAlterar;
	}
}
