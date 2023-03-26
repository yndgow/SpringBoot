package map.busan.animal.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import map.busan.animal.hospital.vo.ItemVO;
import map.busan.animal.hospital.vo.ResultVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class testController {

    @GetMapping("test")
    public String test(Model model) throws UnsupportedEncodingException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://apis.data.go.kr/6260000/BusanAnimalHospService/getTblAnimalHospital")
                .queryParam("serviceKey", "3LkZCX2iLmCkelmjUIVD6Tjj%2BomiGmfSAT9Bs3L2Wyxuxte9b2CLEV0sChJnvjpRGunBIcLzm8IEXt91Kpxppg%3D%3D")
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "10");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("serviceKey", "3LkZCX2iLmCkelmjUIVD6Tjj%2BomiGmfSAT9Bs3L2Wyxuxte9b2CLEV0sChJnvjpRGunBIcLzm8IEXt91Kpxppg%3D%3D");
        params.add("pageNo", "1");
        params.add("numOfRows", "10");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(builder.toUriString(), request, String.class);

        // Print the API response
        System.out.println(builder.toUriString());
        System.out.println(response);
        // JSON 파싱(Deserialization)
        ObjectMapper om = new ObjectMapper();
        try{
            ResultVO resultVO = om.readValue(response, ResultVO.class);
            List<ItemVO> items = resultVO.getGetTblAnimalHospital().getBody().getItems().getItem();
            System.out.println(items);

            model.addAttribute("items", items);

        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "index";
    }

}