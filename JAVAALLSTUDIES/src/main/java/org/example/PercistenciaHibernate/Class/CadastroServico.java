package org.example.PercistenciaHibernate.Class;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CadastroServico {
    private Factory factory;
    private Cadastro cadastro;
   public CadastroServico (Cadastro cadastro){

       this.cadastro = cadastro;
       this.factory = new Factory();
   }

   public void salvar(){
       CadstroDAO dao = new CadstroDAO(this.factory.Conectar());
       dao.cadastra(this.cadastro);

   }
}
