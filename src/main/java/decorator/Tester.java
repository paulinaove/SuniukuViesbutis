package decorator;

import javax.enterprise.inject.Alternative;

/**
 * Created by paulinaoveraite on 2017-05-11.
 */
@Alternative
public class Tester implements User {
    @Override
    public String getRights() {
        return "tester";
    }
}
