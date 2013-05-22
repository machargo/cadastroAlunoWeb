package br.com.eniac.web.util;

import br.com.eniac.web.Aluno;
import br.com.eniac.web.CadastradorAlunoBean;
import br.com.eniac.web.controller.AplicacaoWebConfig;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rmachargo
 */
@RequestScoped @Named
public class ListadorAluno {

    @Inject
    private CadastradorAlunoBean cadastrador;
    
    @Inject
    private AplicacaoWebConfig aplicacao;
    
    public List<Aluno> getAlunos(){
        return aplicacao.getSistemaGravacao().getAlunos();
    }
    
}
