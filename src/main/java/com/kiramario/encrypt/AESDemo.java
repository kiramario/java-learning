package com.kiramairo.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

public class AESDemo {
	
	public static String b64Encode(byte[] b) throws UnsupportedEncodingException{
		Base64.Encoder base_encoder = Base64.getEncoder();
	    byte[] base_en_byte = base_encoder.encode(b);
		return new String(base_en_byte,"UTF-8");
	}
	
	public static String b64Decode(String den) throws UnsupportedEncodingException{
		byte[] b = den.getBytes("UTF-8");
		Base64.Decoder base_decoder = Base64.getDecoder();
		byte[] base_de_byte = base_decoder.decode(b);
		return new String(base_de_byte,"UTF-8");
	}
	
	public static byte[] encrypt(String str, String pass) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		KeyGenerator gen = KeyGenerator.getInstance("AES");
		gen.init(128, new SecureRandom(pass.getBytes()));
		SecretKey secretKey = gen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		byte[] byteContent = str.getBytes("utf-8");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = cipher.doFinal(byteContent);
		return result;
	}
	
	public static byte[] decrypt(byte[] content, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");// ����AES��Key������
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();// �����û����룬����һ����Կ
		byte[] enCodeFormat = secretKey.getEncoded();// ���ػ��������ʽ����Կ
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// ת��ΪAESר����Կ
		Cipher cipher = Cipher.getInstance("AES");// ����������
		cipher.init(Cipher.DECRYPT_MODE, key);// ��ʼ��Ϊ����ģʽ��������
		byte[] result = cipher.doFinal(content);  
		return result; // ����   
	}
	
	public static byte[] encrypt2(String str, String pass,String iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{
		 Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
         int blockSize = cipher.getBlockSize();

         byte[] dataBytes = str.getBytes();
         int plaintextLength = dataBytes.length;
         if (plaintextLength % blockSize != 0) {
             plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
         }

         byte[] plaintext = new byte[plaintextLength];
         System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
         
         SecretKeySpec keyspec = new SecretKeySpec(pass.getBytes(), "AES");
         IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

         cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
         byte[] encrypted = cipher.doFinal(plaintext);
         return encrypted;
	}
	
	public static String decrypt2(String bcontent,String key,String iv) throws Exception {
		
		byte[] encrypted1 = new BASE64Decoder().decodeBuffer(bcontent);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
		
		cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
		
		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original);
		return originalString;
	}
   
	
	public static void main(String[] args) throws Exception{
		 String content = "7320";
		 String password = "hxzqact123456789";
		 System.out.println("����֮ǰ��" + content);
		 
		 System.out.println("=========encrypt============");
		 byte[] encrypt = encrypt(content, password);
		 System.out.println("���ܺ�����ݣ�" + new String(encrypt));
		 System.out.println("���ܺ�ת64�����ݣ�" + b64Encode(encrypt));

		 byte[] decrypt = decrypt(encrypt, password);
		 System.out.println("���ܺ�����ݣ�" + new String(decrypt));
		 
		 System.out.println("=========encrypt2============");
		 String iv = "hxzqact123456789";
		 byte[] encrypt2 = encrypt2(content, password,iv);
		 System.out.println("���ܺ�����ݣ�" + new String(encrypt2));
		 System.out.println("���ܺ�ת64�����ݣ�" + b64Encode(encrypt2));
		 System.out.println("���ܺ�ת64�����ݣ�" + new sun.misc.BASE64Encoder().encode(encrypt2));
		 
		 System.out.println("���ܺ�����ݣ�" + decrypt2(b64Encode(encrypt2),password,iv));
		 
	}
}
