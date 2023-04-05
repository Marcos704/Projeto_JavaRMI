import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;
import java.util.Scanner;

import interfaces.IServicePessoaServidor;
import model.Pessoa;

public class Main {

    public static void CLS() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }

    }

    public static double calcularIMC(double peso, double altura) {
        double resultado = peso / (altura * altura);
        return resultado;
    }

    public static void CADASTRAR(IServicePessoaServidor server, Pessoa pessoa)
            throws InterruptedException, IOException, NotBoundException {
        try {
            double auxPeso, auxAltura, auxIMC;
            int auxSysQTDCad;

            Scanner auxCadInputScanner = new Scanner(System.in);

            System.out.println(" ================================ ");
            System.out.println("|            CADASTRO             |");
            System.out.println(" -------------------------------- ");
            System.out.print("| Quantidade a ser cadastrado..: ");
            auxSysQTDCad = auxCadInputScanner.nextInt();

            for (int i = 1; i <= auxSysQTDCad; i++) {
                CLS();
                System.out.println(" ================================ ");
                System.out.println("|            CADASTRO             |");
                System.out.println(" -------------------------------- ");
                System.out.println("* Registro nº " + i);
                System.out.println("Informe o nome: ");
                pessoa.setNomePessoa(auxCadInputScanner.next());
                System.out.println("informe o peso: ");
                auxPeso = auxCadInputScanner.nextDouble();
                pessoa.setPesoPessoa(auxPeso);
                System.out.println("informe a altura: ");
                auxAltura = auxCadInputScanner.nextDouble();
                pessoa.setAlturaPessoa(auxAltura);
                auxIMC = calcularIMC(auxPeso, auxAltura);
                System.out.println("IMC: " + auxIMC);
                pessoa.setImcPessoa(auxIMC);
                server.registrarPessoa(pessoa);
                System.out.println("Pressione qualquer tecla para CONFIRMAR...");
                System.in.read();
                CLS();
            }
            System.out.println("Pressione qualquer tecla para voltar ao MENU...");
            System.in.read();
            CLS();
            MENU();

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public static void LISTAR_DADOS(IServicePessoaServidor server) {

        try {
            List<Pessoa> listPessoas;

            listPessoas = server.obterPessoass();
            System.out.println(" ================================ ");
            System.out.println("|    PESSOAS CADASTRADAS          |");
            System.out.println(" -------------------------------- ");
            for (Pessoa pessoa : listPessoas) {
                System.out.println("Nome: " + pessoa.getNomePessoa() + " Peso: " + pessoa.getPesoPessoa() + " Altura: "
                        + pessoa.getAlturaPessoa() + " IMC: " + pessoa.getImcPessoa());
            }
            System.out.println("Pressione qualquer tecla para voltar ao MENU...");
            System.in.read();
            CLS();
            MENU();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void PROCURAR_DADOS(IServicePessoaServidor server) {

        try {
            Pessoa lista;
            String auxNome;
            Scanner auxProcInputScanner = new Scanner(System.in);

            System.out.println(" ================================ ");
            System.out.println("|       PROCURAR PESSOA           |");
            System.out.println(" -------------------------------- ");
            System.out.print("*Nome.: ");
            auxNome = auxProcInputScanner.nextLine();
            lista = server.procurarPessoa(auxNome);
            //for (Pessoa pessoa : lista) {
                System.out.println("Nome: " + lista.getNomePessoa() + " Peso: " + lista.getPesoPessoa() + " Altura: "
                        + lista.getAlturaPessoa() + " IMC: " + lista.getImcPessoa());
            //}
            System.out.println("Pressione qualquer tecla para voltar ao MENU...");
            System.in.read();
            CLS();
            MENU();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void DELETAR_DADOS(IServicePessoaServidor server) {

        try {
            String auxNome;
            Scanner auxProcInputScanner = new Scanner(System.in);

            System.out.println(" ================================ ");
            System.out.println("|       EXCLUIR  PESSOA           |");
            System.out.println(" -------------------------------- ");
            System.out.print("*Nome.: ");
            auxNome = auxProcInputScanner.nextLine();
            
            If(server.deletarPessoa(auxNome) != null){
            System.out.println("Pressione qualquer tecla para voltar ao MENU...");
            System.in.read();
            CLS();
            MENU();
}eles{
CLS();

System.out.println(" ================================ ");
            System.out.println("|       EXCLUIR  PESSOA           |");
            System.out.println(" -------------------------------- ");
System.out.println("Usuário não Localizado");

System.out.println("Pressione qualquer tecla para voltar ao MENU...");
            System.in.read();
            CLS();
            MENU();

}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void MENU() throws InterruptedException, IOException, NotBoundException {
        int opcoesMenu;
        IServicePessoaServidor localService = (IServicePessoaServidor) Naming.lookup("localhost");
        Scanner entrada = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.println(" ============================ ");
        System.out.println("|           MENU             |");
        System.out.println(" ---------------------------- ");
        System.out.println("| Escolha uma das opcoes...  |");
        System.out.println("| (1) Cadastrar              |");
        System.out.println("| (2) Procurar               |");
        System.out.println("| (3) Listar Todos           |");
        System.out.println("| (4) Excluir                |");
        System.out.println("| (5) Fechar App             |");
        System.out.println(" ---------------------------- ");
        opcoesMenu = entrada.nextInt();
        System.out.println(opcoesMenu);

        switch (opcoesMenu) {
            case 1:
                CLS();
                CADASTRAR(localService, pessoa);
                break;
            case 2:
                CLS();
                PROCURAR_DADOS(localService);
                break;
            case 3:
                CLS();
                LISTAR_DADOS(localService);
                break;
            case 4:
                CLS();
                DELETAR_DADOS(localService);
                break;
            case 5:
                CLS();
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida!");
                System.out.println("Pressione qualquer tecla para voltar ao MENU...");
                System.in.read();
                CLS();
                MENU();
                break;
        }
    }

    public static void main(String[] args) {

        try {

            CLS();
            MENU();

        } catch (Exception e) {
            System.err.println("Erro {Exception} - " + e.getMessage());
        }

    }

}
