//package com.test.demo;
//
//import cn.gmssl.jce.provider.GMJCE;
//import cn.gmssl.jsse.provider.GMJSSE;
//import lombok.Data;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import javax.net.ssl.*;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.security.Security;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//@SpringBootTest
//class StApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//
//    @Test
//    void test() {
//        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
//        Param param = new Param();
//        param.setAction("refuse");
//        param.setSessionID("123");
//
////        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1,SSLv3");
//        // 需要国密SDK
//        Security.insertProviderAt(new GMJCE(), 1);
//        Security.insertProviderAt(new GMJSSE(), 2);
//
//        ResponseEntity<String> mapResponseEntity = restTemplate.postForEntity("https://。。IP。。/--auth-pre--/aaa/session/kill", param, String.class);
//        System.out.println(mapResponseEntity.getStatusCodeValue());
//        System.out.println(mapResponseEntity.getBody());
//
//    }
//
//    @Data
//    private class Param {
//        private String Action;
//
//        private String SessionID;
//    }
//
//
//    private class HttpsClientRequestFactory extends SimpleClientHttpRequestFactory {
//
//        @Override
//        protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
//            try {
//                if (!(connection instanceof HttpsURLConnection)) {
//                    super.prepareConnection(connection, httpMethod);
//                    ; // 非强制https
//                    return;
//                }
//
//                HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
//
//                TrustManager[] trustAllCerts = new TrustManager[]{
//                        new X509TrustManager() {
//                            @Override
//                            public X509Certificate[] getAcceptedIssuers() {
//                                return null;
//                            }
//
//                            @Override
//                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//                                return;
//                            }
//
//                            @Override
//                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                                // TODO 需要验证服务器证书
//                                return;
//                            }
//
//                        }
//                };
//
//                SSLContext sslContext = SSLContext.getInstance(GMJSSE.GMSSLv11, GMJSSE.NAME);
//                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//
//                httpsConnection.setSSLSocketFactory(new PreferredCipherSuiteSSLSocketFactory(sslContext.getSocketFactory()));
//                httpsConnection.setHostnameVerifier(new HostnameVerifier() {
//                    @Override
//                    public boolean verify(String s, SSLSession sslSession) {
//                        return true;
//                    }
//                });
//
//                super.prepareConnection(httpsConnection, httpMethod);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//
//    private static class PreferredCipherSuiteSSLSocketFactory extends SSLSocketFactory {
//
//        private static final String PREFERRED_CIPHER_SUITE = "ECC_SM4_CBC_SM3";
//
//        private final SSLSocketFactory delegate;
//
//        public PreferredCipherSuiteSSLSocketFactory(SSLSocketFactory delegate) {
//
//            this.delegate = delegate;
//        }
//
//        @Override
//        public String[] getDefaultCipherSuites() {
//
//            return setupPreferredDefaultCipherSuites(this.delegate);
//        }
//
//        @Override
//        public String[] getSupportedCipherSuites() {
//
//            return setupPreferredSupportedCipherSuites(this.delegate);
//        }
//
//        @Override
//        public Socket createSocket(String arg0, int arg1) throws IOException, UnknownHostException {
//
//            Socket socket = this.delegate.createSocket(arg0, arg1);
//            String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
//            ((SSLSocket) socket).setEnabledCipherSuites(cipherSuites);
//
//            return socket;
//        }
//
//        @Override
//        public Socket createSocket(InetAddress arg0, int arg1) throws IOException {
//
//            Socket socket = this.delegate.createSocket(arg0, arg1);
//            String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
//            ((SSLSocket) socket).setEnabledCipherSuites(cipherSuites);
//
//            return socket;
//        }
//
//        @Override
//        public Socket createSocket(Socket arg0, String arg1, int arg2, boolean arg3) throws IOException {
//
//            Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
//            String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
//            ((SSLSocket) socket).setEnabledCipherSuites(cipherSuites);
//
//            return socket;
//        }
//
//        @Override
//        public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3) throws IOException, UnknownHostException {
//
//            Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
//            String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
//            ((SSLSocket) socket).setEnabledCipherSuites(cipherSuites);
//
//            return socket;
//        }
//
//        @Override
//        public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2, int arg3) throws IOException {
//
//            Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
//            String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
//            ((SSLSocket) socket).setEnabledCipherSuites(cipherSuites);
//
//            return socket;
//        }
//
//        private static String[] setupPreferredDefaultCipherSuites(SSLSocketFactory sslSocketFactory) {
//            ArrayList<String> suitesList = new ArrayList<String>(Arrays.asList(new String[]{PREFERRED_CIPHER_SUITE}));
//            return suitesList.toArray(new String[suitesList.size()]);
//        }
//
//        private static String[] setupPreferredSupportedCipherSuites(SSLSocketFactory sslSocketFactory) {
//            ArrayList<String> suitesList = new ArrayList<String>(Arrays.asList(new String[]{PREFERRED_CIPHER_SUITE}));
//            return suitesList.toArray(new String[suitesList.size()]);
//        }
//    }
//}
