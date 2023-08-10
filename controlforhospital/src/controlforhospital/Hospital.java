package controlforhospital;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private Map<Integer, Paciente> pacientes;
    private Map<Integer, ProntuarioMedico> prontuarios;
    private int ultimoIdPaciente;

    public Hospital() {
        pacientes = new HashMap<>();
        prontuarios = new HashMap<>();
        ultimoIdPaciente = 0;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.put(paciente.getIdPaciente(), paciente);
        ultimoIdPaciente = paciente.getIdPaciente();
    }

    public void adicionarProntuario(ProntuarioMedico prontuario) {
        prontuarios.put(prontuario.getIdPacienteAssociado(), prontuario);
    }

    public Paciente buscarPacientePorID(int idPaciente) {
        return pacientes.get(idPaciente);
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes.values()) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public ProntuarioMedico buscarProntuarioPorID(int idPaciente) {
        return prontuarios.get(idPaciente);
    }

    public void removerPacientePorID(int idPaciente) {
        pacientes.remove(idPaciente);
    }

    public void removerProntuarioPorID(int idPaciente) {
        prontuarios.remove(idPaciente);
    }

    public List<Paciente> listarTodosPacientes() {
        return new ArrayList<>(pacientes.values());
    }

    public List<ProntuarioMedico> listarTodosProntuarios() {
        return new ArrayList<>(prontuarios.values());
    }

    public int gerarNovoIdPaciente() {
        return ultimoIdPaciente + 1;
    }
}

