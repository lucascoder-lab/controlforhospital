package controlforhospital;

public class Endereco {
    private String pais;
    private String cidade;
    private String estado;
    private String bairro;
    private String rua;

    public Endereco(String pais, String cidade, String estado, String bairro, String rua) {
        this.pais = pais;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }
}
