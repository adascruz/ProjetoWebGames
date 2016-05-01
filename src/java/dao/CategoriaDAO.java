package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Categoria;
import util.JPAUtil;

public class CategoriaDAO {
    
    public void addCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    
    public void alteraCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        manager.merge(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Categoria> listaCategorias(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Categoria> categorias = null;
        
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Categoria> cq = cb.createQuery(Categoria.class);
            Root<Categoria> cli = cq.from(Categoria.class);
            cq.select(cli);
            
            Predicate predicate = cb.like(cli.<String>get("descricao"), "%"+categoria.getDescricao()+"%");
            cq.where(predicate);
            
            TypedQuery<Categoria> query = manager.createQuery(cq);
            categorias = query.getResultList();
        
        }
        catch(TypeNotPresentException ex){
            String consulta = "select c from Categoria c ";
            
            TypedQuery<Categoria> query = manager.createQuery(consulta, Categoria.class);
            
            categorias = query.getResultList();
        }
        
        manager.close();
        
        return categorias;
    }
    
    public void excluiCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        
        Categoria categoriaAlterada;
        manager.getTransaction().begin();
        
        categoriaAlterada = manager.find(Categoria.class, categoria.getCodigo());        
        manager.remove(categoriaAlterada);
        
        manager.getTransaction().commit();
        manager.close();
    }
     
    public Categoria findCategoriaByCodigo(Categoria categoria){
        Categoria categoriaRetorno;
        
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        categoriaRetorno = manager.find(Categoria.class, categoria.getCodigo());
        manager.close();
        
        return categoriaRetorno;
    }
    
    public List<Categoria> findCategoria(Categoria categoria){
        List<Categoria> categorias;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Categoria> query = manager.createQuery("SELECT c FROM Categoria c WHERE c.descricao LIKE :descricao ", Categoria.class);
        query.setParameter("descricao", categoria.getDescricao()+ "%");
        try {
            categorias = query.getResultList();
        } catch (NoResultException e) {
            categorias = null;
        }
        
        return categorias;
    }
    
}