/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import mvc.dao.CategoriaDAO;
import mvc.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ada
 */
@Transactional
@Controller
public class CategoriaController {
    @Autowired
    private  CategoriaDAO categoriaDAO;

    
    @RequestMapping("/formAdicionarCategoria")
    public String form(){
        return "categoria/formularioAdicionarCategoria";
    }
    
    @RequestMapping("/adicionarCategoria")
    public String adicionar(Categoria categoria){
        categoriaDAO.addCategoria(categoria);
        return "categoria/categoriaAdicionada";
    }
    
    
    
}
