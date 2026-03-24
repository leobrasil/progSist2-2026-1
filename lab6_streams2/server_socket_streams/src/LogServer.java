import java.io.*;
import java.net.*;
import java.util.function.Predicate;

public class LogServer {
    public static void main(String[] args) {
        int porta = 12345;

        try (ServerSocket server = new ServerSocket(porta)) {
            System.out.println("🚀 Servidor de Logs rodando na porta " + porta);

            while (true) {
                // Aguarda conexão de um cliente
                try (Socket client = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("\n--- Nova conexão de: " + client.getInetAddress() + " ---");

                    // DEFINIÇÃO DA LÓGICA FUNCIONAL
                    // Filtro: Apenas linhas que contenham a palavra "ERROR"
                    Predicate<String> apenasErros = linha -> linha.contains("ERROR");

                    // PROCESSAMENTO COM STREAMS
                    in.lines() // Transforma as linhas recebidas em um Stream<String>
                      .filter(apenasErros)                   // Intermediário: Filtra
                      .map(String::toUpperCase)              // Intermediário: Transforma
                      .map(s -> "🚨 NOTIFICAÇÃO: " + s)       // Intermediário: Formata
                      .forEach(System.out::println);         // Terminal: Consome e exibe

                } catch (IOException e) {
                    System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}