package cn.schope.lightning.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtils {
	private static final String LIANTONGKEFU_STRING = "10010";
	private static final String YIDONGKEFU_STRING = "10086";
	private static final String DIANXINKEFU_STRING = "10000";
	private static String[] kefuStrings = { LIANTONGKEFU_STRING,
			YIDONGKEFU_STRING, DIANXINKEFU_STRING };

	public static boolean isPhoneNumberValid(String phoneNumber) {
		boolean isValid = false;
		/*
		 * 可接受的电话格式有：
		 */
		String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{5})$";
		/*
		 * 可接受的电话格式有：
		 */
		String expression2 = "^\\(?(\\d{3})\\)?[- ]?(\\d{4})[- ]?(\\d{4})$";
		if (phoneNumber.startsWith("86")) {
			phoneNumber = phoneNumber.substring(2, phoneNumber.length());
		}
		if (phoneNumber.startsWith("+86")) {
			phoneNumber = phoneNumber.substring(3, phoneNumber.length());
		}
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);

		Pattern pattern2 = Pattern.compile(expression2);
		Matcher matcher2 = pattern2.matcher(inputStr);
		if (matcher.matches() || matcher2.matches()) {
			isValid = true;
		}

		for (int i = 0; i < kefuStrings.length; i++) {
			if (phoneNumber.equals(kefuStrings[i])) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}
}
