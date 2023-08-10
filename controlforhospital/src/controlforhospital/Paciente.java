package controlforhospital;

public class Paciente {
    private String nome;
    private String nomePais;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private String telefone;
    private Endereco endereco;
    private int idPaciente;
    private int contadorVisitas;

    public Paciente(String nome, String nomePais, String dataNascimento, String cpf, String rg, String telefone,
                    Endereco endereco, int idPaciente) {
        this.nome = nome;
        this.nomePais = nomePais;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idPaciente = idPaciente;
        this.contadorVisitas = 0;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getContadorVisitas() {
        return contadorVisitas;
    }

    public void incrementarContadorVisitas() {
        contadorVisitas++;
    }
}
