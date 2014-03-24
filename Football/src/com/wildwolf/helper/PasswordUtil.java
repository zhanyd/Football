package com.wildwolf.helper;

import java.util.*;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * 
 * @author oujianhua
 *
 */
public class PasswordUtil {

	/**
	 * 随机生成的密码的长度
	 */
	private static int RANDOM_PASSWORD_LENGTH = 7;
	
	
	private static final int START_NUMBER_VALUE = 48;//'0'的unicode值	
	private static final int END_NUMBER_VALUE;
	private static final int START_LOWERCASELETTER_VALUE=97;//'a'的unicode值
	private static final int END_LOWERCASELETTER_VALUE;
	private static final int START_UPPERCASELETTER_VALUE=65;//'A'的unicode值
	private static final int END_UPPERCASELETTER_VALUE;
	
	private static final int NUMBER_SIZE=10;
	private static final int LOWERCASELEETER_SIZE = 26;
	private static final int UPPERCASELETTER_SIZE = 26;

	static {
		END_NUMBER_VALUE = START_NUMBER_VALUE + NUMBER_SIZE -1;
		END_LOWERCASELETTER_VALUE = START_LOWERCASELETTER_VALUE + LOWERCASELEETER_SIZE - 1;
		END_UPPERCASELETTER_VALUE = START_UPPERCASELETTER_VALUE + UPPERCASELETTER_SIZE - 1;
	}

	/**
	 * 随机生成一个密码，该密码有六位，密码中包含数字，小写字母，大写字母
	 * @return 密码值
	 */
	public static String generateRandomPassword(int passwordLength) {	
		
		
		 RANDOM_PASSWORD_LENGTH = passwordLength;
		
		 final int numberSize = 10;
		 final int lowerCaseLetterSize = 26;
		 final int upperCaseLetterSize = 26;
		
		List passwordElementList = new ArrayList(RANDOM_PASSWORD_LENGTH);
		
		List numberList = new ArrayList(numberSize);
		List lowerCaseLetterList = new ArrayList(lowerCaseLetterSize);
		List upperCaseLetterList = new ArrayList(upperCaseLetterSize);

		for (int i = 0; i < numberSize; i++) {
			char ch = (char) (48 + i);
			numberList.add(i, String.valueOf(ch));
		}

		for (int j = 0; j < lowerCaseLetterSize; j++) {
			char ch = (char) (97 + j);
			lowerCaseLetterList.add(j, String.valueOf(ch));
		}

		for (int k = 0; k < upperCaseLetterSize; k++) {
			char ch = (char) (65 + k);
			upperCaseLetterList.add(k, String.valueOf(ch));
		}

		for (int i = 0; i < RANDOM_PASSWORD_LENGTH - 3; i++) {// 生成前（RANDOM_PASSWORD_LENGTH - 3）位密码
			populateRandomPasswordElement(numberList, lowerCaseLetterList, upperCaseLetterList, passwordElementList);
		}
		
//		List supplementCandidate = new ArrayList();
//		
//		if (!hasChanged(numberList, NUMBER_SIZE)) {
//			supplementCandidate.add(generateRandomObject(numberList));
//		}
//		if (!hasChanged(lowerCaseLetterList, LOWER_CASE_LETTER_SIZE)) {
//			supplementCandidate.add(generateRandomObject(lowerCaseLetterList));
//		}
//		if (!hasChanged(upperCaseLetterList, UPPER_CASE_LETTER_SIZE)) {
//			supplementCandidate.add(generateRandomObject(upperCaseLetterList));
//		}
//		
//		List supplementPasswordList = getSupplementPassword(supplementCandidate);
//		int supplementPasswordSize = supplementPasswordList.size();
//		
//		
//		for (int p = 0; p < supplementPasswordSize; p++) {
//		  passwordElementList.add(generatePasswordElement(supplementPasswordList));
//		}		
//		for (int q = supplementPasswordSize; q < 2; q++) {
//			populateRandomPasswordElement(numberList, lowerCaseLetterList, upperCaseLetterList, passwordElementList);
//		}
		
		List supplementPasswordElementList = new ArrayList();
		supplementPasswordElementList.add(generateRandomObject(numberList));
		supplementPasswordElementList.add(generateRandomObject(lowerCaseLetterList));
		supplementPasswordElementList.add(generateRandomObject(upperCaseLetterList));
		
		for (int i = 0; i < 3; i++) {//生成后3位密码
			passwordElementList.add(generatePasswordElement(supplementPasswordElementList));
		}
		

		StringBuffer passwordBuf = new StringBuffer();
		for (int i = 0; i < passwordElementList.size(); i++) {
			passwordBuf.append(passwordElementList.get(i));
		}		

		return passwordBuf.toString();
	}
	

	/**
	 * 生成密码的一个随机元素，并从候选密码元素List中删除该元素
	 * @return 密码中的一个元素
	 */
	private static String generatePasswordElement(List candidatePasswordList) {
		int size = candidatePasswordList.size();
		// int passwordElementIndex = (int)Math.ceil((size-1)*Math.random());
		int passwordElementIndex = generateRandomIndex(size);
		String passwordElement = (String) candidatePasswordList
				.get(passwordElementIndex);
		candidatePasswordList.remove(passwordElementIndex);
		return passwordElement;
	}

	/**
	 * 产生一个随机boolean值
	 * @return
	 */
	private static boolean generateRandomValue() {
		Random random = new Random();
		return random.nextBoolean();
	}

	/**
	 * 产生一个范围内的随机索引值 
	 * @param 范围
	 * @return 索引值,最小值是0，最大值是listSize-1
	 */
	private static int generateRandomIndex(int listSize) {
//		int index = (int) Math.ceil((listSize - 1) * Math.random());
//		return index;
		
		int index = (int) Math.floor(listSize * Math.random());
		if (index >= listSize) {
			index = listSize-1;
		}
		return index;
	}

	/**
	 * 获取List内的一个随机对象
	 * @param List
	 * @return 随机对象元素
	 */
	private static Object generateRandomObject(List list) {
		int index = generateRandomIndex(list.size());
		return list.get(index);
	}
	
	/**
	 * 生成密码的一个随机元素，并从候选密码元素List中删除该元素
	 * @param list
	 * @return
	 */
//	private static String generateRandomPasswordElement(List candidatePasswordElementList) {
//		int index = generateRandomIndex(candidatePasswordElementList.size());
//		String s = (String)candidatePasswordElementList.get(index);
//		candidatePasswordElementList.remove(index);
//		return s;
//	}


	/**
	 * 查看该List是否发生过删除元素的动作
	 * 
	 * @param list
	 * @param originalSize
	 * @return
	 */
//	private static boolean hasChanged(List list, int originalSize) {
//		if (list.size() < originalSize) {
//			return true;
//		}
//		return false;
//	}

	/**
	 * 获取补充密码
	 * 
	 * @param lastTwoPasswordCandidate
	 * @return
	 */
//	private static List getSupplementPassword(List supplementCandidate) {
//		List supplementPasswordList = new ArrayList();
//		for (int i = 0; i < supplementCandidate.size(); i++) {
//			String pw = (String) supplementCandidate.get(i);
//			if (pw != null) {
//				supplementPasswordList.add(pw);
//			}
//		}
//		return supplementPasswordList;
//
//	}

	/**
	 * 生成随机密码元素，并存入到密码元素List
	 * @param numberList
	 * @param lowerCaseLetterList
	 * @param upperCaseLetterList
	 * @param passwordElementList
	 * @return
	 */
	private static void populateRandomPasswordElement(List numberList,
			List lowerCaseLetterList, List upperCaseLetterList,
			List passwordElementList) {
		boolean randomValue = generateRandomValue();
		if (randomValue == true) {
			passwordElementList.add(generatePasswordElement(numberList));
		} else {
			randomValue = generateRandomValue();
			if (randomValue == true) {
				passwordElementList.add(generatePasswordElement(lowerCaseLetterList));
			} else {
				passwordElementList.add(generatePasswordElement(upperCaseLetterList));
			}
		}
	}
	
	
	/**
	 * 对用户密码进行加密
	 * @param 用户密码(未加密的)
	 * @return 加密后的密码
	 */
	public static String encrypt(String userPassword) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
		return encryptedPassword;
	}
	
	/**
	 * 验证用户密码是否同时包含数字，小写字母，大写字母
	 * @param 用户密码(未加密的)
	 * @return 同时包含数字，小写字母，大写字母，返回true，否则返回false
	 */
	public static boolean hasCorrectComposition(String userPassword) {
		boolean hasNumber = false;
		boolean hasLowerCaseLetter = false;
		boolean hasUpperCaseLetter = false;
		
		boolean valid = false;
		
		for (int i = 0; i < userPassword.length(); i++) {
			int ch = userPassword.charAt(i);
			if (ch >= START_NUMBER_VALUE && ch <= END_NUMBER_VALUE) {
				hasNumber = true;
				continue;
			}
			if (ch >= START_LOWERCASELETTER_VALUE && ch <= END_LOWERCASELETTER_VALUE) {
				hasLowerCaseLetter = true;
				continue;
			}
			if (ch >= START_UPPERCASELETTER_VALUE && ch <= END_UPPERCASELETTER_VALUE) {
				hasUpperCaseLetter = true;
				continue;
			}
		}
		
		if (hasNumber && hasLowerCaseLetter && hasUpperCaseLetter) {
			valid = true;
		}
		
		return valid;
	}
	
	/**
	 * 验证用户密码中是否包含数字
	 * @param 用户密码(未加密的)
	 * @return
	 */
//	private boolean hasNumber(String userPassword) {
//		for (int i = 0; i < userPassword.length(); i++) {
//			int ch = userPassword.charAt(i);
//			if (ch >= START_NUMBER_VALUE && ch <= START_NUMBER_VALUE + NUMBER_SIZE -1) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
	/**
	 * 验证用户密码中是否包含小写字母
	 * @param 用户密码(未加密的)
	 * @return
	 */
//	private boolean hasLowerCaseLetter(String userPassword) {
//		return false;
//	}
	
	/**
	 * 验证用户密码中是否包含大写字母
	 * @param 用户密码(未加密的)
	 * @return
	 */
//	private boolean hasUpperCaseLetter(String userPassword) {
//		return false;
//	}
	
	/**
	 * 验证用户输入的密码是否正确
	 * @param userPassword 用户输入的密码
	 * @param encryptedPassword 系统为用户保存的加密密码
	 * @return 如果输入的密码正确，返回true, 否则返回false
	 */
	public static boolean checkPassword(String userPassword,String encryptedPassword) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.checkPassword(userPassword, encryptedPassword);
	}


}
