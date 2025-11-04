package com.attachmentav.api.examples;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;

public class CallbackSignatureX509 {

    private static final long SIGNATURE_TOLERANCE_IN_MILLIS = 5 * 60 * 1000; // 5 minutes

    /**
     * Verifies the signature of a callback.
     *
     * @param unixtimeInMillis Current unixtime in milliseconds (System.currentTimeMillis())
     * @param publicKeyPEM     The public key in PEM X509 format (available at https://attachmentav.com/help/virus-malware-scan-api/developer/publickey.html)
     * @param timestamp        The value of the X-Timestamp header of the callback
     * @param tenantId         Your tenant ID (get your tenant ID from https://attachmentav.com/help/virus-malware-scan-api/developer/definition.html#action-whoami)
     * @param callbackUrl      The callback URL used when submitting the scan job
     * @param body             The body of the callback
     * @param signature        The value of the X-Signature header of the callback
     * @return true if the callback is valid
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    static boolean verify(final long unixtimeInMillis, final String publicKeyPEM, final String timestamp, final String tenantId, final String callbackUrl, final String body, final String signature) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        final Signature verifier = Signature.getInstance("SHA256withRSA");
        final PublicKey pubKey = parsePublicKey(publicKeyPEM);
        verifier.initVerify(pubKey);
        final String dataToVerify = timestamp + "." + tenantId + "." + callbackUrl + "." + body;
        verifier.update(dataToVerify.getBytes(StandardCharsets.UTF_8));
        final byte[] signatureBytes = DatatypeConverter.parseHexBinary(signature);
        final boolean valid = verifier.verify(signatureBytes);
        final boolean withinTolerance = Math.abs(unixtimeInMillis - Long.parseLong(timestamp)) <= SIGNATURE_TOLERANCE_IN_MILLIS;
        return valid && withinTolerance;
    }

    private static PublicKey parsePublicKey(final String publicKeyPEM) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final String cleanKey = publicKeyPEM
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
        final byte[] keyBytes = DatatypeConverter.parseBase64Binary(cleanKey);
        final X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }
}
