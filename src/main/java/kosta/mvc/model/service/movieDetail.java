package kosta.mvc.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
 
public class movieDetail {
    public static StringBuilder sb;//
 
    public static void main(String[] args) {
    	
        String clientId = "";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";\
        int display = 5; // �˻��������. �ִ�100��
        try {
            String text = URLEncoder.encode("�󼼺���", "UTF-8");//�����ڵ�
            String apiURL = " http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api"
            		+ "/search_xml.jsp?collection=kmdb_new&detail=N&director="
            		+ "%EB%B0%95%EC%B0%AC%EC%9A%B1&ServiceKey=KADA8JG2N7IJF41LZK16";
            		// KADA8JG2N7IJF41LZK16
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Client-Id", clientId);
            con.setRequestProperty("Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { 
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { 
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            sb = new StringBuilder();
            String line;
 
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            con.disconnect();
            System.out.println(sb);
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
}

