package interfaces;

import entidade.Aluno;

public interface IAluno {
	
	void criarAluno(Aluno aluno);           
    String lerAluno();                      
    void atualizarAluno(Aluno aluno);       
    boolean deletarAluno();                 

}
