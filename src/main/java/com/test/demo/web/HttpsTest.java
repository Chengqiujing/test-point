package com.test.demo.web;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: HttpsTest.java
 * @包 路 径： com.test.demo.web
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/14 10:20
 */
public class HttpsTest {

    private static String url = "";

    public static void main(String[] args) {

        TerminalSecurityDTO terminalSecurityDTO = new TerminalSecurityDTO();
        terminalSecurityDTO.setId("123");

        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        ResponseEntity<Map> mapResponseEntity = restTemplate.postForEntity(url, terminalSecurityDTO, Map.class);
        System.out.println(mapResponseEntity);


    }


    @Data
    public static class TerminalSecurityDTO {
        /**
         * 终端设备唯一识别号，UUIDv4
         */
        private String id;

    }


    public static class HttpsClientRequestFactory extends SimpleClientHttpRequestFactory {

        @Override
        protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
            try {
                if (!(connection instanceof HttpsURLConnection)) {
//                throw new RuntimeException("An instance of HttpsURLConnection is expected");
                    return; // 非强制https
                }

                HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;

                TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }
                            @Override
                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                                return;
                            }
                            @Override
                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                                try {
                                    MyTrustManagerBuilder.validator(certs[0]);
                                } catch (CertificateException e) {
                                    e.printStackTrace();
                                }
                                return;
                            }

                        }
                };


                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

                httpsConnection.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                });

                super.prepareConnection(httpsConnection, httpMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        public TrustManager[] getTrustManager() throws CertificateException {
//            try {
//                Security.addProvider(new BouncyCastleProvider());
//                InputStream resourceAsStream = MyTrustManagerBuilder.class.getClassLoader().getResourceAsStream("hatigong.cer");
////            TrustAnchor anchorRoot = new TrustAnchor(new X509CertImpl(resource.getInputStream()), null);
//                TrustAnchor anchorRoot = new TrustAnchor(new X509CertImpl(resourceAsStream), null);
//
//                Set<TrustAnchor> trustAnchors = new HashSet<>();
//                trustAnchors.add(anchorRoot);
//
//                PKIXParameters params = new PKIXParameters(trustAnchors);
//                params.setRevocationEnabled(false);
//                params.setExplicitPolicyRequired(true);
//
//                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X.509","BC");
//                trustManagerFactory.init(new CertPathTrustManagerParameters(params));
//                return trustManagerFactory.getTrustManagers();
//            } catch (CertificateException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
//                e.printStackTrace();
//            }
//            throw new CertificateException("无法获取根证书信任列表");
//        }


    }



    /**
     * We need to invoke sslSocket.setEnabledProtocols(new String[] {"SSLv3"});
     * see http://www.oracle.com/technetwork/java/javase/documentation/cve-2014-3566-2342133.html (Java 8 section)
     */
// SSLSocketFactory用于创建 SSLSockets
        private static class MyCustomSSLSocketFactory extends SSLSocketFactory {

        private final SSLSocketFactory delegate;

        public MyCustomSSLSocketFactory(SSLSocketFactory delegate) {
            this.delegate = delegate;
        }

        // 返回默认启用的密码套件。除非一个列表启用，对SSL连接的握手会使用这些密码套件。
        // 这些默认的服务的最低质量要求保密保护和服务器身份验证
        @Override
        public String[] getDefaultCipherSuites() {
            return delegate.getDefaultCipherSuites();
        }

        // 返回的密码套件可用于SSL连接启用的名字
        @Override
        public String[] getSupportedCipherSuites() {
            return delegate.getSupportedCipherSuites();
        }


        @Override
        public Socket createSocket(final Socket socket, final String host, final int port,
                                   final boolean autoClose) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(socket, host, port, autoClose);
            return overrideProtocol(underlyingSocket);
        }


        @Override
        public Socket createSocket(final String host, final int port) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final String host, final int port, final InetAddress localAddress,
                                   final int localPort) throws
                IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port, localAddress, localPort);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final InetAddress host, final int port) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final InetAddress host, final int port, final InetAddress localAddress,
                                   final int localPort) throws
                IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port, localAddress, localPort);
            return overrideProtocol(underlyingSocket);
        }

        private Socket overrideProtocol(final Socket socket) {
            if (!(socket instanceof SSLSocket)) {
                throw new RuntimeException("An instance of SSLSocket is expected");
            }
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1"});
            return socket;
        }
    }

}








