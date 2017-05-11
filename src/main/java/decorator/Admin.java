package decorator;

import javax.enterprise.inject.Alternative;
import javax.jws.soap.SOAPBinding;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Alternative
public class Admin implements User {

    @Override
    public String getRights() {
        return "admin";
    }
}
