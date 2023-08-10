package controlforhospital;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioMedico {
    private int idPacienteAssociado;
    private String nomePacienteAssociado;
    private List<String> entradasMedicas;

    public ProntuarioMedico(int idPacienteAssociado, String nomePacienteAssociado) {
        this.idPacienteAssociado = idPacienteAssociado;
        this.nomePacienteAssociado = nomePacienteAssociado;
        this.entradasMedicas = new ArrayList<>();
    }

    public int getIdPacienteAssociado() {
        return idPacienteAssociado;
    }

    public String getNomePacienteAssociado() {
        return nomePacienteAssociado;
    }

    public List<String> getEntradasMedicas() {
        return entradasMedicas;
    }

    public void adicionarEntradaMedica(String entrada) {
        entradasMedicas.add(entrada);
    }
}

