package controlforhospital;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Prontuário");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Buscar Prontuário");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            
            int escolha = Integer.parseInt(scanner.nextLine());
            
            switch (escolha) {
                case 1:
                    cadastrarNovoPaciente(hospital, scanner);
                    break;
                case 2:
                    cadastrarNovoProntuario(hospital, scanner);
                    break;
                case 3:
                    buscarPaciente(hospital, scanner);
                    break;
                case 4:
                    buscarProntuario(hospital, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void cadastrarNovoPaciente(Hospital hospital, Scanner scanner) {
        System.out.println("Cadastro de Novo Paciente:");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nome dos Pais: ");
        String nomePais = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        
        Endereco endereco = new Endereco(pais, cidade, estado, bairro, rua);
        int novoId = hospital.gerarNovoIdPaciente();
        Paciente paciente = new Paciente(nome, nomePais, dataNascimento, cpf, rg, telefone, endereco, novoId);
        hospital.adicionarPaciente(paciente);
        System.out.println("Paciente " + nome + " cadastrado com sucesso!");
    }
    
    private static void cadastrarNovoProntuario(Hospital hospital, Scanner scanner) {
        System.out.println("Cadastro de Novo Prontuário:");
        
        System.out.print("ID do Paciente Associado: ");
        int idPaciente = Integer.parseInt(scanner.nextLine());
        
        Paciente paciente = hospital.buscarPacientePorID(idPaciente);
        if (paciente != null) {
            ProntuarioMedico prontuario = new ProntuarioMedico(idPaciente, paciente.getNome());
            
            System.out.print("Data da Entrada Médica: ");
            String dataEntrada = scanner.nextLine();
            System.out.print("Diagnóstico: ");
            String diagnostico = scanner.nextLine();
            System.out.print("Médico Responsável: ");
            String medicoResponsavel = scanner.nextLine();
            
            String entradaMedica = dataEntrada + ": Diagnóstico: " + diagnostico + ". Médico: " + medicoResponsavel;
            prontuario.adicionarEntradaMedica(entradaMedica);
            
            hospital.adicionarProntuario(prontuario);
            System.out.println("Prontuário cadastrado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void buscarPaciente(Hospital hospital, Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        Paciente pacienteEncontrado = hospital.buscarPacientePorCPF(cpf);
        if (pacienteEncontrado != null) {
            System.out.println("Paciente encontrado:");
            System.out.println("Nome: " + pacienteEncontrado.getNome());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void buscarProntuario(Hospital hospital, Scanner scanner) {
        System.out.print("Digite o ID do paciente associado ao prontuário: ");
        int idPaciente = Integer.parseInt(scanner.nextLine());

        ProntuarioMedico prontuarioEncontrado = hospital.buscarProntuarioPorID(idPaciente);
        if (prontuarioEncontrado != null) {
            System.out.println("Prontuário encontrado:");
            System.out.println("Nome do Paciente: " + prontuarioEncontrado.getNomePacienteAssociado());
            System.out.println("Entradas Médicas:");
            for (String entrada : prontuarioEncontrado.getEntradasMedicas()) {
                System.out.println("- " + entrada);
            }
        } else {
            System.out.println("Prontuário não encontrado.");
        }
    }
}

