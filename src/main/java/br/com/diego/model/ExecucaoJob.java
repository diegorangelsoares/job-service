package br.com.diego.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExecucaoJob {

    public static String RotinaAlteracaoContaBancariaCliente = "com.neus.cards.business.job.RotinaAlteracaoContaBancariaCliente";
    public static String ProcessamentoParcelamentoFaturaJob = "com.neus.cards.business.job.ProcessamentoParcelamentoFaturaJob";
    public static String AtualizarDividaInadimplentesPosCorteJob = "com.neus.cards.business.job.AtualizarDividaInadimplentesPosCorteJob";
    public static String RotinaDiariaEnviarConfirmacaoCobrancaSeguradora = "com.neus.cards.business.job.RotinaDiariaEnviarConfirmacaoCobrancaSeguradora";
    public static String GerarArquivoBancarioJob = "com.neus.cards.business.job.GerarArquivoBancarioJob";
    public static String RotinaDiariaAtualizaViewsSGR = "com.neus.cards.business.job.RotinaDiariaAtualizaViewsSGR";
    public static String GerarArquivoGraficaJob = "com.neus.cards.business.job.GerarArquivoGraficaJob";
    public static String RotinaDiariaProcessamentoVendasCarne = "com.neus.cards.business.job.RotinaDiariaProcessamentoVendasCarne";
    public static String RegistrarAlertaFaturaPacoteSMSJob = "com.neus.cards.business.job.RegistrarAlertaFaturaPacoteSMSJob";
    public static String RegistrarAlertaFaturaDisponivelSMSJob = "com.neus.cards.business.job.RegistrarAlertaFaturaDisponivelSMSJob";
    public static String RegistrarAlertaFaturaDigitalEmailJob = "com.neus.cards.business.job.RegistrarAlertaFaturaDigitalEmailJob";
    public static String RegistrarAlertaFaturaJob = "com.neus.cards.business.job.RegistrarAlertaFaturaJob";
    public static String EnviarSMSJob = "com.neus.cards.business.job.EnviarSMSJob";
    public static String CorteConvenioJob = "com.neus.cards.business.job.CorteConvenioJob";
    public static String PagamentoRotativoSeguroJob = "com.neus.cards.business.job.PagamentoRotativoSeguroJob";
    public static String ProcessarIntegracaoSeguradoraJob = "com.neus.cards.business.job.ProcessarIntegracaoSeguradoraJob";
    public static String CorteConvenioJobJPA = "com.neus.cards.business.job.CorteConvenioJobJPA";
    public static String CorteAdicionalJob = "com.neus.cards.business.job.CorteAdicionalJob";
    public static String BloqueiaClienteCarnePorAtrasoJob = "com.neus.cards.business.job.BloqueiaClienteCarnePorAtrasoJob";
    public static String EnviarClientesParaCobrancaJob = "com.neus.cards.business.job.EnviarClientesParaCobrancaJob";
    public static String EnviarContasCobrancaJob = "com.neus.cards.business.job.EnviarContasCobrancaJob";
    public static String GerarArquivoCadastralEasyCollectorJob = "com.neus.cards.business.job.GerarArquivoCadastralEasyCollectorJob";
    public static String GerarArquivoCadastralWedooJob = "com.neus.cards.business.job.GerarArquivoCadastralWedooJob";
    public static String RotinaDiariaCobrancaJob = "com.neus.cards.business.job.RotinaDiariaCobrancaJob";
    public static String RotinaDiariaCobrancaInadimplenteJob = "com.neus.cards.business.job.RotinaDiariaCobrancaInadimplenteJob";
    public static String RotinaDiariaProcessamentoSPCRetorno = "com.neus.cards.business.job.RotinaDiariaProcessamentoSPCRetorno";
    public static String RotinaDiariaValidaEnvioSPCporTaxas = "com.neus.cards.business.job.RotinaDiariaValidaEnvioSPCporTaxas";
    public static String RetirarClientesSPCJob = "com.neus.cards.business.job.RetirarClientesSPCJob";
    public static String EnviarClientesSPCJob = "com.neus.cards.business.job.EnviarClientesSPCJob";
    public static String GerarArquivoFinanceiroEasyCollectorJob = "com.neus.cards.business.job.GerarArquivoFinanceiroEasyCollectorJob";
    public static String RotinaDiariaRepasseJob = "com.neus.cards.business.job.RotinaDiariaRepasseJob";
    public static String RotinaDiariaCancelamentoAcordoConvenioJob = "com.neus.cards.business.job.RotinaDiariaCancelamentoAcordoConvenioJob";
    public static String RotinaDiariaLimparTentativasLoginUsuariosJob = "com.neus.cards.business.job.RotinaDiariaLimparTentativasLoginUsuariosJob";
    public static String RotinaDiariaImpressaoContratoJob = "com.neus.cards.business.job.RotinaDiariaImpressaoContratoJob";
    public static String RotinaDiariaProcessarArquivoBancarioRetornoJob = "com.neus.cards.business.job.RotinaDiariaProcessarArquivoBancarioRetornoJob";
    public static String AtualizaRelatorioValoresRecebidosJob = "com.neus.cards.business.job.AtualizaRelatorioValoresRecebidosJob";
    public static String RotinaDiariaAniversarioLojaJob = "com.neus.cards.business.job.RotinaDiariaAniversarioLojaJob";
    public static String RotinaDiariaBloqDesbloqClientesJob = "com.neus.cards.business.job.RotinaDiariaBloqDesbloqClientesJob";
    public static String RotinaDiariaBloqDesbloqCartoesJob = "com.neus.cards.business.job.RotinaDiariaBloqDesbloqCartoesJob";
    public static String RotinaDiariaBloqueioCarne = "com.neus.cards.business.job.RotinaDiariaBloqueioCarne";
    public static String RotinaDiariaProcessarArquivoBancarioRemessaJob = "com.neus.cards.business.job.RotinaDiariaProcessarArquivoBancarioRemessaJob";
    public static String RotinaDiariaProcessaDebitosAtrasoCobrancaExternoJob = "com.neus.cards.business.job.RotinaDiariaProcessaDebitosAtrasoCobrancaExternoJob";
    public static String RotinaDiariaProcessarArquivoBancarioCobrancaJob = "com.neus.cards.business.job.RotinaDiariaProcessarArquivoBancarioCobrancaJob";
    public static String RotinaDiariaProcessamentoLoteLimiteCreditoJob = "com.neus.cards.business.job.RotinaDiariaProcessamentoLoteLimiteCreditoJob";
    public static String RotinaDiariaAgendamentoBloqueioLojaJob = "com.neus.cards.business.job.RotinaDiariaAgendamentoBloqueioLojaJob";
    public static String RotinaDiariaProcessaArquivoApresentacaoGoodCardJob = "com.neus.cards.business.job.RotinaDiariaProcessaArquivoApresentacaoGoodCardJob";
    public static String RotinaDiariaProcessaArquivoTrocaStatusGoodCardJob = "com.neus.cards.business.job.RotinaDiariaProcessaArquivoTrocaStatusGoodCardJob";
    public static String CancelaVendasGoodCardJob = "com.neus.cards.business.job.CancelaVendasGoodCardJob";
    public static String RotinaDiariaGeraArquivoBaseCartoesJob = "com.neus.cards.business.job.RotinaDiariaGeraArquivoBaseCartoesJob";
    public static String ProcessaLancamentosContabeisJob = "com.neus.cards.business.job.ProcessaLancamentosContabeisJob";
    public static String ProcessarSaldoContabilJob = "com.neus.cards.business.job.ProcessarSaldoContabilJob";
    public static String RotinaDiariaCancelamentoCartaoVencidoJob = "com.neus.cards.business.job.RotinaDiariaCancelamentoCartaoVencidoJob";
    public static String ImportarArquivoAcordosRealizadosEasyCollectorJob = "com.neus.cards.business.job.ImportarArquivoAcordosRealizadosEasyCollectorJob";
    public static String ProcessarArquivoAcordosRealizadosEasyCollectorJob = "com.neus.cards.business.job.ProcessarArquivoAcordosRealizadosEasyCollectorJob";
    public static String ImportarArquivoPagamentosRealizadosEasyCollectorJob = "com.neus.cards.business.job.ImportarArquivoPagamentosRealizadosEasyCollectorJob";
    public static String ProcessarArquivoPagamentosRealizadosEasyCollectorJob = "com.neus.cards.business.job.ProcessarArquivoPagamentosRealizadosEasyCollectorJob";
    public static String RotinaDiariaReprovaPropostasPendentes = "com.neus.cards.business.job.RotinaDiariaReprovaPropostasPendentes";
    public static String ProcessarEnvioPropostaLoteJob = "com.neus.cards.business.job.ProcessarEnvioPropostaLoteJob";
    public static String RotinaDiariaGerarArquivoLoteCartoes = "com.neus.cards.business.job.RotinaDiariaGerarArquivoLoteCartoes";
    public static String RotinaDiarioCancelamentoCreditoPromocional = "com.neus.cards.business.job.RotinaDiarioCancelamentoCreditoPromocional";
    public static String GerarArquivoPagamentosDecredJob = "com.neus.cards.business.job.GerarArquivoPagamentosDecredJob";
    public static String GerarArquivoContasDecredJob = "com.neus.cards.business.job.GerarArquivoContasDecredJob";
    public static String GerarArquivoClubeNetPointsJob = "com.neus.cards.business.job.GerarArquivoClubeNetPointsJob";
    public static String ProcessamentoArquivoClubeNetpointsJob = "com.neus.cards.business.job.ProcessamentoArquivoClubeNetpointsJob";
    public static String GerarArquivoPontuacaoNetpointsJob = "com.neus.cards.business.job.GerarArquivoPontuacaoNetpointsJob";
    public static String ProcessamentoPontuacaoNetpointsJob = "com.neus.cards.business.job.ProcessamentoPontuacaoNetpointsJob";
    public static String RotinaDiariaOcorrenciasVencidasJob = "com.neus.cards.business.job.RotinaDiariaOcorrenciasVencidasJob";
    public static String RotinaDiariaAtivarFaturaDigitalJob = "com.neus.cards.business.job.RotinaDiariaAtivarFaturaDigitalJob";
    public static String RotinaDiariaAtivarFaturaPorSMSJob = "com.neus.cards.business.job.RotinaDiariaAtivarFaturaPorSMSJob";
    public static String RotinaDiariaCancelarFaturaDigitalEmailJob = "com.neus.cards.business.job.RotinaDiariaCancelarFaturaDigitalEmailJob";
    public static String RotinaDiariaAlteracaoVinculoProduto = "com.neus.cards.business.job.RotinaDiariaAlteracaoVinculoProduto";
    public static String RotinaDiariaAlteracaoLimiteExtra = "com.neus.cards.business.job.RotinaDiariaAlteracaoLimiteExtra";
    public static String RotinaDiariaAlteracaoLimiteRotativoFTPJob = "com.neus.cards.business.job.RotinaDiariaAlteracaoLimiteRotativoFTPJob";
    public static String RotinaDiariaAlteracaoLimiteParceladoFTPJob = "com.neus.cards.business.job.RotinaDiariaAlteracaoLimiteParceladoFTPJob";
    public static String RotinaDiariaLancamentoAjusteLote = "com.neus.cards.business.job.RotinaDiariaLancamentoAjusteLote";
    public static String RotinaDiariaPagamentoFaturaRepasseJob = "com.neus.cards.business.job.RotinaDiariaPagamentoFaturaRepasseJob";
    public static String RotinaDiariaEnvioCredenciamentoResomaqJob = "com.neus.cards.business.job.RotinaDiariaEnvioCredenciamentoResomaqJob";
    public static String RotinaDiariaRetornoCredenciamentoResomaqJob = "com.neus.cards.business.job.RotinaDiariaRetornoCredenciamentoResomaqJob";
    public static String RotinaDiariaProcessarClientesParaBonificacaoJob = "com.neus.cards.business.job.RotinaDiariaProcessarClientesParaBonificacaoJob";
    public static String ConsigLogProcessarCargaConsumoCartaoJob = "com.neus.cards.business.job.ConsigLogProcessarCargaConsumoCartaoJob";
    public static String ConsigLogProcessarArquivoCargaTransacaoJob = "com.neus.cards.business.job.ConsigLogProcessarArquivoCargaTransacaoJob";
    public static String ConsigLogProcessarArquivoRetornoJob = "com.neus.cards.business.job.ConsigLogProcessarArquivoRetornoJob";
    public static String RotinaDiariaRemessaAnuidadeBonificadaJob = "com.neus.cards.business.job.RotinaDiariaRemessaAnuidadeBonificadaJob";
    public static String RotinaDiariaRetornoRemessaAnuidadeBonificadaJob = "com.neus.cards.business.job.RotinaDiariaRetornoRemessaAnuidadeBonificadaJob";
    public static String RotinaDiariaConciliacaoFaturaRepasseJob = "com.neus.cards.business.job.RotinaDiariaConciliacaoFaturaRepasseJob";
    public static String AtualizacaoDadosCadastraisCobransaasJob = "com.neus.cards.business.job.AtualizacaoDadosCadastraisCobransaasJob";
    public static String EnviarInadimplentesCobransaasJob = "com.neus.cards.business.job.EnviarInadimplentesCobransaasJob";
    public static String EnviarCreliqCobransaasJob = "com.neus.cards.business.job.EnviarCreliqCobransaasJob";
    public static String RotinaDiariaIncluirTelefonesClientesJob = "com.neus.cards.business.job.RotinaDiariaIncluirTelefonesClientesJob";
    public static String RotinaDiariaEnviarAlteracaoCicloSeguradoraApiJob = "com.neus.cards.business.job.RotinaDiariaEnviarAlteracaoCicloSeguradoraApiJob";
    public static String RotinaDiariaProcessamentoEncerramentoSegurosJob = "com.neus.cards.business.job.RotinaDiariaProcessamentoEncerramentoSegurosJob";
    public static String RotinaAtualizaViewDiasAtraso = "com.neus.cards.business.job.RotinaAtualizaViewDiasAtraso";
    public static String RotinaDiariaExpiracaoSaldoReservaJob = "com.neus.cards.business.job.RotinaDiariaExpiracaoSaldoReservaJob";
    public static String RotinaApropriacaoDiariaRotativoJob = "com.neus.cards.business.job.RotinaApropriacaoDiariaRotativoJob";
    public static String RotinaDiariaConciliacaoResomaq = "com.neus.cards.business.job.RotinaDiariaConciliacaoResomaq";
    public static String RotinaApropriacaoDiariaVendaJob	 = "com.neus.cards.business.job.RotinaApropriacaoDiariaVendaJob	";
    public static String RotinaApropriacaoDiariaParcelamentoFaturaJob	 = "com.neus.cards.business.job.RotinaApropriacaoDiariaParcelamentoFaturaJob	";
    public static String RotinaAuthCardsApi	 = "com.neus.cards.business.job.RotinaAuthCardsApi	";
    public static String RotinaCotacao	 = "com.neus.cards.business.job.RotinaCotacao	";
    public static String RotinaDiariaCancelarSegurosClientesEmCobrancaSeguradoraApi	 = "com.neus.cards.business.job.RotinaDiariaCancelarSegurosClientesEmCobrancaSeguradoraApi	";
    public static String RotinaDiariaPagamentoLancamentoSeguroApiJob	 = "com.neus.cards.business.job.RotinaDiariaPagamentoLancamentoSeguroApiJob	";

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

      return jobs;

    }

}
