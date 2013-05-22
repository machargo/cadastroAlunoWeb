package br.com.eniac.web.controller;

import br.com.eniac.web.sistema.SistemaGravacao;
import br.com.eniac.web.sistema.temp.SistemaGravacaoTemp;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author rmachargo
 */
@RequestScoped 
public class ProdutorGeral implements Serializable {
    
    @EJB
    private SistemaGravacao sistemaGravacaoJPA;
    
    @Produces 
    public SistemaGravacao criaSistemaTemp(){
        return new SistemaGravacaoTemp();
    }
    
    @Produces @Sistema
    public SistemaGravacao criaSistemaJPA(){
        return sistemaGravacaoJPA;
    }
}
