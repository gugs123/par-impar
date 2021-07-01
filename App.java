import java.util.Random;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) 
    {
        Jogo jogadores = new Jogo();
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        boolean breakloop;
        int escolhaNumJogador;
        int escolhaNumMaquina;
        boolean isEven;
        boolean repeat = false;

        do
        {
            do
            {
                System.out.println("Escolha qual voce deseja? ");
                System.out.println("P - Par \nI - Impar ");
                System.out.print("Escolha: ");
                String escolha = in.nextLine().trim().toLowerCase();
                System.out.println();
                char escolhaChar = escolha.charAt(0);
                
                
                breakloop = escolhaParImpar(escolhaChar, jogadores);
            }while(breakloop == false);

            System.out.println();
            System.out.print("Escolha um numero para jogar: ");
            escolhaNumJogador = in.nextInt();

            escolhaNumMaquina = numRandomMaquina(r);

            System.out.println();
            System.out.println("Voce jogou " + escolhaNumJogador);
            System.out.println("Maquina jogou " + escolhaNumMaquina);

            isEven = ePar(escolhaNumJogador, escolhaNumMaquina);

            vencedor(isEven, jogadores);

            //in.close();
            //Scanner in = new Scanner(System.in);
            repeat = repete(repeat, in);
            
        
        }while(repeat == true);
        //in.close();

    }

    public static boolean repete(boolean repeat, Scanner in)
    {
        String faznada = in.nextLine();
        System.out.println("Deseja jogar novamente?\nDigite 1 para sim ou outra tecla para nao");
        System.out.print("Escolha: ");
        String escolha = in.nextLine();

        switch(escolha)
        {
            case "1":
            {return repeat = true;}
            default:
            {return repeat = false;}
        }
    }

    public static void vencedor(boolean isEven, Jogo jogadores)
    {
        char par;
        if(isEven)
        {par = 'p';}

        else
        {par = 'i';}

        if(jogadores.getJogador() == par)
        {System.out.println("\nVOCE FOI O VENCEDOR!!!!");}

        else
        {System.out.println("\nVOCE PERDEU!!!\nA MAQUINA FOI A VENCEDORA");}
    }

    public static boolean escolhaParImpar(char escolhaChar, Jogo jogadores)
    {
        switch(escolhaChar)
        {
            case 'p': 
            {
                jogadores.setJogador('p');
                jogadores.setMaquina('i');
                System.out.println("Voce escolheu Par\nMaquina ficou com Impar");
                return true;
            }

            case 'i': 
            {
                jogadores.setJogador('i');
                jogadores.setMaquina('p');
                System.out.println("Voce escolheu Impar\nMaquina ficou com Par");
                return true;
            }
            default:
            {
                System.out.println("Opcao invalida");
                return false;
            }
        }
    }

    public static int numRandomMaquina(Random r)
    {
        int numMaquina;
        do
        {
            numMaquina = r.nextInt();
        }while(numMaquina < 0 || numMaquina > 100);
        return numMaquina;
    }

    public static boolean ePar(int escolhaNumJogador, int escolhaNumMaquina)
    {
        int resultado = escolhaNumJogador + escolhaNumMaquina;
        System.out.println("O resultado deu " + resultado);
        if(resultado%2 == 0)
        {
            System.out.println("O numero e PAR");
            return true;
        }
        
        else
        {
            System.out.println("O numero e IMPAR");
            return false;
        }
    }
}
