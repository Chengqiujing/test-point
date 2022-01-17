package com.test.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: MyTrustManagerBuilder.java
 * @包 路 径： com.test.demo.web
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/14 16:36
 */
@Slf4j
@Component
public class MyTrustManagerBuilder {

    @Value("classpath:bjca-trust.crt")
    Resource resource;

    public static TrustManager[] getTrustManager() throws CertificateException {
        try {
            Security.addProvider(new BouncyCastleProvider());
            String path = MyTrustManagerBuilder.class.getClassLoader().getResource("1111.cer").getPath();
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            CertificateFactory cf = CertificateFactory.getInstance("X.509","BC");
            CertPath certPath = cf.generateCertPath(fileInputStream, "PKCS7");

            TrustAnchor anchorRoot = new TrustAnchor((X509Certificate) certPath.getCertificates().get(0), null);

            Set<TrustAnchor> trustAnchors = new HashSet<>();
            trustAnchors.add(anchorRoot);

            PKIXBuilderParameters params = new PKIXBuilderParameters(trustAnchors, new X509CertSelector());
            params.setRevocationEnabled(false);
            params.setExplicitPolicyRequired(true);

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(new CertPathTrustManagerParameters(params));
            return trustManagerFactory.getTrustManagers();
        } catch (CertificateException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            log.error("获取根证书列表失败",e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new CertificateException("无法获取根证书信任列表");
    }


    public static void validator(Certificate certificate) throws CertificateException {
        try {
            Security.addProvider(new BouncyCastleProvider());

            // 客户端证书



            // 服务端证书
//            String path = MyTrustManagerBuilder.class.getClassLoader().getResource("ttt.cer").getPath();
            String path = "C:\\Users\\Administrator\\Desktop\\ttt.cer";
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            CertificateFactory cf = CertificateFactory.getInstance("X.509","BC");
            CertPath certPath = cf.generateCertPath(fileInputStream, "PKCS7");
            TrustAnchor anchorRoot = new TrustAnchor((X509Certificate) certPath.getCertificates().get(0), null);

            Set<TrustAnchor> trustAnchors = new HashSet<>();
            trustAnchors.add(anchorRoot);
            PKIXParameters params = new PKIXParameters(trustAnchors);
            params.setRevocationEnabled(false);




            CertPathValidator cpv = CertPathValidator.getInstance("PKIX","BC");
            PKIXCertPathValidatorResult result =
                    (PKIXCertPathValidatorResult) cpv.validate(test1((X509Certificate) certificate), params);

            System.out.println("result = " + result);
        } catch (CertificateException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            log.error("获取根证书列表失败",e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CertPathValidatorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new CertificateException("无法获取根证书信任列表");
    }

    private static CertPath test1(X509Certificate certificate) throws Exception {
        CertificateFactory cf = CertificateFactory.getInstance("X.509","BC");
        List<Certificate> certificates = new ArrayList<>();
        certificates.add(certificate);
        return cf.generateCertPath(certificates);

    }










    public X509TrustManager getX509TrustManager() throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, KeyManagementException {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // Using null here initialises the TMF with the default trust store.
        tmf.init((KeyStore) null);

        // Get hold of the default trust manager
        X509TrustManager defaultTm = null;
        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                defaultTm = (X509TrustManager) tm;
                break;
            }
        }

        FileInputStream myKeys = new FileInputStream("truststore.jks");

        // Do the same with your trust store this time
        // Adapt how you load the keystore to your needs
        KeyStore myTrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        myTrustStore.load(myKeys, "password".toCharArray());

        myKeys.close();

        tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(myTrustStore);

        // Get hold of the default trust manager
        X509TrustManager myTm = null;
        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                myTm = (X509TrustManager) tm;
                break;
            }
        }

        // Wrap it in your own class.
        final X509TrustManager finalDefaultTm = defaultTm;
        final X509TrustManager finalMyTm = myTm;
        X509TrustManager customTm = new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                // If you're planning to use client-cert auth,
                // merge results from "defaultTm" and "myTm".
                return finalDefaultTm.getAcceptedIssuers();
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                try {
                    finalMyTm.checkServerTrusted(chain, authType);
                } catch (CertificateException e) {
                    // This will throw another CertificateException if this fails too.
                    finalDefaultTm.checkServerTrusted(chain, authType);
                }
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // If you're planning to use client-cert auth,
                // do the same as checking the server.
                finalDefaultTm.checkClientTrusted(chain, authType);
            }
        };


        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{customTm}, null);
        return customTm;
    }


    public static void main(String[] args) throws CertificateException {
        getTrustManager();
    }
}
