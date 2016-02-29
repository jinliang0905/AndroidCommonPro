package com.commonpro.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import com.google.gson.Gson;

public class HttpEngine {
    //App��Ӧ�ķ�������urlǰ׺
    private final static String SERVER_URL = "http://www.myserver.com/platform/api";
    private final static String REQUEST_MOTHOD = "POST";
    private final static String ENCODE_TYPE = "UTF-8";
    private final static int TIME_OUT = 15000;

    private static HttpEngine instance = null;

    private HttpEngine() {
    }

    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    public <T> T postHandle(Map<String, String> paramsMap, Type typeOfT) throws IOException {
        String data = joinParams(paramsMap);
        HttpURLConnection connection = getConnection();
        connection.setRequestProperty("Content-Length", String.valueOf(data.getBytes().length));
        connection.connect();
        OutputStream os = connection.getOutputStream();
        os.write(data.getBytes());
        os.flush();
        if (connection.getResponseCode() == 200) {
            // ��ȡ��Ӧ������������
            InputStream is = connection.getInputStream();
            // �����ֽ����������
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // �����ȡ�ĳ���
            int len = 0;
            // ���建����
            byte buffer[] = new byte[1024];
            // ���ջ������Ĵ�С��ѭ����ȡ
            while ((len = is.read(buffer)) != -1) {
                // ���ݶ�ȡ�ĳ���д�뵽os������
                baos.write(buffer, 0, len);
            }
            // �ͷ���Դ
            is.close();
            baos.close();
            connection.disconnect();
            // �����ַ���
            final String result = new String(baos.toByteArray());
            Gson gson = new Gson();
            return gson.fromJson(result, typeOfT);
        } else {
            connection.disconnect();
            return null;
        }
    }

    private HttpURLConnection getConnection() {
        HttpURLConnection connection = null;
        // ��ʼ��connection
        try {
            // ���ݵ�ַ����URL����
            URL url = new URL(SERVER_URL);
            // ����URL���������
            connection = (HttpURLConnection) url.openConnection();
            // ��������ķ�ʽ
            connection.setRequestMethod(REQUEST_MOTHOD);
            // ����POST������������������룬Ĭ��Ϊtrue
            connection.setDoInput(true);
            // ����POST������������������
            connection.setDoOutput(true);
            // ���ò�ʹ�û���
            connection.setUseCaches(false);
            // ��������ĳ�ʱʱ��
            connection.setReadTimeout(TIME_OUT);
            connection.setConnectTimeout(TIME_OUT);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Response-Type", "json");
            connection.setChunkedStreamingMode(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private String joinParams(Map<String, String> paramsMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : paramsMap.keySet()) {
            stringBuilder.append(key);
            stringBuilder.append("=");
            try {
                stringBuilder.append(URLEncoder.encode(paramsMap.get(key), ENCODE_TYPE));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            stringBuilder.append("&");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
