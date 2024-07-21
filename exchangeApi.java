import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class exchangeApi {
//    public static void main(String[] args) {
//        String baseUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
//        String key = "suLzYgqRD4aUPYc3wgoKh2YQIDJxMN2y";
//
//        // 파라미터 설정
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("authkey", key); // OpenAPI 신청시 발급된 인증키
//        parameters.put("searchdate", "20240718"); // ex) 2015-01-01, 20150101, (DEFAULT)현재일
//        parameters.put("data", "AP01"); // AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리
//
//        try {
//            // 파라미터를 URL에 추가
//            String fullUrl = baseUrl + "?" + getParamsString(parameters);
//
//            // URL 객체 생성
//            URL obj = new URL(fullUrl);
//            HttpURLConnection con= (HttpURLConnection) obj.openConnection();
//
//            // GET 요청 설정
//            con.setRequestMethod("GET");
//
//            // 요청 헤더 설정 (지금은 필요없음)
//            //con.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            int responseCode = con.getResponseCode();
//            System.out.println("Response Code : " + responseCode);
//
//            // 응답 처리
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // 결과 출력
//            System.out.println(response.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    private static String baseUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
    private static String key = "suLzYgqRD4aUPYc3wgoKh2YQIDJxMN2y"; // OpenAPI 신청시 발급된 인증키
    private static String dataType = "AP01"; // AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리

    public static void getInfo2 (String date) {

        // 파라미터 설정
        Map<String, String> parameters = new HashMap<>();
        parameters.put("authkey", key); // OpenAPI 신청시 발급된 인증키
        parameters.put("searchdate", date); // ex) 2015-01-01, 20150101, (DEFAULT)현재일
        parameters.put("data", dataType); // AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리

        String result = "";

        try {
            // 파라미터를 URL에 추가
            String fullUrl = baseUrl + "?" + getParamsString(parameters);

            // URL 객체 생성
            URL obj = new URL(fullUrl);
            HttpURLConnection con= (HttpURLConnection) obj.openConnection();

            // GET 요청 설정
            con.setRequestMethod("GET");

            // 요청 헤더 설정 (지금은 필요없음)
            //con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            // 응답 처리
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 결과 출력
            System.out.println(response.toString());
            //result = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //return result;
    }

    // 파라미터 맵을 쿼리 문자열로 변환하는 메소드
    public static String getParamsString(Map<String, String> params) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }

}
