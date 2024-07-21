import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {

        exchangeApi.getInfo2 ("20240718");
//        System.out.println("===결과=== : " + info);

        /*[issue]
            리턴값을 받으면 connect error 발생...
            어떻게 해결해야할지 고민필요..
        */
        /*
        // JSON 문자열
        String jsonString = "[{\"result\":1,\"cur_unit\":\"AED\",\"ttb\":\"372.35\",\"tts\":\"379.88\",\"deal_bas_r\":\"376.12\",\"bkpr\":\"376\",\"yy_efee_r\":\"0\",\"ten_dd_efee_r\":\"0\",\"kftc_bkpr\":\"376\",\"kftc_deal_bas_r\":\"376.12\",\"cur_nm\":\"아랍에미리트 디르함\"},{\"result\":1,\"cur_unit\":\"AUD\",\"ttb\":\"920.38\",\"tts\":\"938.97\",\"deal_bas_r\":\"929.68\",\"bkpr\":\"929\",\"yy_efee_r\":\"0\",\"ten_dd_efee_r\":\"0\",\"kftc_bkpr\":\"929\",\"kftc_deal_bas_r\":\"929.68\",\"cur_nm\":\"호주 달러\"}]";

        // JSON 배열로 변환
        JSONArray jsonArray = new JSONArray(jsonString);

        // "cur_unit"이 "AED"인 항목 찾기
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if ("AED".equals(jsonObject.getString("cur_unit"))) {
                System.out.println(jsonObject.toString());
            }
        }
         */
    }
}
