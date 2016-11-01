package scheduler.sundial;

import org.knowm.sundial.SundialJobScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.service.Service;
import ratpack.service.StartEvent;
import ratpack.service.StopEvent;

class SundialService implements Service {
    private final static Logger LOG = LoggerFactory.getLogger(SundialService.class);

    @Override
    public void onStart(StartEvent event) throws Exception {
        if (!event.isReload()) {
            LOG.info("STARTING UP");
            init();
        }
        else {
            LOG.info("RESTART ON START");
        }
    }

    @Override
    public void onStop(StopEvent event) throws Exception {
        if (!event.isReload()) {
            LOG.info("SHUTTING DOWN");
            close();
        }
        else {
            LOG.info("RESTART ON STOP");
        }
    }

    private void init() {
        SundialJobScheduler.startScheduler("scheduler.jobs"); // package with annotated Jobs
    }

    private void close() {
        SundialJobScheduler.shutdown();
    }
}
