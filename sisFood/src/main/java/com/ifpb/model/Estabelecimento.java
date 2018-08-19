
package com.ifpb.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author jonaspeuqno
 */
public class Estabelecimento extends Endereco {
   private int id;
   private String nome;   
   private String foto;
   private String descricao;
   private String fone;   
   private String horaAbertura;
   private String horaFechamento;
   private String tipo;
   private double nota;
   private String userAdd;


    public Estabelecimento() {
    }
   
   
   public Estabelecimento(String nome, String foto, String descricao, String fone,
           String horaAbertura, String horaFechamento, String tipo, double nota, String rua, String cidade, int numero, String cep, String estado) {
       super(rua, cidade, numero, cep, estado);
       this.nome = nome;
       this.foto = foto;
       this.descricao = descricao;
       this.fone = fone;
       this.horaAbertura = horaAbertura;
       this.horaFechamento = horaFechamento;
       this.tipo = tipo;
       this.nota = nota;
   }

    public Estabelecimento(int id, String nome, String foto, String descricao, String fone,
            String horaAbertura, String horaFechamento, String tipo, double nota, String userAdd, String rua, String cidade, int numero, String cep, String estado) {
        super(rua, cidade, numero, cep, estado);
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.descricao = descricao;
        this.fone = fone;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.tipo = tipo;
        this.nota = nota;
        this.userAdd = userAdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.foto);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + Objects.hashCode(this.fone);
        hash = 59 * hash + Objects.hashCode(this.horaAbertura);
        hash = 59 * hash + Objects.hashCode(this.horaFechamento);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.nota) ^ (Double.doubleToLongBits(this.nota) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.userAdd);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estabelecimento other = (Estabelecimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.fone, other.fone)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.userAdd, other.userAdd)) {
            return false;
        }
        if (!Objects.equals(this.horaAbertura, other.horaAbertura)) {
            return false;
        }
        if (!Objects.equals(this.horaFechamento, other.horaFechamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "id=" + id + ", nome=" + nome + ", foto=" + foto + ", descricao=" + descricao + ", fone=" + fone + ", horaAbertura=" + horaAbertura + ", horaFechamento=" + horaFechamento + ", tipo=" + tipo + ", nota=" + nota + ", userAdd=" + userAdd + '}';
    }
    
    
  
}
