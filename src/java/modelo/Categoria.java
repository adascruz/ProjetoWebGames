package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue
    private Long codigo;
    private String descricao;
    
    @OneToMany  (mappedBy = "categoria")
    private List<Produto> produtos;
    
    public Categoria() {
        produtos= new ArrayList<>();
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria(String descricao, List<Produto> produtos) {
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    
    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return descricao;
    }
}