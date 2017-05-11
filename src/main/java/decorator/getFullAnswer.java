package decorator;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Specializes;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Specializes
@Model
public class getFullAnswer extends getShortAnswer{

    public String getAnswer(){
        return "this is a long long long long long answer";
    }
}
