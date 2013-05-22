package br.com.eniac.web.sistema;

import br.com.eniac.web.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SistemaGravacao extends Serializable {
	
	void gravaNovoAluno(Aluno aluno);
        
        void apagaAluno(Aluno aluno);
        
        void salvaAluno(Aluno aluno);
        
        List<Aluno>getAlunos();

}
