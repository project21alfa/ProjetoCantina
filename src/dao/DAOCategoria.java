/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fabrica.Fabrica;

import entidades.Categoria;
import entidades.Fornecedor;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;


/**
 *
 * @author santy
 */
public class DAOCategoria {

    private EntityManager em;
    private EntityTransaction t;
    
    public boolean excluir(long id){
        em = Fabrica.getFabrica().createEntityManager();
        t = em.getTransaction();
        
        try{
           t.begin();
           Categoria f = em.find(new Categoria().getClass(), id);
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
    public List<Categoria> listarCategoria() {
        List<Categoria> lista = new ArrayList<Categoria>();
        em = Fabrica.getFabrica().createEntityManager();
        try {
            lista = em.createQuery("from Categoria").getResultList();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }
}
