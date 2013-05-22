package br.com.eniac.web;

import br.com.eniac.web.controller.AplicacaoWebConfig;
import br.com.eniac.web.controller.Sistema;
import br.com.eniac.web.sistema.SistemaGravacao;
import br.com.eniac.web.util.ListadorAluno;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rmachargo
 */
@SessionScoped @Named
public class CadastradorAlunoBean implements Serializable {
   
    @Inject @Sistema     
    private SistemaGravacao sistema;
    
    private Aluno aluno;
    
    @Inject
    private AplicacaoWebConfig aplicacao;
    
    @Inject
    private ListadorAluno listador;
    
    private boolean botaoSalvar;        
    
    private String nomeBotao;

    public String getNomeBotao() {
        return nomeBotao;
    }
    
    public CadastradorAlunoBean(){
        criaAluno();
        this.nomeBotao = "Novo";
        botaoSalvar = false;        
    }
    
    public List<Aluno> getAlunos() {
        List<Aluno> alunos = listador.getAlunos();
        return alunos;
    }

    public AplicacaoWebConfig getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(AplicacaoWebConfig aplicacao) {
        this.aplicacao = aplicacao;
    }
       
    @PostConstruct
    public void init(){
        sistema = aplicacao.getSistemaGravacao();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public SistemaGravacao getSistema() {
        return sistema;
    }

    public void setSistema(SistemaGravacao sistema) {
        this.sistema = sistema;
    }
    
    public void criaAluno(){
        aluno = new Aluno();
    }
    
    public void botaoSalvar(){
        if(botaoSalvar){
            sistema.salvaAluno(aluno);
            this.criaAluno();
            botaoSalvar=false;
            this.nomeBotao="Novo";
        }else{
            sistema.gravaNovoAluno(aluno);
            this.criaAluno();                                
        }
    }
    public void apagar(Aluno aluno){
        sistema.apagaAluno(aluno);
    }
    
    public void editar(Aluno aluno){
        this.aluno=aluno;
        botaoSalvar=true;
        this.nomeBotao="Salvar";
    }
    
    public  boolean isBloqueadorInput(){
        return botaoSalvar;       
    }
    
    
}
