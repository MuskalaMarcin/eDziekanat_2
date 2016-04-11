package edziekanat.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Class with methods used when password hashing.
 *
 * Created by Marcin on 09.04.2016.
 */
public class PasswordUtils
{
    public static String getSHA512PasswordHash(String password, String salt)
    {
	try
	{
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(salt.getBytes());
	    return String.format("%0128x", new BigInteger(1, md.digest(password.getBytes())));
	}
	catch (NoSuchAlgorithmException e)
	{
	    e.printStackTrace();
	    return null;
	}
    }

    public static String generateSalt()
    {
	SecureRandom secureRandom = new SecureRandom();
	byte[] salt = new byte[32];
	secureRandom.nextBytes(salt);
	return String.format("%064x", new BigInteger(1, salt));
    }
}
