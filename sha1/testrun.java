import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class testrun {
    public static void main(String[] args) throws IOException {
        try {
	    //byte[] sha1_ad1 = AeSimpleSHA1.SHA1("Buy new mobile phone! Nokia, Sony-Ericsson, Samsung, LG, ...");
	    //System.out.println("hexhash: "+ AeSimpleSHA1.convertToHex(sha1_ad1));
	    //System.out.println("hash: "+ sha1_ad1);

            String key_salt = "django.contrib.auth.models.AbstractBaseUser.get_session_auth_hash";
            String secret = "wvw18j%u^3ps83e2l#&$!3hrm2!1+us6$2r3h3g91u5udy_+!!";
	    byte[] sha1_ad1 = AeSimpleSHA1.SHA1(key_salt+secret);
	    System.out.println("hash: "+ sha1_ad1);
	    System.out.println("hexhash: "+ AeSimpleSHA1.convertToHex(sha1_ad1));
          
        } catch (NoSuchAlgorithmException e) {
        }
    }
}
