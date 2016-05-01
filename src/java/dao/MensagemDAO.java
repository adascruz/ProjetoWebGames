package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Mensagem;
import util.JPAUtil;

public class MensagemDAO {
    
    public void addMensagem(Mensagem mensagem){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(mensagem);
        manager.getTransaction().commit();
        manager.close();
    }
    
  /*  
    public void alteraCategoria(Categoria mensagem){
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        manager.merge(mensagem);
        manager.getTransaction().commit();
        manager.close();
    }*/
    
    public List<Mensagem> listaMensagens(Mensagem mensagem){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Mensagem> mensagens = null;
        
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Mensagem> cq = cb.createQuery(Mensagem.class);
            Root<Mensagem> msg = cq.from(Mensagem.class);
            cq.select(msg);
            
            Predicate predicate = cb.like(msg.<String>get("mensagem"), "%"+mensagem.getMensagem()+"%");
            cq.where(predicate);
            
            TypedQuery<Mensagem> query = manager.createQuery(cq);
            mensagens = query.getResultList();
        
        }
        catch(TypeNotPresentException ex){
            String consulta = "select m from Mensagem m ";
            
            TypedQuery<Mensagem> query = manager.createQuery(consulta, Mensagem.class);
            
            mensagens = query.getResultList();
        }
        
        manager.close();
        
        return mensagens;
    }
    /*
    public void excluiCategoria(Categoria mensagem){
        EntityManager manager = JPAUtil.getEntityManager();
        
        Categoria categoriaAlterada;
        manager.getTransaction().begin();
        
        categoriaAlterada = manager.find(Categoria.class, mensagem.getCodigo());        
        manager.remove(categoriaAlterada);
        
        manager.getTransaction().commit();
        manager.close();
    }*/
     
    public Mensagem findMensagemByCodigo(Mensagem mensagem){
        Mensagem mensagemRetorno;
        
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        mensagemRetorno = manager.find(Mensagem.class, mensagem.getCodigo());
        manager.close();
        
        return mensagemRetorno;
    }
    
    public List<Mensagem> findMensagem(Mensagem mensagem){
        List<Mensagem> mensagens;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Mensagem> query = manager.createQuery("SELECT m FROM Mensagem m WHERE m.mensagem LIKE :msg ", Mensagem.class);
        query.setParameter("msg", mensagem.getMensagem()+ "%");
        try {
            mensagens = query.getResultList();
        } catch (NoResultException e) {
            
            mensagens = null;
        }
        
        return mensagens;
    }
    
}