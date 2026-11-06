package br.com.lojaroupas.dominio;

public abstract class Entidade {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}