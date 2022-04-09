package edu.iztech.g4.hw2.utils;

public class StringUtils {

	public static boolean isNumeric(String string) {
		if (string == null) {
			return false;
		}
		try {
			Double.parseDouble(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
