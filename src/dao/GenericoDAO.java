package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fabrica.Fabrica;
import entidades.Cidade;

public class GenericoDAO<T> {
	private EntityManager em;
	
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
	  public List<Cidade> listarCidade(Class c){
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
	

