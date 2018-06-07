package logic;

public class Aluno
{

    private long nro;
    private String nome;
    private String formacao;
    private String nivel;
    private int idade;

    public long getNro()
    {
        return this.nro;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getFormacao()
    {
        return this.formacao;
    }

    public String getNivel()
    {
        return this.nivel;
    }

    public int getIdade()
    {
        return this.idade;
    }

    public void setNro(long nro)
    {
        this.nro = nro;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setFormacao(String formacao)
    {
        this.formacao = formacao;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}
