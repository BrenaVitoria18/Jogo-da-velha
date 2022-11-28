import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JogoVelha {
    private char[][] tabuleiro = new char[3][3];
    private char jogador;
    String situacaoTabuleiro = " ";

    public JogoVelha(char jogador) {
        this.jogador = jogador;
    }

    public void criarTabuleiro() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tabuleiro[i][j] = ' ';

    }

    public void exibirTabuleiro() {
        System.out.println("Tabuleiro - Jogo da velha");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                // Formatação do tabuleiro
                if ((i == 0 && j == 2) || (i == 1 && j == 2))
                    System.out.println(tabuleiro[i][j] + "\n----------");
                else if (i == 2 && j == 2)
                    System.out.println(tabuleiro[i][j]);
                else
                    System.out.print(tabuleiro[i][j] + " | ");
    }

    public String Partida() throws Exception {
        BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
        String posicaoJogada;
        int posicaoJogadaInt;
        String situacaoTabuleiro = "";

        // Verifica os dados inseridos do cliente e servidor
        do {
            System.out.println("Escolha uma posição de 1 até 9\nPara sair digite 0");
            posicaoJogada = entradaUsuario.readLine();
            try {
                posicaoJogadaInt = Integer.parseInt(posicaoJogada);
                System.out.println("Jogada Invalida");
                if (Integer.signum(posicaoJogadaInt) == -1) {
                    posicaoJogadaInt = 10;
                    System.out.println("Jogada Invalida");
                } else if (posicaoJogadaInt == 0) {
                    System.exit(0);
                }

            } catch (NumberFormatException e) {
                posicaoJogadaInt = 10;
            }
        } while (posicaoJogadaInt > 9);

        if (posicaoJogadaInt == 1) {
            tabuleiro[0][0] = jogador;
        } else if (posicaoJogadaInt == 2) {
            tabuleiro[0][1] = jogador;
        } else if (posicaoJogadaInt == 3) {
            tabuleiro[0][2] = jogador;
        } else if (posicaoJogadaInt == 4) {
            tabuleiro[1][0] = jogador;
        } else if (posicaoJogadaInt == 5) {
            tabuleiro[1][1] = jogador;
        } else if (posicaoJogadaInt == 6) {
            tabuleiro[1][2] = jogador;
        } else if (posicaoJogadaInt == 7) {
            tabuleiro[2][0] = jogador;
        } else if (posicaoJogadaInt == 8) {
            tabuleiro[2][1] = jogador;
        } else if (posicaoJogadaInt == 9) {
            tabuleiro[2][2] = jogador;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                situacaoTabuleiro += tabuleiro[i][j];
            }
        }
        exibirTabuleiro();
        return situacaoTabuleiro;
    }

    public void atualizarTabuleiro(String situacao) {
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = situacao.charAt(cont);
                cont++;
            }
        }

        exibirTabuleiro();
    }

    public boolean verificarVencedor() {
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2])
            return true;
        else if (tabuleiro[1][0] != ' ' && tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2])
            return true;
        else if (tabuleiro[2][0] != ' ' && tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2])
            return true;
        else if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0])
            return true;
        else if (tabuleiro[0][1] != ' ' && tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1])
            return true;
        else if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2])
            return true;
        else if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2])
            return true;
        else if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0])
            return true;

        return false;
    }
}
