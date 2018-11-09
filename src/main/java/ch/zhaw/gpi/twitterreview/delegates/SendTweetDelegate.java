package ch.zhaw.gpi.twitterreview.delegates;

import ch.zhaw.gpi.twitterreview.services.TwitterService;
import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation des Service Task "Tweet senden"
 * 
 * @author murtaegz
 */
@Named("sendTweetAdapter")
public class SendTweetDelegate implements JavaDelegate {
    
    // Verdrahten von Twitterservice
    @Autowired
    private TwitterService twitterService;
    
    /**
     *  Postet einen Tweet mit dem gewünschten Text
     * 
     * @param de    Objekt, welches die Verknüpfung zur Process Engine und zur aktuellen Execution enthält
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution de) throws Exception {
        // Zu postender Text aus Prozessvariable lesen
        String tweetContent = (String) de.getVariable("tweetContent");

        // Dieser Text wird dem Twitter Service an die Methode updateStatus übergeben         
        twitterService.updateStatus(tweetContent); 
    }
    
}
