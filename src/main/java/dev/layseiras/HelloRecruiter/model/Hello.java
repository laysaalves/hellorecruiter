package dev.layseiras.HelloRecruiter.model;

public class Hello {
    private Long id;
    private String usuario;
    private String vaga;
    private String nivel;
    private String ferramenta;
    private String empresa;
    private Integer experiencia;

    public Hello() {
    }

    public Hello(Long id, String usuario, String vaga, String nivel, String ferramenta, String empresa, Integer experiencia) {
        this.id = id;
        this.usuario = usuario;
        this.vaga = vaga;
        this.nivel = nivel;
        this.ferramenta = ferramenta;
        this.empresa = empresa;
        this.experiencia = experiencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }
}
