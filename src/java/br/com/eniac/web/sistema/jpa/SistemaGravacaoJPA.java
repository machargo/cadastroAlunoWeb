package br.com.eniac.web.sistema.jpa;

import br.com.eniac.web.Aluno;
import br.com.eniac.web.sistema.SistemaGravacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author rmachargo
 */
@Stateless 
public class SistemaGravacaoJPA implements SistemaGravacao, Serializable {
 
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void gravaNovoAluno(Aluno aluno) {
        em.persist(aluno);        
    }

    @Override
    public List<Aluno> getAlunos() {        
         TypedQuery<Aluno> query = 
                em.createQuery("SELECT x FROM Aluno x", Aluno.class);
        List<Aluno> alunos = new ArrayList<Aluno>();
        for(Aluno item : query.getResultList()){
            alunos.add(item);
        }
        return alunos;
    }

    @Override
    public void apagaAluno(Aluno aluno) {        
        aluno = em.find(Aluno.class, aluno.getRa());
        em.remove(aluno);        
    }

    @Override
    public void salvaAluno(Aluno aluno) {
        em.merge(aluno);
    }
    
}