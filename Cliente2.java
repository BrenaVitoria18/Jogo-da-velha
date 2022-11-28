import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    private static JogoVelha jogo = new JogoVelha('O');

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ServerSocket Cliente2 = new ServerSocket(55580);
        Socket conexao = Cliente2.accept();
        String situacaoTabuleiro;

        BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        DataOutputStream saidaCliente = new DataOutputStream(conexao.getOutputStream());

        while (true) {
            jogo.criarTabuleiro();
            jogo.exibirTabuleiro();

            while (true) {
                situacaoTabuleiro = jogo.Partida();
                saidaCliente.writeBytes(situacaoTabuleiro + "\n");

                if (jogo.verificarVencedor()) {
                    System.out.println("O Cliente2 venceu!!");
                    break;
                }

                situacaoTabuleiro = entradaCliente.readLine();
                jogo.atualizarTabuleiro(situacaoTabuleiro);

                if (jogo.verificarVencedor()) {
                    System.out.println("O cliente venceu!!");
                    break;
                }

            }

        }

    }
}