package presentation;

public abstract class IUD
{
    public static final String[] IUDOptions =
    {
        "Aluno",
        "Professor",
        "Curso",
        "Voltar"
    };

    public abstract void aluno();
    public abstract void professor();
    public abstract void curso();
}
