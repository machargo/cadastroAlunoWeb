package br.com.eniac.web;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rmachargo
 */
@Entity
@Table(name="alunos")
public class Aluno implements Serializable{

        @Column
        private String nome;
        @Id
        private int ra;
        
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
}
