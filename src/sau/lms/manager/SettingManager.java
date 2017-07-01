package sau.lms.manager;

import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Base64;

public class SettingManager {
	public static String sitePath = "http://www.sauport.sakarya.edu.tr";
	public static Boolean reloadThreads = false;
	public static Boolean reloadDashBoard = false;
	public static Context appContext;

	public boolean CheckNetwork(Context ctx) {
		ConnectivityManager cm = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return (cm.getActiveNetworkInfo() != null
				&& cm.getActiveNetworkInfo().isAvailable() && cm
				.getActiveNetworkInfo().isConnected());
	}

	// http://stackoverflow.com/q/17113113
	public static String Encrypt(String raw) throws Exception {
		Cipher c = getCipher(Cipher.ENCRYPT_MODE);

		byte[] encryptedVal = c.doFinal(raw.getBytes("UTF-8"));
		return Base64.encodeToString(encryptedVal, Base64.DEFAULT);
	}

	private static Cipher getCipher(int mode) throws Exception {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

		// a random Init. Vector. just for testing
		byte[] iv = "e675f725e675f725".getBytes("UTF-8");

		Key k = generateKey();
		c.init(mode, k, new IvParameterSpec(iv));
		return c;
	}

	public static String Decrypt(String encrypted) throws Exception {

		byte[] decodedValue = Base64.decode(encrypted.getBytes(),
				Base64.DEFAULT);

		Cipher c = getCipher(Cipher.DECRYPT_MODE);
		byte[] decValue = c.doFinal(decodedValue);

		return new String(decValue);
	}

	private static Key generateKey() throws Exception {
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		char[] password = "Pass@word1".toCharArray();
		byte[] salt = "S@1tS@lt".getBytes("UTF-8");

		KeySpec spec = new PBEKeySpec(password, salt, 4, 128);
		SecretKey tmp = factory.generateSecret(spec);
		byte[] encoded = tmp.getEncoded();
		return new SecretKeySpec(encoded, "AES");

	}
}
