/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Ada
 */
public class TestaClienteDAO {
    public static void main(String[] args) {
        
        ClienteDAO clienteDAO = new ClienteDAO();
        //inserir
        try {
            Cliente a1 = new Cliente();
            a1.setNome("Ada");
            Cliente a2 = new Cliente();
            Cliente a3 = new Cliente();
            a3.setNome("Ada");
            Cliente a4 = new Cliente();

            clienteDAO.addCliente(a1);
            clienteDAO.addCliente(a2);
            clienteDAO.addCliente(a3);
            clienteDAO.addCliente(a4);
            System.out.println("foi");  
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
        
        //excluir
        /*try {
            Cliente u1 = new Cliente();
            u1.setCodigo(3l);
            clienteDAO.excluiCliente(u1);
            System.out.println("foi");
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }*/
        
        //alterar
        /*try {
            Cliente u1 = new Cliente();
            u1.setCodigo(4l);
            u1.setLogin("alterado");
            clienteDAO.alteraCliente(u1);
            System.out.println("foi");
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }*/
        try {
            Cliente u1 = new Cliente();
            List<Cliente> lista = new ArrayList<>();

            u1.setCodigo(4l);
            u1.setNome("ada");
            lista = clienteDAO.findClientes(u1);
            System.out.println(lista);
            ///System.out.println("email: " + u1.getEmail() + "  senha:" + u1.getSenha() );
        } 
        catch (Exception e) {
            System.out.println("nao foi " + e.getMessage());  
        }
    }
}
