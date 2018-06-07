package presentation;

import data.*;
import logic.*;

public class Remocao extends IUD
{
    @Override
    public void aluno()
    {
        AlunoDAO dao;
        String op;
        boolean delete = true;

        while (delete)
        {
            op = "";
            Aluno aluno;

            System.out.println("[REMOVER ALUNO]");
            System.out.print("Número do aluno: ");
            long nro = Long.parseLong(System.console().readLine());

            dao = new AlunoDAO();
            aluno = dao.obtem(nro);

            if (aluno != null)
            {
                System.out.print
                (
                    "Nome: " + aluno.getNome() + "\n" +
                    "Formação: " + aluno.getFormacao() + "\n" +
                    "Nível: " + aluno.getNivel() + "\n" +
                    "Idade: " + aluno.getIdade() + "\n\n"
                );

                while (!op.equals("s") && !op.equals("n"))
                {
                    System.out.print("Tem certeza que deseja remover este aluno? (s ou n) ");
                    op = System.console().readLine();
                }

                if (op.equals("s"))
                {
                    dao.remove(aluno);
                    System.out.println("Aluno removido com sucesso.\n");
                }
                else
                {
                    System.out.println("Aluno não removido.\n");
                }

                op = "";
            }
            else
            {
                System.out.println("Aluno não encontrado. Operação não concluída.\n");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja remover outro aluno? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) delete = false;
            else Terminal.clearScreen();
        }
    }

    @Override
    public void professor()
    {
        ProfessorDAO dao;
        String op;
        boolean delete = true;

        while (delete)
        {
            op = "";
            Professor professor;

            System.out.println("[REMOVER PROFESSOR]");
            System.out.print("ID: ");
            long id = Long.parseLong(System.console().readLine());

            dao = new ProfessorDAO();
            professor = dao.obtem(id);

            if (professor != null)
            {
                System.out.print
                (
                    "Nome: " + professor.getNome() + "\n" +
                    "ID do departamento: " + professor.getIdDepto() + "\n\n"
                );

                while (!op.equals("s") && !op.equals("n"))
                {
                    System.out.print("Tem certeza que deseja remover este professor? (s ou n) ");
                    op = System.console().readLine();
                }

                if (op.equals("s"))
                {
                    dao.remove(professor);
                    System.out.println("Professor removido com sucesso.\n");
                }
                else
                {
                    System.out.println("Professor não removido.\n");
                }

                op = "";
            }
            else
            {
                System.out.println("Professor não encontrado. Operação não concluída.\n");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja remover outro professor? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) delete = false;
            else Terminal.clearScreen();
        }
    }

    @Override
    public void curso()
    {
        CursoDAO dao;
        String op;
        boolean delete = true;

        while (delete)
        {
            op = "";
            Curso curso;

            System.out.println("[REMOVER CURSO]");
            System.out.print("Nome: ");
            String nome = System.console().readLine();

            dao = new CursoDAO();
            curso = dao.obtem(nome);

            if (curso != null)
            {
                System.out.print
                (
                    "Horario: " + curso.getHorario() + "\n" +
                    "Sala: " + curso.getSala() + "\n" +
                    "Nome do professor ministrante: " + curso.getProfessor().getNome() + "\n\n"
                );

                while (!op.equals("s") && !op.equals("n"))
                {
                    System.out.print("Tem certeza que deseja remover este curso? (s ou n) ");
                    op = System.console().readLine();
                }

                if (op.equals("s"))
                {
                    dao.remove(curso);
                    System.out.println("Curso removido com sucesso.\n");
                }
                else
                {
                    System.out.println("Curso não removido.\n");
                }

                op = "";
            }
            else
            {
                System.out.println("Curso não encontrado. Operação não concluída.\n");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja remover outro curso? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) delete = false;
            else Terminal.clearScreen();
        }
    }
}
