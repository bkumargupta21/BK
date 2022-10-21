package com.password.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

	public static boolean checkPassword(String password) {
		boolean lowerCaseFlag = false;
		int cnt = 0;
		String regexForLowerCase = "(?=.*[a-z])";
		String regexForUpperCase = "(?=.*[A-Z])";
		String regexFoeNumber = "(?=.*\\d)";
		if (password == null) {
			return false;
		} else {
			Pattern p = Pattern.compile(regexForLowerCase);
			Matcher m = p.matcher(password);
			if (password.length() >= 8) {
				cnt++;
			}
			if (m.matches()) {
				lowerCaseFlag = true;
				cnt++;
			}

			Pattern p1 = Pattern.compile(regexForUpperCase);
			Matcher m1 = p.matcher(password);

			if (m1.matches()) {
				cnt++;
			}

			Pattern p2 = Pattern.compile(regexFoeNumber);
			Matcher m2 = p.matcher(password);

			if (m2.matches()) {
				cnt++;
			}

		}
		if (!lowerCaseFlag) {
			return false;
		} else if (cnt >= 3) {
			return true;
		}
		return false;
	}

}
