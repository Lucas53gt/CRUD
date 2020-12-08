package helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import entidade.Aluno;

public class ArquivoHelper {
	
	private String caminho = "alunos.csv";
    private String separador = ",";
    private static ArquivoHelper instance = null;
 
    private ArquivoHelper() {
    }
    public static ArquivoHelper getInstance() {
        if (instance == null)
            instance = new ArquivoHelper();
        return instance;
    }

    public void gravarCSV(Aluno aluno) {
    	
        StringBuilder builder = new StringBuilder();
        builder.append(aluno.getNome())
                .append(separador)
                .append(aluno.getCpf())
                .append(separador)
                .append(aluno.getCurso())
                .append(separador)
                .append(aluno.getMatricula());
        try {
            FileWriter writer = new FileWriter(caminho, true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            //Gravando arquivo com dados formatados
            bWriter.write(builder.toString());
            bWriter.newLine();
            bWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public String lerCSV() {
        File file = new File(caminho);
        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (FileNotFoundException exception) {
            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public boolean deletarCSV() {
        File file = new File(caminho);
        return file.delete();
    }
}
