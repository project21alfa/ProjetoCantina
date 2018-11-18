package dao;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Fornecedor;
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
    public Produto salvar(Produto entidade ){
		em = Fabrica.getFabrica().createEntityManager();
		EntityTransaction t = em.getTransaction();
		try{
			t.begin();
			em.persist(entidade);
			t.commit();
		}catch(Exception e){
			t.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return entidade;
	}
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Produto f = em.find(new Produto().getClass(), id);
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
    public List<Produto> listByNameSearch(String nome){
        em = Fabrica.getFabrica().createEntityManager();
        List<Produto> listProduto = new ArrayList<>();
        
        Query query = em.createQuery("from Produto as Produto where Produto.nome like 'param%'");
        query.setParameter("param", nome);
        
        listProduto = query.getResultList();
        
        em.close();
        
        return listProduto;
        
    }
   /* public boolean alterar(T entidade, Class c, long id){
	      em = Fabrica.getFabrica().createEntityManager();
	      EntityTransaction t = em.getTransaction();
	      try{
	         t.begin();
	         entidade = (T) em.find(c, id);//buscando a entidade no banco
	         em.merge(entidade);//alterar a entidade
	         t.commit();
	         return true; 
	      }catch(Exception e){
	        e.printStackTrace();
	        t.rollback();
	        return false;
	      }finally{
	         em.close();
	       }
	}*/
    
    public boolean alterar(Produto p,long id){
	      em = Fabrica.getFabrica().createEntityManager();
	      EntityTransaction t = em.getTransaction();
	      try{
	         t.begin();
	         p = em.find(new Produto().getClass(), id);//buscando a entidade no banco
	         em.merge(p);//alterar a entidade
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
    
      public Categoria findByNomeC(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Categoria as categoria where categoria.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (Categoria) query.getResultList().get(0);
	    }
}
