public class PluginPesquisaWeb implements IAcaoAgente{

    @Override
    public void processarRequisicao(String prompt) throws Exception {
       if(prompt.toLowerCase().contains("hackear") ||
          prompt.toLowerCase().contains("roubar")
          )
        {
            throw new PromptInadequadoException("prompt inadequado verifique e tente novamente "+prompt);
        }

        System.out.println("Executando o prompt +"+prompt);
    }

}
