package com.webapps.tss.samplejobrunr;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JobAvisandoAppIniciado implements ApplicationListener<ApplicationReadyEvent> {

    Logger logger = Logger.getLogger(JobAvisandoAppIniciado.class.getName());

    private final String cron;
    private final JobScheduler jobScheduler;
    private final ServiceEnviaEmail serviceEnviaEmail;

    public JobAvisandoAppIniciado(@Value("*/10 * * * * *") String cron1, JobScheduler jobScheduler, ServiceEnviaEmail serviceEnviaEmail) {
        this.cron = cron1;
        this.jobScheduler = jobScheduler;
        this.serviceEnviaEmail = serviceEnviaEmail;
        logger.info("JobAvisandoAppIniciado instanciado");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("JobAvisandoAppIniciado.onApplicationEvent");
        jobScheduler.<ServiceEnviaEmail>scheduleRecurrently(
                "enviaEmail",
                this.cron,
                this::run
        );
    }

    public void run() {
        logger.info("JobAvisandoAppIniciado.run");
        this.serviceEnviaEmail.enviaEmail("tss@gmail.com", "Aplicacao iniciada");
    }
}
