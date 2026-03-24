import java.io.*;
import java.net.*;

public class LogClient {
    public static void main(String[] args) {
        String host = "localhost";
        int porta = 12345;

        try (Socket socket = new Socket(host, porta);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Conectado ao servidor. Enviando logs...");

            // Enviando diferentes níveis de logs
            out.println("INFO;Usuário admin logou no sistema");
            out.println("ERROR;Falha na conexão com o banco de dados");
            out.println("DEBUG;Query executada em 15ms");
            out.println("ERROR;Tentativa de acesso não autorizado detectada");
            out.println("INFO;Backup finalizado com sucesso");

            System.out.println("Logs enviados. Fechando conexão.");

        } catch (IOException e) {
            System.err.println("Erro ao conectar ou enviar dados: " + e.getMessage());
        }
    }
}