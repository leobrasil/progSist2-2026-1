public class AgenteTexto extends AgenteIA{

    public AgenteTexto(String nome) {
        super(nome);
        
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
     
            if (input.length() > 500) {
                throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
            }
            
            super.conectarServidor();
            System.out.println("Agente de Texto ["+this.nome+"] gerando resposta para: ["+input+"]");


                
    }

}
