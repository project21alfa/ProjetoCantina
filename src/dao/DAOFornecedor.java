package dao;

import entidades.Cliente;
import entidades.Fornecedor;
import entidades.Funcionario;
import fabrica.Fabrica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DAOFornecedor {
    private EntityManager em;
    private EntityTransaction t;
    
    public List<Fornecedor> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();
        List<Fornecedor> listFornecedor = new ArrayList<>();
        
        Query query = em.createQuery("from Fornecedor as Fornecedor where Fornecedor.nome like 'param%'");
        query.setParameter("param", nome);
        
        listFornecedor = query.getResultList();
        
        em.close();
        
        return listFornecedor;
        
    }
    
    public boolean alterar(Fornecedor pp, Class c, long id){
	      em = Fabrica.getFabrica().createEntityManager();
	      EntityTransaction t = em.getTransaction();
              Fornecedor p = new Fornecedor();
	      try{
	         t.begin();
	         p = em.find(new Fornecedor().getClass(), id);//buscando a entidade no banco
	         em.merge(pp);//alterar a entidade
	         t.commit();
	         return true; 
	      }catch(Exception e){
	        e.printStackTrace();
	        t.rollback();
	        return false;
	      }finally{
	         em.close();
	       }
	}
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Fornecedor f = em.find(new Fornecedor().getClass(), id);
           em.remove(f);
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
    
    public boolean alterar(Fornecedor f){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
            t.begin();
            f = em.find(f.getClass(), f.getId());
            em.merge(f);
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
    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> lista = new ArrayList<Fornecedor>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Fornecedor").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }
}
