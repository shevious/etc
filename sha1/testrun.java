import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class testrun {
    public static void main(String[] args) throws IOException {
	//byte[] sha1_ad1 = AeSimpleSHA1.SHA1("Buy new mobile phone! Nokia, Sony-Ericsson, Samsung, LG, ...");
	//System.out.println("hexhash: "+ AeSimpleSHA1.convertToHex(sha1_ad1));
	//System.out.println("hash: "+ sha1_ad1);
	byte[] sha1_ad1 = null;

	String key_salt = "django.contrib.auth.models.AbstractBaseUser.get_session_auth_hash";
	String secret = "wvw18j%u^3ps83e2l#&$!3hrm2!1+us6$2r3h3g91u5udy_+!!";
	try {
	    sha1_ad1 = AeSimpleSHA1.SHA1(key_salt+secret);
	} catch (NoSuchAlgorithmException e) {
	}
	System.out.println("hash: "+ sha1_ad1);
	System.out.println("hexhash: "+ AeSimpleSHA1.convertToHex(sha1_ad1));
          
        String password = "pbkdf2_sha256$20000$nKuC5T0Aw09Q$kdHmugxSg2tQKHizYue7zFx3d/qFBrMKnIiFGsj5qzE=";
	String hmac = "";
	try {
	    hmac = HmacSha1Signature.calculateRFC2104HMAC(password, sha1_ad1);
        } catch (Exception e) {
        }

	System.out.println(hmac);
    }
}
