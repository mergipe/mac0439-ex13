package presentation;

import data.*;
import logic.*;

public class Alteracao extends IUD
{
    @Override
    public void aluno()
    {
        AlunoDAO dao;
        String op;
        boolean update = true;

        while (update)
        {
            op = "";
            Aluno aluno = new Aluno();

            System.out.println("[ALTERAR ALUNO]");
            System.out.print("Número: ");
            aluno.setNro(Long.parseLong(System.console().readLine()));
            System.out.print("Nome: ");
            aluno.setNome(System.console().readLine());
            System.out.print("Formação: ");
            aluno.setFormacao(System.console().readLine());
            System.out.print("Nível: ");
            aluno.setNivel(System.console().readLine());
            System.out.print("Idade: ");
            aluno.setIdade(Integer.parseInt(System.console().readLine()));

            dao = new AlunoDAO();
            dao.altera(aluno);
            System.out.println("Aluno alterado com sucesso.\n");

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja alterar outro aluno? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) update = false;
            else Terminal.clearScreen();
        }
    }

    @Override
    public void professor()
    {
    }

    @Override
    public void curso()
    {
    }
}
