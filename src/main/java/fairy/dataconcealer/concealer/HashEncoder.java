package fairy.dataconcealer.concealer;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashEncoder implements Encoder {

    private MessageDigest digest;

    HashEncoder() {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize MD5 algorithm");
        }
    }

    @Override
    public String encode(String strToFix) {
        try {
            digest.reset();
            byte[] bytesOfMessage = strToFix.getBytes("UTF-8");
            byte[] md5 = digest.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, md5);
            return bigInt.toString(16);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to encode string");
        }
    }

}
