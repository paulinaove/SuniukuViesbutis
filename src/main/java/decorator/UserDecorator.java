package decorator;

import jpa.model.Suniukas;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Decorator
public class UserDecorator implements User {

    @Inject
    @Delegate
    @Any
    private User user;

    public String getRights(){

        System.out.print("The user have all the rights");

        return "The user have all the rights";
    }
}
