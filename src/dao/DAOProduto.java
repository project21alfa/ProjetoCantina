package dao;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Produto;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DAOProduto {
    private EntityManager em;
    private EntityTransaction t;
    public List<Produto> listarPrduto() {
        List<Produto> lista = new ArrayList<Produto>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Produto").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }
    public List<Produto> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();
        List<Produto> listProduto = new ArrayList<>();
        
        Query query = em.createQuery("from Produto as Produto where Produto.nome like 'param%'");
        query.setParameter("param", nome);
        
        listProduto = query.getResultList();
        
        em.close();
        
        return listProduto;
        
    }
    
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Produto p = em.find(new Produto().getClass(), id);
           em.remove(p);
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
    
    public boolean alterar(Produto p){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
            t.begin();
            p = em.find(p.getClass(), p.getId());
            em.merge(p);
            t.commit();
            return true;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            return false;
        }
        finally{
            em.close();
        }
    }
      public Categoria findByNomeC(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Categoria as categoria where categoria.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (Categoria) query.getResultList().get(0);
	    }
}
