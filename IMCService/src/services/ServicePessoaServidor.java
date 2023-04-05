package services;

import model.Pessoa;
import interfaces.IServicePessoaServidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicePessoaServidor extends UnicastRemoteObject implements IServicePessoaServidor {

    private List<Pessoa> pessoas = new ArrayList<>();

    public ServicePessoaServidor() throws RemoteException {
        iniciar();
    }

    @Override
    public void registrarPessoa(Pessoa pessoa) throws RemoteException {
        pessoas.add(pessoa);
    }

    @Override
    public List<Pessoa> obterPessoass() throws RemoteException {
        return pessoas;
    }

    public Pessoa procurarPessoa(String nomePessoa) throws RemoteException {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNomePessoa().equals(nomePessoa)) {
                return pessoa;
            }
        }
        return null;
    }

    public Pessoa deletarPessoa(String nomePessoa) throws RemoteException {
        Iterator<Pessoa> it = pessoas.iterator();
        while (it.hasNext()) {
            Pessoa pessoa = it.next();
            if (pessoa.getNomePessoa().equals(nomePessoa)) {
                it.remove();
                return pessoa;
            }
        }
        return null;

    }

    private void iniciar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("Adm");
        pessoa.setAlturaPessoa(0.0);
        pessoa.setPesoPessoa(0.0);
        pessoa.setImcPessoa(0.0);
        pessoas.add(pessoa);
    }
}
