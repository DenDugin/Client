package generator.Sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import generator.Message.Message;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Sender implements Runnable {


    private HttpHeaders headers;
    private Integer id;
    private Properties property;

    public Sender(Integer id, Properties property) {
        this.id = id;
        this.property = property;
    }


    public void sendPost() throws JsonProcessingException {

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept( Arrays.asList(MediaType.APPLICATION_XML) );

        Integer target;

        if ( id <= 100 ) target = 1;
        else if ( id > 100 && id <= 200 ) target = 2;
        else if ( id > 200 && id <= 300 ) target = 3;
        else if ( id > 300 && id <= 400 ) target = 4;
        else if ( id > 400 && id <= 500 ) target = 5;
        else if ( id > 500 && id <= 600 ) target = 6;
        else if ( id > 600 && id <= 700 ) target = 7;
        else if ( id > 700 && id <= 800 ) target = 8;
        else if ( id > 800 && id <= 900 ) target = 9;
        else target = 10;

        // Random target
       // target = new Random().nextInt((10 - 1) + 1) + 1;

        Message message = new Message(target, "Need taxi", id);

        String url = property.getProperty("dispatcher.host") + property.getProperty("dispatcher.api");

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(message);
        //System.out.println(xml);

        RestTemplate rest = new RestTemplate();

        HttpEntity<String> entityReq = new HttpEntity<String>(xml, headers);

        ResponseEntity<String> response = rest.postForEntity(url, entityReq, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Return https status not OK!");
        }
        else {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date date = new Date();

            System.out.println("Response : " + dateFormat.format(date) +" for clinet_id : " + id);
            System.out.println("Dispt id : "+ response.getBody());
        }

    };


    public void run() {

        try {
          sendPost();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
