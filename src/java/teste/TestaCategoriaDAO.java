/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import mvc.dao.CategoriaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import mvc.modelo.Categoria;
import util.JPAUtil;

/**
 *
 * @author Ada
 */
public class TestaCategoriaDAO {
    public static void main(String[] args) {
         EntityManager manager = JPAUtil.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        //inserir
        try {
            Categoria a1 = new Categoria();
            a1.setDescricao("Ada");
            Categoria a2 = new Categoria();
            Categoria a3 = new Categoria();
            a3.setDescricao("Ada");
            Categoria a4 = new Categoria();

            categoriaDAO.addCategoria(a1);
            categoriaDAO.addCategoria(a2);
            categoriaDAO.addCategoria(a3);
            categoriaDAO.addCategoria(a4);
            System.out.println("foi");  
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
        
        //excluir
        /*try {
            Categoria u1 = new Categoria();
            u1.setCodigo(3l);
            categoriaDAO.excluiCategoria(u1);
            System.out.println("foi");
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }*/
        
        //alterar
        /*try {
            Categoria u1 = new Categoria();
            u1.setCodigo(2l);
            u1.setDescricao("alterado");
            categoriaDAO.alteraCategoria(u1);
            System.out.println("foi");
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
        
        //find
        try {
            Categoria u1 = new Categoria();
            List<Categoria> lista = new ArrayList<>();

            u1.setCodigo(4l);
            u1.setDescricao("ada");
            lista = categoriaDAO.findCategoria(u1);
            System.out.println(lista);
            ///System.out.println("email: " + u1.getEmail() + "  senha:" + u1.getSenha() );
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }*/
    }
}
