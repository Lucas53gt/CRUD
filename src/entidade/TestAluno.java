package entidade;

import java.util.Scanner;

import controller.AlunoController;

public class TestAluno {
	
	public static void main(String[] args) {

        int quantAluno;
        String op, temp, conteudo;

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        AlunoController controller = new AlunoController();

        //Menu de seleção
        do {
            System.out.println("\nMENU DE OPÇÕES\n");
            System.out.println("1) Adicionar um novo aluno:");
            System.out.println("2) Buscar alunos matriculados:");
            System.out.println("3) Atualizar alunos no banco de dados:");
            System.out.println("4) Deletar alunos do banco de dado:");
            System.out.println("0) Finalizar");
            op = scanner.nextLine();

            switch (op) {
                case "0":
                    System.out.println("\n\nFinalizando\n\n");
                    break;

                case "1":
                    System.out.println("Adicionar a quantidade de alunos: ");
                    temp = scanner.nextLine();
                    quantAluno = Integer.parseInt(temp);

                    for (int i = 0; i < quantAluno; i++) {                    
                        aluno = new Aluno();

                        System.out.println("Informe o Nome: ");
                        aluno.setNome(scanner.nextLine());
                        System.out.println("Informe o CPF: ");
                        aluno.setCpf(scanner.nextLine());
                        System.out.println("Informe o Curso: ");
                        aluno.setCurso(scanner.nextLine());

                        controller.criarAluno(aluno);
                        
                        System.out.println("\n\nAluno adicionado com sucesso!\n\n");
                    }
                    System.out.println("\n\nArquivo alunos criado com sucesso!\n\n");
                    break;

                case "2":
                    conteudo = controller.lerAluno();
 
                    if (conteudo != null) {
                        System.out.println("\n\nArquivo alunos encontrado com sucesso:\n\n");
                        System.out.println(conteudo);
                    } else
                        System.out.println("\n\nArquivo não encontrado!\n\n");
                    break;

                case "3":
 
                    if (controller.lerAluno() != null) {
                        controller.deletarAluno();
                        
                        System.out.println("Quantos novos alunos deseja adicionar? ");
                        temp = scanner.nextLine();
                        quantAluno = Integer.parseInt(temp);

                        for (int i = 0; i < quantAluno; i++) {
                            aluno = new Aluno();

                            System.out.println("Informe o Nome: ");
                            aluno.setNome(scanner.nextLine());
                            System.out.println("Informe o CPF: ");
                            aluno.setCpf(scanner.nextLine());
                            System.out.println("Informe o Curso: ");
                            aluno.setCurso(scanner.nextLine());

                            controller.atualizarAluno(aluno);

                            System.out.println("\n\nAluno adicionado com sucesso!\n\n");
                        }

                        System.out.println("\n\nArquivo alunos alterado com sucesso!\n\n");
                    } else
                    	
                        System.out.println("\n\nArquivo não encontrado!\n\n");
                    break;

                case "4":

                    if (controller.deletarAluno())
                        System.out.println("\n\nArquivo deletado com sucesso!\n\n");
                    else
                        System.out.println("\n\nArquivo não existente\n\n");
                    break;
                    
                default:
                    System.out.println("\n\nOpção invalida!\n\n");
            }
        } 
        while (!op.equals("0"));
    }

}
