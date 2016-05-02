/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author Ada
 */
@Entity
public class Curriculum implements Serializable {
    
    @Id
    @GeneratedValue
    private Long codigo;
    @Lob
    private byte[] curriculum;

    public Curriculum() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    

    public byte[] getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(byte[] curriculum) {
        this.curriculum = curriculum;
    }
    
    
}