import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    private static JogoVelha jogo = new JogoVelha('X');

    public static void main(String[] args) throws Exception {
        Socket socketCliente = new Socket("127.0.0.1", 55580);
        String situacaoTabuleiro;

        BufferedReader entradaCliente2 = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        DataOutputStream saidaCliente2 = new DataOutputStream(socketCliente.getOutputStream());

        jogo.criarTabuleiro();
        while (true) {
            situacaoTabuleiro = entradaCliente2.readLine();
            jogo.atualizarTabuleiro(situacaoTabuleiro);

            if (jogo.verificarVencedor()) {
                System.out.println("O cliente2 venceu!!");
                break;
            }
            situacaoTabuleiro = jogo.Partida();
            saidaCliente2.writeBytes(situacaoTabuleiro + "\n");

            if (jogo.verificarVencedor()) {
                System.out.println("O cliente venceu!!");
                break;
            }

        }

    }
}