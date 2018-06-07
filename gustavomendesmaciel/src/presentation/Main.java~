package presentation;

public class Main
{
    private static final String[] menuOptions =
    {
        "Inserir",
        "Alterar",
        "Remover",
        "Buscar curso",
        "Fazer matrícula",
        "Sair"
    };

    private static final String[] queryOptions =
    {
        "Pelo nome do curso",
        "Pelo nome do professor ministrante",
        "Voltar"
    };

    private static String showMenu()
    {
        System.out.println("[MENU]");
        for (int i = 0; i < menuOptions.length; i++)
            System.out.println(i + 1 + ". " + menuOptions[i]);
        System.out.print("\nEntre com a opção desejada: ");

        return System.console().readLine();
    }

    private static String showIUDOptions(String mode)
    {
        System.out.println("[" + mode + "]");
        for (int i = 0; i < IUD.IUDOptions.length; i++)
            System.out.println((char) (i + 97) + ") " + IUD.IUDOptions[i]);
        System.out.print("\nEntre com a opção desejada: ");

        return System.console().readLine();
    }

    private static String showQueryOptions(String mode)
    {
        System.out.println("[" + mode + "]");
        for (int i = 0; i < queryOptions.length; i++)
            System.out.println((char) (i + 97) + ") " + queryOptions[i]);
        System.out.print("\nEntre com a opção desejada: ");

        return System.console().readLine();
    }

    private static boolean parseIUDOption(IUD iud, String option)
    {
        if (option == null)
        {
            System.out.println();
            System.exit(0);
        }

        switch (option)
        {
            case "a":
                Terminal.clearScreen();
                iud.aluno();
                Terminal.clearScreen();
                break;
            case "b":
                Terminal.clearScreen();
                iud.professor();
                Terminal.clearScreen();
                break;
            case "c":
                Terminal.clearScreen();
                iud.curso();
                Terminal.clearScreen();
                break;
            case "d":
                Terminal.clearScreen();
                break;
            default:
                System.out.println(option + ": opção inválida\n");
                return false;
        }

        return true;
    }

    private static boolean parseQueryOption(String option)
    {
        Busca busca;

        if (option == null)
        {
            System.out.println();
            System.exit(0);
        }

        busca = new Busca();

        switch (option)
        {
            case "a":
                Terminal.clearScreen();
                busca.curso("CURSO");
                Terminal.clearScreen();
                break;
            case "b":
                Terminal.clearScreen();
                busca.curso("PROFESSOR");
                Terminal.clearScreen();
                break;
            case "c":
                Terminal.clearScreen();
                break;
            default:
                System.out.println(option + ": opção inválida\n");
                return false;
        }

        return true;
    }

    private static void parseMenuOption(String option)
    {
        String option2 = "";
        boolean res = false;

        if (option == null)
        {
            System.out.println();
            System.exit(0);
        }

        switch (option)
        {
            case "1":
                Terminal.clearScreen();
                while (!res)
                {
                    option2 = showIUDOptions(menuOptions[0].toUpperCase());
                    res = parseIUDOption(new Insercao(), option2);
                }
                break;
            case "2":
                Terminal.clearScreen();
                while (!res)
                {
                    option2 = showIUDOptions(menuOptions[1].toUpperCase());
                    res = parseIUDOption(new Alteracao(), option2);
                }
                break;
            case "3":
                Terminal.clearScreen();
                while (!res)
                {
                    option2 = showIUDOptions(menuOptions[2].toUpperCase());
                    res = parseIUDOption(new Remocao(), option2);
                }
                break;
            case "4":
                Terminal.clearScreen();
                while (!res)
                {
                    option2 = showQueryOptions(menuOptions[3].toUpperCase());
                    res = parseQueryOption(option2);
                }
                break;
            case "5":

                break;
            case "6":
                System.exit(0);
            default:
                System.out.println(option + ": opção inválida\n");
                break;
        }
    }

    public static void main(String[] args)
    {
        String option;

        Terminal.clearScreen();

        while (true)
        {
            option = showMenu();
            parseMenuOption(option);
        }
    }
}
