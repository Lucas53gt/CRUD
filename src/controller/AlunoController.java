package controller;

import entidade.Aluno;
import helper.ArquivoHelper;
import interfaces.IAluno;

public class AlunoController implements IAluno {
	
    @Override
    public void criarAluno(Aluno aluno) {

        aluno.setMatricula();
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        arquivoHelper.gravarCSV(aluno);
    }

    @Override
    public String lerAluno() {

        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        return arquivoHelper.lerCSV();
    }

    @Override
    public void atualizarAluno(Aluno aluno) {

        aluno.setMatricula();
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        arquivoHelper.gravarCSV(aluno);
    }

    @Override
    public boolean deletarAluno() {

        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        return arquivoHelper.deletarCSV();
    }

}
