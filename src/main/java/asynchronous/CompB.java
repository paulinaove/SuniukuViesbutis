package asynchronous;


import jpa.RescueOrAsync;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Future;

import lombok.Getter;
import lombok.Setter;
import org.apache.deltaspike.core.api.future.Futureable;

@ApplicationScoped
public class CompB implements Serializable {

    private final String USER_AGENT = "Mozilla/5.0";


    @Inject
    @RescueOrAsync           // Asinchroninis komponentas negali naudoti @RequestScoped konteksto
    private EntityManager em; // Jei šis komponentas turi dirbti su DB per JPA

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW) // be šios anotacijos negalėsime gauti @jpa.RescueOrAsync EntityManager
    public Future<String> asyncMethod(String id) throws Exception {
        System.out.println("CompB starts working on a big task...");
        try {
            Thread.sleep(10000); // sleep for 10 seconds
        } catch (InterruptedException e) {
        }
        System.out.println("Testing 1 - Send Http GET request " +id);
        String answer = sendGet(id);

        System.out.println("CompB: big task completed.");
        return new AsyncResult<>(answer);
    }

    // HTTP GET request
    private String sendGet(String id) throws Exception {

        String url = "http://localhost:8080/rest/suniukas/"+id;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return response.toString();

    }


}
