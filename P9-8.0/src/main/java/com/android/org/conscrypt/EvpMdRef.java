package com.android.org.conscrypt;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class EvpMdRef {
    public static final String MGF1_ALGORITHM_NAME = "MGF1";
    public static final String MGF1_OID = "1.2.840.113549.1.1.8";

    public static final class MD5 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("md5");
        public static final String JCA_NAME = "MD5";
        public static final String OID = "1.2.840.113549.2.5";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private MD5() {
        }
    }

    public static final class SHA1 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha1");
        public static final String JCA_NAME = "SHA-1";
        public static final String OID = "1.3.14.3.2.26";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private SHA1() {
        }
    }

    public static final class SHA224 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha224");
        public static final String JCA_NAME = "SHA-224";
        public static final String OID = "2.16.840.1.101.3.4.2.4";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private SHA224() {
        }
    }

    public static final class SHA256 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha256");
        public static final String JCA_NAME = "SHA-256";
        public static final String OID = "2.16.840.1.101.3.4.2.1";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private SHA256() {
        }
    }

    public static final class SHA384 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha384");
        public static final String JCA_NAME = "SHA-384";
        public static final String OID = "2.16.840.1.101.3.4.2.2";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private SHA384() {
        }
    }

    public static final class SHA512 {
        public static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha512");
        public static final String JCA_NAME = "SHA-512";
        public static final String OID = "2.16.840.1.101.3.4.2.3";
        public static final int SIZE_BYTES = NativeCrypto.EVP_MD_size(EVP_MD);

        private SHA512() {
        }
    }

    public static String getJcaDigestAlgorithmStandardName(String algorithm) {
        String algorithmUpper = algorithm.toUpperCase(Locale.US);
        if (SHA256.JCA_NAME.equals(algorithmUpper) || SHA256.OID.equals(algorithmUpper)) {
            return SHA256.JCA_NAME;
        }
        if (SHA512.JCA_NAME.equals(algorithmUpper) || SHA512.OID.equals(algorithmUpper)) {
            return SHA512.JCA_NAME;
        }
        if (SHA1.JCA_NAME.equals(algorithmUpper) || SHA1.OID.equals(algorithmUpper)) {
            return SHA1.JCA_NAME;
        }
        if (SHA384.JCA_NAME.equals(algorithmUpper) || SHA384.OID.equals(algorithmUpper)) {
            return SHA384.JCA_NAME;
        }
        if (SHA224.JCA_NAME.equals(algorithmUpper) || SHA224.OID.equals(algorithmUpper)) {
            return SHA224.JCA_NAME;
        }
        return null;
    }

    public static long getEVP_MDByJcaDigestAlgorithmStandardName(String algorithm) throws NoSuchAlgorithmException {
        String algorithmUpper = algorithm.toUpperCase(Locale.US);
        if (SHA256.JCA_NAME.equals(algorithmUpper)) {
            return SHA256.EVP_MD;
        }
        if (SHA512.JCA_NAME.equals(algorithmUpper)) {
            return SHA512.EVP_MD;
        }
        if (SHA1.JCA_NAME.equals(algorithmUpper)) {
            return SHA1.EVP_MD;
        }
        if (SHA384.JCA_NAME.equals(algorithmUpper)) {
            return SHA384.EVP_MD;
        }
        if (SHA224.JCA_NAME.equals(algorithmUpper)) {
            return SHA224.EVP_MD;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: " + algorithm);
    }

    public static int getDigestSizeBytesByJcaDigestAlgorithmStandardName(String algorithm) throws NoSuchAlgorithmException {
        String algorithmUpper = algorithm.toUpperCase(Locale.US);
        if (SHA256.JCA_NAME.equals(algorithmUpper)) {
            return SHA256.SIZE_BYTES;
        }
        if (SHA512.JCA_NAME.equals(algorithmUpper)) {
            return SHA512.SIZE_BYTES;
        }
        if (SHA1.JCA_NAME.equals(algorithmUpper)) {
            return SHA1.SIZE_BYTES;
        }
        if (SHA384.JCA_NAME.equals(algorithmUpper)) {
            return SHA384.SIZE_BYTES;
        }
        if (SHA224.JCA_NAME.equals(algorithmUpper)) {
            return SHA224.SIZE_BYTES;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: " + algorithm);
    }

    public static String getJcaDigestAlgorithmStandardNameFromEVP_MD(long evpMdRef) {
        if (evpMdRef == MD5.EVP_MD) {
            return MD5.JCA_NAME;
        }
        if (evpMdRef == SHA1.EVP_MD) {
            return SHA1.JCA_NAME;
        }
        if (evpMdRef == SHA224.EVP_MD) {
            return SHA224.JCA_NAME;
        }
        if (evpMdRef == SHA256.EVP_MD) {
            return SHA256.JCA_NAME;
        }
        if (evpMdRef == SHA384.EVP_MD) {
            return SHA384.JCA_NAME;
        }
        if (evpMdRef == SHA512.EVP_MD) {
            return SHA512.JCA_NAME;
        }
        throw new IllegalArgumentException("Unknown EVP_MD reference");
    }

    private EvpMdRef() {
    }
}
