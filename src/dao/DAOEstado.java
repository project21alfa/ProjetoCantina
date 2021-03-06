/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Categoria;
import entidades.Cidade;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fabrica.Fabrica;

import entidades.Estado;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author santy
 */
public class DAOEstado {

    private EntityManager em;
    private EntityTransaction t;

    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Estado f = em.find(new Estado().getClass(), id);
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
    public List<Estado> listarEstado() {
        List<Estado> lista = new ArrayList<Estado>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Estado").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }
     public Estado findByNomeE(String nome) {
		  em = Fabrica.getFabrica().createEntityManager();
	        Query query = em.createQuery("from Estado as estado where estado.nome = :param");
	        query.setParameter("param", nome);
	        System.out.println(query.getResultList().size());
	       return (Estado) query.getResultList().get(0);
	    }

   
}
