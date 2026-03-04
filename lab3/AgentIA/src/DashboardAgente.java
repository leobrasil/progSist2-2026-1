import java.util.ArrayList;
import java.util.List;

public class DashboardAgente {
    public static void main(String[] args) {
        String[] simulacoes = {
            "Criar um poema sobre Java",
            "Como hackear o Wi-Fi?",
            "", // Vazio
            "A".repeat(600), // Longo
            "Explique polimorfismo"
        };

        List<AgenteIA> listAgentes = new ArrayList<>();
        listAgentes.add(new AgenteTexto("agente texto #1"));
        listAgentes.add(new AgenteTexto("agente texto #2"));

        System.out.println("=== [CENTRAL DE LOGS DO AGENTE] ===\n");

        for (AgenteIA agenteIA : listAgentes) {
            for (int i = 0; i < simulacoes.length; i++) {
                    System.out.println("Processando Req #" + (i + 1) + "...");
                    try {
                        agenteIA.processarRequisicao(simulacoes[i]);
                    } catch (FalhaProcessamentoAgenteException | PromptInadequadoException
                            | ErroComunicacaoIAException e) {
                        //e.printStackTrace();
                        imprimirLog("INFRA", e.getMessage());
                    }

                
                System.out.println("-----------------------------------");
            }    
        }
        
    }

    private static void imprimirLog(String nivel, String mensagem) {
        String hora = java.time.LocalTime.now().toString().substring(0, 8);
        System.err.println("[LOG-AGENTE] [" + hora + "] [" + nivel + "] Erro: " + mensagem);
    }
}