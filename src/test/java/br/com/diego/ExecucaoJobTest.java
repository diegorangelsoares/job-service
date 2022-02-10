package br.com.diego;

import br.com.diego.model.ExecucaoJob;
import br.com.diego.service.ExecucaoJobService;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ExecucaoJobTest extends TestCase {

    public void execucaoJobTest(){
        ExecucaoJob execucaoJob = new ExecucaoJob();
        execucaoJob.setNomejob("EnviarCreliqCobransaasJob");
        assertEquals(execucaoJob.getNomejob(), "EnviarCreliqCobransaasJob");
    }

}
