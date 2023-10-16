package com.codingrecipe.service;

import com.codingrecipe.dto.FoodDTO;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class ApiService {


    public List<FoodDTO> foodserch(String fdname) {
        List<FoodDTO> foodDTO = new ArrayList<>();


        String result = "";
        String fdimgurl = "";

        // 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder(
                "http://apis.data.go.kr/B553748/CertImgListService/getCertImgListService"); /* URL */
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.

        try {
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
                    + "=cDjlzMPykeL%2FTtJ2zwFLtrZgvfAKj1nu2%2B%2FQ6lTSepgjCvojmAu3ip241lMDXNa1YRfhWigKDqAj%2FgKKKj2jbw%3D%3D");

            /* Service Key */
            // urlBuilder.append("&" + URLEncoder.encode("prdlstReportNo","UTF-8") + "=" +
            // URLEncoder.encode("201704760012", "UTF-8")); /*제품에 부여되는 고유식별번호*/
            urlBuilder.append(
                    "&" + URLEncoder.encode("prdlstNm", "UTF-8") + "=" + URLEncoder.encode(fdname, "UTF-8")); /* 제품명 */
            urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
                    + URLEncoder.encode("json", "UTF-8")); /* 결과 응답 형식 xml json */
            urlBuilder.append(
                    "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
                    + URLEncoder.encode("", "UTF-8")); /* 한 페이지 결과 수 */
            // 3. URL 객체 생성.
            URL url;
            url = new URL(urlBuilder.toString());

            // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 5. 통신을 위한 메소드 SET.
            conn.setRequestMethod("GET");
            // 6. 통신을 위한 Content-type SET.
            conn.setRequestProperty("Content-type", "application/json");
            // 7. 통신 응답 코드 확인.
            //System.out.println("Response code: " + conn.getResponseCode());
            // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
            StringBuilder sb = new StringBuilder();
            String line;

            // 소스추가

            while ((line = rd.readLine()) != null) {
                sb.append(line);
                result = line;
                //System.out.println("line : " + line);
            }

            //System.out.println("result : "+result);
            rd.close();
            conn.disconnect();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String str = "";
        // JSON parser 만들어 문자열 데이터를 객체화한다.
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(result);

            //System.out.println(obj);


            JSONObject obj2 = (JSONObject) obj.get("body");

            //System.out.println("ob2: " + obj2);

            // objSONArray 를 사용하여 내부 데이터를 Array 형태로 바꿔주고,
            // 바뀐 Array 안의 i ndex 마다 다시 JSONObject로 변환해준다. 그 뒤의 과정은 위에서 했던 것과 동일하다.

            JSONArray obj3 = (JSONArray) obj2.get("items");

            //System.out.println("ob3: " + obj3);

            //반복문 돌리면서 제품별 정보 리스트에 추가
            for (int i = 0; i < obj3.size(); i++) {

                // System.out.println("ob4: "+obj4);
                // System.out.println("obj3 get :" + obj3.get(0));
                JSONObject obj4 = (JSONObject) obj3.get(i);
                //System.out.println("ob4: " + obj4);
                JSONObject obj9 = (JSONObject) obj4.get("item");
                // System.out.println("obj9" + obj9);
                String obj10 = (String) obj9.get("imgurl1");
                //System.out.println(obj10);
                str = obj10;
                FoodDTO foodDTO1 = new FoodDTO();


                foodDTO1.setManufacture((String) obj9.get("manufacture"));
                foodDTO1.setNutri((String) obj9.get("rawmtrl"));
                foodDTO1.setImg((String) obj9.get("imgurl1"));
                foodDTO1.setName((String) obj9.get("prdlstNm"));
                foodDTO.add(foodDTO1);

            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 주소 리턴
        //fdimgurl = str;

        //return fdimgurl;

        return foodDTO;

    }


}
