package map.busan.animal.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
public class testController {

    @GetMapping("test")
    public String test() throws UnsupportedEncodingException {
        // API endpoint for public data in Korea
        String url = "http://apis.data.go.kr/6260000/BusanAnimalHospService/getTblAnimalHospital";

        // API parameters
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("serviceKey", URLEncoder.encode("3LkZCX2iLmCkelmjUIVD6Tjj+omiGmfSAT9Bs3L2Wyxuxte9b2CLEV0sChJnvjpRGunBIcLzm8IEXt91Kpxppg==", "UTF-8"));
        params.add("numOfRows", "10");
        params.add("pageNo", "1");

        // Build the URL with the parameters
        String apiUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(params)
                .build()
                .toUriString();

        // Create a new instance of the RestTemplate class
        RestTemplate restTemplate = new RestTemplate();

        // Send a GET request to the API endpoint
        String response = restTemplate.getForObject(apiUrl, String.class);

        // Print the API response
        System.out.println(response);
        System.out.println("testOk");
        return "ok";
    }

}