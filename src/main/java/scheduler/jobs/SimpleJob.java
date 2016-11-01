package scheduler.jobs;

import org.knowm.sundial.Job;
import org.knowm.sundial.annotations.CronTrigger;
import org.knowm.sundial.exceptions.JobInterruptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CronTrigger(cron = "0/5 * * * * ?")
@SuppressWarnings("unused")
public class SimpleJob extends Job {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleJob.class);

    @Override
    public void doRun() throws JobInterruptException {
        LOG.info("PONG!");
    }
}
