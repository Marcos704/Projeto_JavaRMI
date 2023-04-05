package interfaces;

import model.Pessoa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicePessoaServidor extends Remote {
    void registrarPessoa(Pessoa pessoa) throws RemoteException;

    List<Pessoa> obterPessoass() throws RemoteException;

    Pessoa procurarPessoa(String nomePessoa) throws RemoteException;

    Pessoa deletarPessoa(String nomePessoa) throws RemoteException;
}