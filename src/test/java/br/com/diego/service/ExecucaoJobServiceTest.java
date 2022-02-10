package br.com.diego.service;

import br.com.diego.model.ExecucaoJob;
import br.com.diego.repository.ExecucaoJobRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Tag("service")
@DisplayName("Testes da classe ContestacaoService")
@ExtendWith(MockitoExtension.class)
public class ExecucaoJobServiceTest {

    @Mock
    private ExecucaoJobRepository execucaoJobRepository;

    @Test
    @DisplayName("busca Por Nome")
    void buscarPorNome() {

        ExecucaoJob execucaoJob = new ExecucaoJob();
        execucaoJob.setNomejob("EnviarCreliqCobransaasJob");

//        Mockito.when(execucaoJobRepository.(10L))
//                .thenReturn(Optional.of(execucaoJob));
//        ExecucaoJob execucaoJob = execucaoJobRepository.getById(10L);
//
//        Assertions.assertEquals(contestation, teste);
//        Assertions.assertEquals("diego", execucaoJobRepository.getById(10L).getCustomer().getCustomerName());

    }


}
