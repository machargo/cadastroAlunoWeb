package br.com.eniac.web.controller;

import br.com.eniac.web.sistema.SistemaGravacao;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rmachargo
 */
@ApplicationScoped
@Named
public class AplicacaoWebConfig implements Serializable {
    
    @Inject @Sistema
    private SistemaGravacao sistema;

    public SistemaGravacao getSistemaGravacao() {
        return sistema;
    }
}
