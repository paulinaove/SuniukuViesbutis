package decorator;

import javax.enterprise.inject.Model;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Model
public class getShortAnswer implements AnswerService {

    public String getAnswer(){
        return "this is a short answer";
    }
}
