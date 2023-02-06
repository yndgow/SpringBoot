package map.busan.animal.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import map.busan.animal.hospital.vo.ItemVO;
import map.busan.animal.hospital.vo.ResultVO;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class MainController {

    @GetMapping(value = {"/", "index"})
    public String index(Model model) {
        // api 정보
        String apiURL = "http://apis.data.go.kr/6260000/BusanAnimalHospService/getTblAnimalHospital";
        String serviceKey = "3LkZCX2iLmCkelmjUIVD6Tjj%2BomiGmfSAT9Bs3L2Wyxuxte9b2CLEV0sChJnvjpRGunBIcLzm8IEXt91Kpxppg%3D%3D";

        String resultType = "json";
        String pageNo = "1";
        String numOfRows = "1000"; // 부산시 전체 동물병원 279

        URI uri = UriComponentsBuilder
                    .fromUriString(apiURL)
                    .queryParam("serviceKey", serviceKey)
                    .queryParam("resultType", resultType)
                    .queryParam("pageNo", pageNo)
                    .queryParam("numOfRows", numOfRows)
                    .encode()
                    .build(true)
                    .toUri();

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(uri, String.class);

        //System.out.println(uri);

        // JSON 파싱(Deserialization)
        ObjectMapper om = new ObjectMapper();
        try{
            ResultVO resultVO = om.readValue(jsonData, ResultVO.class);
            List<ItemVO> items = resultVO.getGetTblAnimalHospital().getBody().getItems().getItem();
            //System.out.println(items);

            model.addAttribute("items", items);

        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "index";
    }
}
