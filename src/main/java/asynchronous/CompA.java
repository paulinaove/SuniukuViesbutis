package asynchronous;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@ApplicationScoped
public class CompA implements Serializable {

    @Inject
    private CompB compB;

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String answer;

    private Future<String> resultInFuture = null;

    public void callAsyncMethod() throws Exception {
        if (resultInFuture == null) {
            resultInFuture = compB.asyncMethod(getId());
            answer= "I just have called CompB. Result is ready? " + resultInFuture.isDone();
        } else {
            if (resultInFuture.isDone()) {
                String result = resultInFuture.get();
                resultInFuture = null;
                answer= "Result is finally ready, and it is: " + result;
            } else {
                answer= "Result is not yet ready... please wait a moment...";
            }
        }
    }

}
