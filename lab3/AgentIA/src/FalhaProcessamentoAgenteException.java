import java.time.LocalDateTime;

// Base: Falha Geral
public class FalhaProcessamentoAgenteException extends Exception {
    private String timestamp;
    public FalhaProcessamentoAgenteException(String mensagem) {
        super(mensagem);
        this.timestamp = LocalDateTime.now().toString();
    }
    public String getTimestamp() { return timestamp; }
}