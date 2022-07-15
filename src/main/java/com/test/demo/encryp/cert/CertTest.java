package com.test.demo.encryp.cert;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: CertTest.java
 * @包 路 径： com.test.demo.encryp.cert
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/14 11:20
 */
public class CertTest {
//    public static X509CertificateHolder buildEndEntityCert(X500Name subject,
//                                                           AsymmetricKeyParameter entityKey, AsymmetricKeyParameter caKey,
//                                                           X509CertificateHolder caCert, String ufn) throws Exception {
//        // 产生公钥
//        SubjectPublicKeyInfo entityKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(entityKey);
//        if (subject == null)
//            subject = new X500Name("CN = BETaaS Gateway Certificate");
//
//        X509v3CertificateBuilder certBldr = new X509v3CertificateBuilder(
//                caCert.getSubject(),
//                BigInteger.valueOf(1),
//                new Date(System.currentTimeMillis()),
//                new Date(System.currentTimeMillis() + 100*360*24*3600*1000),
//                subject,
//                entityKeyInfo);
//        X509ExtensionUtils extUtils = new X509ExtensionUtils(new SHA1DigestCalculator());
//        certBldr.addExtension(Extension.authorityKeyIdentifier, false,
//                extUtils.createAuthorityKeyIdentifier(caCert))
//                .addExtension(Extension.subjectKeyIdentifier, false,
//                        extUtils.createSubjectKeyIdentifier(entityKeyInfo))
//                .addExtension(Extension.basicConstraints, true,
//                        new BasicConstraints(false))
//                .addExtension(Extension.keyUsage, true, new KeyUsage(
//                        KeyUsage.digitalSignature | KeyUsage.keyEncipherment))
//                .addExtension(Extension.subjectAlternativeName, false, new GeneralNames(
//                        new GeneralName(GeneralName.rfc822Name, ufn)));
//        AlgorithmIdentifier sigAlg = algFinder.find(ALG_NAME);
//        AlgorithmIdentifier digAlg = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlg);
//        ContentSigner signer = new BcECDSAContentSignerBuilder(sigAlg, digAlg).build(caKey);
//        return certBldr.build(signer);
//    }
//
//    private X509AttributeCertificateHolder createAttrCert() throws Exception {
//        X509CertificateHolder iCertHolder = new X509CertificateHolder(holderCert);
//
//        X509v2AttributeCertificateBuilder gen = new X509v2AttributeCertificateBuilder(
//                new AttributeCertificateHolder(iCertHolder.getSubject()),
//                new AttributeCertificateIssuer(new X500Name(“cn = test”)),
//                BigInteger.ONE,
//                new Date(System.currentTimeMillis() - 50000),
//                new Date(System.currentTimeMillis() + 50000));
//        // the actual attributes
//        GeneralName roleName = new GeneralName(GeneralName.rfc822Name,
//                “[email protected]”);
//        ASN1EncodableVector roleSyntax = new ASN1EncodableVector();
//        roleSyntax.add(roleName);
//        // roleSyntax OID: 2.5.24.72
//        gen.addAttribute(new ASN1ObjectIdentifier(“ 2.5 .24 .72”),new DERSequence(roleSyntax));
//        AlgorithmIdentifier sigAlg = sigAlgFinder.find(“SHA1withRSA”);
//        AlgorithmIdentifier digAlg = digAlgFinder.find(sigAlg);
//        ContentSigner sigGen = new BcRSAContentSignerBuilder(sigAlg, digAlg).build(RSA_PRIVATE_KEY_SPEC);
//        Target targetName = new Target(Target.targetName, new GeneralName(GeneralName.dNSName,
//                “www.test.com”));
//        Target targetGroup = new Target(Target.targetGroup, new GeneralName(
//                GeneralName.directoryName, “o = Test, ou = Test”));
//        Target[] targets = new Target[2];
//        targets[0] = targetName;
//        targets[1] = targetGroup;
//        TargetInformation targetInformation = new TargetInformation(targets);
//        gen.addExtension(Extension.targetInformation, true, targetInformation);
//        return gen.build(sigGen);
//    }


}
