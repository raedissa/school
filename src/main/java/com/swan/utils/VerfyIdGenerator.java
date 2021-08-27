package com.swan.utils;

public class VerfyIdGenerator {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public String randomAlphaNumeric(int count) {

		final StringBuilder builder = new StringBuilder();

		builder.setLength(0);

		while (count-- != 0) {

			final int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}
		return builder.toString();
	}
}