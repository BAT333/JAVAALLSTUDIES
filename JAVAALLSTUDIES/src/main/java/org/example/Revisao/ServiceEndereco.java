package org.example.Revisao;

import java.util.List;

public class ServiceEndereco {
    private FactoryCone factoryCone;
    private Endereco endereco;
    public ServiceEndereco(Endereco endereco){
        this.factoryCone = new FactoryCone();
        this.endereco = endereco;
    }
    public void cadastra(){
        EnderecoDAO dao = new EnderecoDAO(this.factoryCone.connection());
        dao.cadastro(this.endereco);
    }
    public void update(int id,String bairro){
        EnderecoDAO dao = new EnderecoDAO(this.factoryCone.connection());
        dao.update(id,bairro);

    }
    public void delete(int id){
        EnderecoDAO dao = new EnderecoDAO(this.factoryCone.connection());
        dao.delete(id);

    }
    public List<Endereco> listaEndereco(){
        EnderecoDAO dao = new EnderecoDAO(this.factoryCone.connection());
        return dao.lista();

    }
}
