import services.ServicePessoaServidor;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
   
    public static void iniciarServidor(){
        int     SERVER_PORT = 1099;
        String  LOCAL_HOST = "localhost";
        try {
            
            ServicePessoaServidor service = new ServicePessoaServidor();
            LocateRegistry.createRegistry(SERVER_PORT);
            Naming.bind(LOCAL_HOST, service);
            System.out.println("=======================");
            System.out.println("*Local Server: "+LOCAL_HOST);
            System.out.println("*Porta       : "+SERVER_PORT);
            System.out.println("*Status    : Em execucao");
        } catch (Exception e) {
            System.err.println("Erro ao inicar servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        iniciarServidor();
    }
    
}