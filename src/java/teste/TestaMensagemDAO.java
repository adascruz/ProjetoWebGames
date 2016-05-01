/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.MensagemDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Mensagem;

/**
 *
 * @author Ada
 */
public class TestaMensagemDAO {
    public static void main(String[] args) {
        
        MensagemDAO mensagemDAO = new MensagemDAO();
        //inserir
        try {
            Mensagem a1 = new Mensagem();
            a1.setMensagem("Ada");
            Mensagem a2 = new Mensagem();
            Mensagem a3 = new Mensagem();
            a3.setMensagem("Ada");
            Mensagem a4 = new Mensagem();

            mensagemDAO.addMensagem(a1);
            mensagemDAO.addMensagem(a2);
            mensagemDAO.addMensagem(a3);
            mensagemDAO.addMensagem(a4);
            System.out.println("foi");  
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
        
     
        
        //find
        try {
            Mensagem u1 = new Mensagem();
            List<Mensagem> lista = new ArrayList<>();

            u1.setCodigo(4l);
            u1.setMensagem("ada");
            lista = mensagemDAO.findMensagem(u1);
            System.out.println(lista);
            ///System.out.println("email: " + u1.getEmail() + "  senha:" + u1.getSenha() );
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
    }
}
