
package com.ifpb.model;

import java.util.Objects;

/**
 *
 * @author jonaspeuqno
 */
public abstract class Endereco {
    
    private String rua;
    private String cidade;
    private int numero;
    private String cep;
    private String estado;
    
    public Endereco(){
    }
    
    public Endereco(String rua, String cidade, int numero, String cep, String estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.rua);
        hash = 61 * hash + Objects.hashCode(this.cidade);
        hash = 61 * hash + this.numero;
        hash = 61 * hash + Objects.hashCode(this.cep);
        hash = 61 * hash + Objects.hashCode(this.estado);
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
        final Endereco other = (Endereco) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", cidade=" + cidade + ", numero=" + numero + ", cep=" + cep + ", estado=" + estado + '}';
    }

   
       
}
