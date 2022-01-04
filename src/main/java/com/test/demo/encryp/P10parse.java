package com.test.demo.encryp;

import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import sun.security.pkcs10.PKCS10;
import sun.security.x509.X500Name;

import java.io.IOException;
import java.security.*;
import java.util.Base64;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: P10parse.java
 * @包 路 径： com.test.demo.encryp
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/16 13:52
 */
public class P10parse {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        P10parse p10parse = new P10parse();

        String s = genCSR();
        System.out.println("密钥");
        System.out.println(s);


        String sb = "MIIBCzCBsAIBADBOMS0wKwYDVQQDDCQwMTAwYzA1Ni0wMDIxLTAwMmMtMDEwMi0wMzA0MDUwNjA3MDgxEDAOBgNVBAgMB0JlaWppbmcxCzAJBgNVBAYMAkNOMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEvy8NOWg9nx8rb9fQqaujzW3hzqwE9n37t37FaceGnQc3O2NPsu25dArSRhU5gtvJn2qVgg1pn8XG7oQ77QEyJKAAMAwGCCqBHM9VAYN1BQADSAAwRQIgUZStmpURUDtg4BH5aQtZ/SW5eVLpCfTSgrnF/h+7kkkCIQDr4P5AfDTtD/ccNIxu91W20LattMN6ksI8pjgdUJIIyw==";//这里传入P10请求字符串，注意去掉换行符
        // 国密p10对象
        PKCS10CertificationRequest request = new PKCS10CertificationRequest(Base64.getDecoder().decode(sb));
        System.out.println(request.toString());
        ASN1Set attributes = request.getCertificationRequestInfo().getAttributes();
        ASN1SetParser parser = attributes.parser();

    }
















    /**
     * 解析p10
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws IOException
     */
    public static void parsep10() throws NoSuchAlgorithmException, SignatureException, IOException {
        String sb = "MIHnMIGMAgEAMCoxCzAJBgNVBAYMAkNOMRswGQYDVQQDDBIwMC0wQy0yOS1EOC0yNC1FRjswWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAARR3wIB2kRnfMBVHy87jrIyikTjBm31VT4V2vTWFvPbnkv77zmadmQMgTAyYqbFJUrDa3rAho/SsFpbBMRXD9IyoAAwDAYIKoEcz1UBg3UFAANIADBFAiAQOAATHH5Wwz4GTG9kfT4CuPZZWrRdWL3DRNW+03ztEQIhAIsxw1HGiXWF/FLyHudOvKYFt8hiLqZnRaHv4d7NE8Z4";//这里传入P10请求字符串，注意去掉换行符
        PKCS10 pkcs10 = new PKCS10(Base64.getDecoder().decode(sb));//解析成P10对象
        //获取P10中定义的证书主题
        X500Name attr = pkcs10.getSubjectName();
        //获取算法
        String alg = pkcs10.getSigAlg();
        System.out.println(alg);
        //获取P10中的公钥，这里获取的是一个公钥结构体，不是一个单纯的公钥(PS：我们C开发说的，需要用C去解析成单纯的公钥，API没有提供方法)
        PublicKey publicKey = pkcs10.getSubjectPublicKeyInfo();
        System.out.println(publicKey.getAlgorithm());
    }

    /**
     * 获取私钥
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws SignatureException
     */
    public static String genCSR()
            throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchProviderException, SignatureException {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            X509Name dn = new X509Name("CN=TEST,O=TEST,L=BJ,C=CN");
            //定义密钥对生成算法
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            //定义加密位数，RSA2048的生成略慢
            keyGen.initialize(2048);
            KeyPair kp = keyGen.generateKeyPair();
            DERSet derSet = new DERSet();
            PKCS10CertificationRequest p10 = new PKCS10CertificationRequest("SHA1WithRSA", dn, kp.getPublic(),derSet , kp.getPrivate());
            byte[] der = p10.getEncoded();
            String code = "";
//             code += "-----BEGIN CERTIFICATE REQUEST-----\n";
            code += Base64.getEncoder().encodeToString(der);
//            code += "\n-----END CERTIFICATE REQUEST-----\n";
            CertificationRequestInfo csrinfo = p10.getCertificationRequestInfo();
            return code;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}