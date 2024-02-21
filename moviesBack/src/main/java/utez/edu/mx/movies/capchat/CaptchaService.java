package utez.edu.mx.movies.capchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CaptchaService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${CaptchaSiteKey}")
    private String siteKey;

    @Value("${captChaKey}")
    private String captChaKey;

    @Value("${friendlyUrl}")
    private String url;

    Public CaptchaResponse verificarCaptcha(String solution){

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    Map<String,String> requestBody= new HashMap<>();
    requestBody.put("solution",solution);
    requestBody.put("secret",captChaKey);
    requestBody.put("siteKey",siteKey);

    HttpEntity<Map<String,String>>reqEntity=
            new HttpEntity<>(requestBody,headers);

    ResponseEntity<CaptchaDTO> respEntity
    }






}
