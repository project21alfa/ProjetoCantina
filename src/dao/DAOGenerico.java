
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fabrica.Fabrica;
import entidades.Cidade;
import java.util.ArrayList;

public class DAOGenerico<T> {
	private EntityManager em;
	
	 public T findByNomeF(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Fornecedor as fornecedor where fornecedor.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (T) query.getResultList().get(0);
	    }
	  public T findByNomeC(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Cidade as cidade where cidade.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (T) query.getResultList().get(0);
	    }
	  public T findByNomeE(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Estado as estado where estado.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (T) query.getResultList().get(0);
	    }
	public T salvar(T entidade ){
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
	public T consultar(Class c, String nome){
		em = Fabrica.getFabrica().createEntityManager();
		try{
			return (T) em.find(c,nome);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	  public T findByNome(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Pessoa as pessoa where pessoa.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (T) query.getResultList().get(0);
	    }
	 
	  public List<Cidade> listarCidade(){
		  	List<Cidade> lista = new ArrayList<Cidade>();
			em = Fabrica.getFabrica().createEntityManager();
			try{
				lista = em.createQuery("from Cidade").getResultList();
				return lista;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				em.close();
			}
			
		}
	
	public List<T> listar(Class c){
		em = Fabrica.getFabrica().createEntityManager();
		try{
			return em.createQuery("from"+c.getSimpleName()).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		
	}
	public boolean excluir(Class c, long id) {
		em = Fabrica.getFabrica().createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			T entidade =(T) em.find(c, id);			
			em.remove(entidade);
			t.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}finally {
			em.close();
		}
	}
	public boolean alterar(T entidade, Class c, long id){
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
	}
	}
	

