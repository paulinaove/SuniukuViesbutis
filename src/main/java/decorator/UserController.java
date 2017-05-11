package decorator;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Model
public class UserController {

    @Inject
    private User user;

    @Inject
    private AnswerService answerService;

    public String grazinkAlternatyva(){

        String answer = user.getRights();
        System.out.println(answer);

        return answer;
    }

    public String grazinkSpecializes(){
        return answerService.getAnswer();
    }
}
