package br.com.diego.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExecucaoJob {

    public static String RotinaAlteracaoContaBancariaCliente = "RotinaAlteracaoContaBancariaCliente";
    public static String ProcessamentoParcelamentoFaturaJob = "ProcessamentoParcelamentoFaturaJob";
    public static String AtualizarDividaInadimplentesPosCorteJob = "AtualizarDividaInadimplentesPosCorteJob";
    public static String RotinaDiariaEnviarConfirmacaoCobrancaSeguradora = "RotinaDiariaEnviarConfirmacaoCobrancaSeguradora";
    public static String GerarArquivoBancarioJob = "GerarArquivoBancarioJob";
    public static String RotinaDiariaAtualizaViewsSGR = "RotinaDiariaAtualizaViewsSGR";
    public static String GerarArquivoGraficaJob = "GerarArquivoGraficaJob";
    public static String RotinaDiariaProcessamentoVendasCarne = "RotinaDiariaProcessamentoVendasCarne";
    public static String RegistrarAlertaFaturaPacoteSMSJob = "RegistrarAlertaFaturaPacoteSMSJob";
    public static String RegistrarAlertaFaturaDisponivelSMSJob = "RegistrarAlertaFaturaDisponivelSMSJob";
    public static String RegistrarAlertaFaturaDigitalEmailJob = "RegistrarAlertaFaturaDigitalEmailJob";
    public static String RegistrarAlertaFaturaJob = "RegistrarAlertaFaturaJob";
    public static String EnviarSMSJob = "EnviarSMSJob";
    public static String CorteConvenioJob = "CorteConvenioJob";
    public static String PagamentoRotativoSeguroJob = "PagamentoRotativoSeguroJob";
    public static String ProcessarIntegracaoSeguradoraJob = "ProcessarIntegracaoSeguradoraJob";
    public static String CorteConvenioJobJPA = "CorteConvenioJobJPA";
    public static String CorteAdicionalJob = "CorteAdicionalJob";
    public static String BloqueioContasAtrasoJob = "BloqueioContasAtrasoJob";
    public static String BloqueiaClienteCarnePorAtrasoJob = "BloqueiaClienteCarnePorAtrasoJob";
    public static String EnviarClientesParaCobrancaJob = "EnviarClientesParaCobrancaJob";
    public static String EnviarContasCobrancaJob = "EnviarContasCobrancaJob";
    public static String GerarArquivoCadastralEasyCollectorJob = "GerarArquivoCadastralEasyCollectorJob";
    public static String GerarArquivoCadastralWedooJob = "GerarArquivoCadastralWedooJob";
    public static String RotinaDiariaCobrancaJob = "RotinaDiariaCobrancaJob";
    public static String RotinaDiariaCobrancaInadimplenteJob = "RotinaDiariaCobrancaInadimplenteJob";
    public static String RotinaDiariaProcessamentoSPCRetorno = "RotinaDiariaProcessamentoSPCRetorno";
    public static String RotinaDiariaValidaEnvioSPCporTaxas = "RotinaDiariaValidaEnvioSPCporTaxas";
    public static String RetirarClientesSPCJob = "RetirarClientesSPCJob";
    public static String EnviarClientesSPCJob = "EnviarClientesSPCJob";
    public static String GerarArquivoFinanceiroEasyCollectorJob = "GerarArquivoFinanceiroEasyCollectorJob";
    public static String RotinaDiariaRepasseJob = "RotinaDiariaRepasseJob";
    public static String RotinaDiariaCancelamentoAcordoConvenioJob = "RotinaDiariaCancelamentoAcordoConvenioJob";
    public static String RotinaDiariaLimparTentativasLoginUsuariosJob = "RotinaDiariaLimparTentativasLoginUsuariosJob";
    public static String RotinaDiariaImpressaoContratoJob = "RotinaDiariaImpressaoContratoJob";
    public static String RotinaDiariaProcessarArquivoBancarioRetornoJob = "RotinaDiariaProcessarArquivoBancarioRetornoJob";
    public static String AtualizaRelatorioValoresRecebidosJob = "AtualizaRelatorioValoresRecebidosJob";
    public static String RotinaDiariaAniversarioLojaJob = "RotinaDiariaAniversarioLojaJob";
    public static String RotinaDiariaBloqDesbloqClientesJob = "RotinaDiariaBloqDesbloqClientesJob";
    public static String RotinaDiariaBloqDesbloqCartoesJob = "RotinaDiariaBloqDesbloqCartoesJob";
    public static String RotinaDiariaBloqueioCarne = "RotinaDiariaBloqueioCarne";
    public static String RotinaDiariaProcessarArquivoBancarioRemessaJob = "RotinaDiariaProcessarArquivoBancarioRemessaJob";
    public static String RotinaDiariaProcessaDebitosAtrasoCobrancaExternoJob = "RotinaDiariaProcessaDebitosAtrasoCobrancaExternoJob";
    public static String RotinaDiariaProcessarArquivoBancarioCobrancaJob = "RotinaDiariaProcessarArquivoBancarioCobrancaJob";
    public static String RotinaDiariaProcessamentoLoteLimiteCreditoJob = "RotinaDiariaProcessamentoLoteLimiteCreditoJob";
    public static String RotinaDiariaAgendamentoBloqueioLojaJob = "RotinaDiariaAgendamentoBloqueioLojaJob";
    public static String RotinaDiariaProcessaArquivoApresentacaoGoodCardJob = "RotinaDiariaProcessaArquivoApresentacaoGoodCardJob";
    public static String RotinaDiariaProcessaArquivoTrocaStatusGoodCardJob = "RotinaDiariaProcessaArquivoTrocaStatusGoodCardJob";
    public static String CancelaVendasGoodCardJob = "CancelaVendasGoodCardJob";
    public static String RotinaDiariaGeraArquivoBaseCartoesJob = "RotinaDiariaGeraArquivoBaseCartoesJob";
    public static String ProcessaLancamentosContabeisJob = "ProcessaLancamentosContabeisJob";
    public static String ProcessarSaldoContabilJob = "ProcessarSaldoContabilJob";
    public static String RotinaDiariaCancelamentoCartaoVencidoJob = "RotinaDiariaCancelamentoCartaoVencidoJob";
    public static String ImportarArquivoAcordosRealizadosEasyCollectorJob = "ImportarArquivoAcordosRealizadosEasyCollectorJob";
    public static String ProcessarArquivoAcordosRealizadosEasyCollectorJob = "ProcessarArquivoAcordosRealizadosEasyCollectorJob";
    public static String ImportarArquivoPagamentosRealizadosEasyCollectorJob = "ImportarArquivoPagamentosRealizadosEasyCollectorJob";
    public static String ProcessarArquivoPagamentosRealizadosEasyCollectorJob = "ProcessarArquivoPagamentosRealizadosEasyCollectorJob";
    public static String RotinaDiariaReprovaPropostasPendentes = "RotinaDiariaReprovaPropostasPendentes";
    public static String ProcessarEnvioPropostaLoteJob = "ProcessarEnvioPropostaLoteJob";
    public static String RotinaDiariaGerarArquivoLoteCartoes = "RotinaDiariaGerarArquivoLoteCartoes";
    public static String RotinaDiarioCancelamentoCreditoPromocional = "RotinaDiarioCancelamentoCreditoPromocional";
    public static String GerarArquivoPagamentosDecredJob = "GerarArquivoPagamentosDecredJob";
    public static String GerarArquivoContasDecredJob = "GerarArquivoContasDecredJob";
    public static String GerarArquivoClubeNetPointsJob = "GerarArquivoClubeNetPointsJob";
    public static String ProcessamentoArquivoClubeNetpointsJob = "ProcessamentoArquivoClubeNetpointsJob";
    public static String GerarArquivoPontuacaoNetpointsJob = "GerarArquivoPontuacaoNetpointsJob";
    public static String ProcessamentoPontuacaoNetpointsJob = "ProcessamentoPontuacaoNetpointsJob";
    public static String RotinaDiariaOcorrenciasVencidasJob = "RotinaDiariaOcorrenciasVencidasJob";
    public static String RotinaDiariaAtivarFaturaDigitalJob = "RotinaDiariaAtivarFaturaDigitalJob";
    public static String RotinaDiariaAtivarFaturaPorSMSJob = "RotinaDiariaAtivarFaturaPorSMSJob";
    public static String RotinaDiariaCancelarFaturaDigitalEmailJob = "RotinaDiariaCancelarFaturaDigitalEmailJob";
    public static String RotinaDiariaAlteracaoVinculoProduto = "RotinaDiariaAlteracaoVinculoProduto";
    public static String RotinaDiariaAlteracaoLimiteExtra = "RotinaDiariaAlteracaoLimiteExtra";
    public static String RotinaDiariaAlteracaoLimiteRotativoFTPJob = "RotinaDiariaAlteracaoLimiteRotativoFTPJob";
    public static String RotinaDiariaAlteracaoLimiteParceladoFTPJob = "RotinaDiariaAlteracaoLimiteParceladoFTPJob";
    public static String RotinaDiariaLancamentoAjusteLote = "RotinaDiariaLancamentoAjusteLote";
    public static String RotinaDiariaPagamentoFaturaRepasseJob = "RotinaDiariaPagamentoFaturaRepasseJob";
    public static String RotinaDiariaEnvioCredenciamentoResomaqJob = "RotinaDiariaEnvioCredenciamentoResomaqJob";
    public static String RotinaDiariaRetornoCredenciamentoResomaqJob = "RotinaDiariaRetornoCredenciamentoResomaqJob";
    public static String RotinaDiariaProcessarClientesParaBonificacaoJob = "RotinaDiariaProcessarClientesParaBonificacaoJob";
    public static String ConsigLogProcessarCargaConsumoCartaoJob = "ConsigLogProcessarCargaConsumoCartaoJob";
    public static String ConsigLogProcessarArquivoCargaTransacaoJob = "ConsigLogProcessarArquivoCargaTransacaoJob";
    public static String ConsigLogProcessarArquivoRetornoJob = "ConsigLogProcessarArquivoRetornoJob";
    public static String RotinaDiariaRemessaAnuidadeBonificadaJob = "RotinaDiariaRemessaAnuidadeBonificadaJob";
    public static String RotinaDiariaRetornoRemessaAnuidadeBonificadaJob = "RotinaDiariaRetornoRemessaAnuidadeBonificadaJob";
    public static String RotinaDiariaConciliacaoFaturaRepasseJob = "RotinaDiariaConciliacaoFaturaRepasseJob";
    public static String AtualizacaoDadosCadastraisCobransaasJob = "AtualizacaoDadosCadastraisCobransaasJob";
    public static String EnviarInadimplentesCobransaasJob = "EnviarInadimplentesCobransaasJob";
    public static String EnviarCreliqCobransaasJob = "EnviarCreliqCobransaasJob";
    public static String RotinaDiariaIncluirTelefonesClientesJob = "RotinaDiariaIncluirTelefonesClientesJob";
    public static String RotinaDiariaEnviarAlteracaoCicloSeguradoraApiJob = "RotinaDiariaEnviarAlteracaoCicloSeguradoraApiJob";
    public static String RotinaDiariaProcessamentoEncerramentoSegurosJob = "RotinaDiariaProcessamentoEncerramentoSegurosJob";
    public static String RotinaAtualizaViewDiasAtraso = "RotinaAtualizaViewDiasAtraso";
    public static String RotinaDiariaExpiracaoSaldoReservaJob = "RotinaDiariaExpiracaoSaldoReservaJob";
    public static String RotinaApropriacaoDiariaRotativoJob = "RotinaApropriacaoDiariaRotativoJob";
    public static String RotinaDiariaConciliacaoResomaq = "RotinaDiariaConciliacaoResomaq";
    public static String RotinaApropriacaoDiariaVendaJob	 = "RotinaApropriacaoDiariaVendaJob	";
    public static String RotinaApropriacaoDiariaParcelamentoFaturaJob	 = "RotinaApropriacaoDiariaParcelamentoFaturaJob	";
    public static String RotinaAuthCardsApi	 = "RotinaAuthCardsApi	";
    public static String RotinaCotacao	 = "RotinaCotacao	";
    public static String RotinaDiariaCancelarSegurosClientesEmCobrancaSeguradoraApi	 = "RotinaDiariaCancelarSegurosClientesEmCobrancaSeguradoraApi	";
    public static String RotinaDiariaPagamentoLancamentoSeguroApiJob	 = "RotinaDiariaPagamentoLancamentoSeguroApiJob	";

    private Integer idexecucaojob;
    private Date dataexecucao;
    private String descricao;
    private String status;
    private String nomejob;
    private String version;
    private String emissor;

    public List<String> listaNomesJobsCobranca (){
        List<String> jobs = new ArrayList<>();
        jobs.add(ExecucaoJob.AtualizacaoDadosCadastraisCobransaasJob);
        jobs.add(ExecucaoJob.AtualizarDividaInadimplentesPosCorteJob);
        jobs.add(ExecucaoJob.EnviarClientesParaCobrancaJob);
        jobs.add(ExecucaoJob.EnviarContasCobrancaJob);
        jobs.add(ExecucaoJob.GerarArquivoCadastralEasyCollectorJob);
        jobs.add(ExecucaoJob.GerarArquivoCadastralWedooJob);
        jobs.add(ExecucaoJob.RotinaDiariaCobrancaJob);
        jobs.add(ExecucaoJob.RotinaDiariaCobrancaInadimplenteJob);
        jobs.add(ExecucaoJob.RotinaDiariaProcessamentoSPCRetorno);
        jobs.add(ExecucaoJob.RotinaDiariaValidaEnvioSPCporTaxas);
        jobs.add(ExecucaoJob.RetirarClientesSPCJob);
        jobs.add(ExecucaoJob.EnviarClientesSPCJob);
        jobs.add(ExecucaoJob.GerarArquivoFinanceiroEasyCollectorJob);
        jobs.add(ExecucaoJob.ImportarArquivoAcordosRealizadosEasyCollectorJob);
        jobs.add(ExecucaoJob.ProcessarArquivoAcordosRealizadosEasyCollectorJob);
        jobs.add(ExecucaoJob.ImportarArquivoPagamentosRealizadosEasyCollectorJob);
        jobs.add(ExecucaoJob.ProcessarArquivoPagamentosRealizadosEasyCollectorJob);
        jobs.add(ExecucaoJob.EnviarInadimplentesCobransaasJob);
        jobs.add(ExecucaoJob.EnviarCreliqCobransaasJob);
        jobs.add(ExecucaoJob.BloqueioContasAtrasoJob);

      return jobs;

    }

    @Autowired
    public String ToString(){
        return "Nome Job: "+this.nomejob+"\nDescrição do erro: "+this.descricao;
    }

}
