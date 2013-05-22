package br.com.eniac.web.sistema.temp;

import br.com.eniac.web.Aluno;
import br.com.eniac.web.sistema.SistemaGravacao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Rodrigo
 */
public class SistemaGravacaoTemp implements SistemaGravacao {
    
    private Set<Aluno> alunos = new HashSet<Aluno>();

    @Override
    public void gravaNovoAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    @Override
    public void apagaAluno(Aluno aluno) {
        for(Aluno item : this.alunos){
            if(item.equals(aluno)){
                this.alunos.remove(aluno);
            }
        }
    }
    @Override
    public void salvaAluno(Aluno aluno) {}
    
    @Override
    public List<Aluno> getAlunos() {
        List<Aluno> retorno = new ArrayList<Aluno>(this.alunos);
        return retorno;
    }
    
}
