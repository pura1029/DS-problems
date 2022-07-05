/*
 * 
 */
package com.gtm.file.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * The Class Util.
 */
public class Util {

	/**
	 * Gets the percentage.
	 *
	 * @param current
	 *            the current
	 * @param total
	 *            the total
	 * @return the percentage
	 */
	public static int getPercentage(long current, long total) {
		return (int) (((double) current / total) * (100));
	}

	/**
	 * Gets the size in giga bytes.
	 *
	 * @param size
	 *            the size
	 * @return the size in giga bytes
	 */
	public static int getSizeInGigaBytes(long size) {
		return (int) (size / (1024 * 1024 * 1024));
	}

	/**
	 * Gets the size in meg bytes.
	 *
	 * @param size
	 *            the size
	 * @return the size in meg bytes
	 */
	public static int getSizeInMegBytes(long size) {
		return (int) (size / (1024 * 1024));
	}

	/**
	 * Gets the size in kilo bytes.
	 *
	 * @param size
	 *            the size
	 * @return the size in kilo bytes
	 */
	public static int getSizeInKiloBytes(long size) {
		return (int) (size / (1024));
	}

	/**
	 * Log info.
	 *
	 * @param message
	 *            the message
	 */
	public static void logInfo(String message) {
		System.out.print("INFO: ");
		System.out.println(message);
	}

	/**
	 * Log warning.
	 *
	 * @param message
	 *            the message
	 */
	public static void logWarning(String message) {
		System.out.print("WARN: ");
		System.out.println(message);
	}

	/**
	 * Log error.
	 *
	 * @param message
	 *            the message
	 */
	public static void logError(String message) {
		System.err.println("ERROR: ");
		System.err.println(message);
	}

	/**
	 * Log error.
	 *
	 * @param throwable
	 *            the throwable
	 */
	public static void logError(Throwable throwable) {
		logError(exceptionToString(throwable));
	}

	/**
	 * Exception to string.
	 *
	 * @param throwable
	 *            the throwable
	 * @return the string
	 */
	private static String exceptionToString(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println(throwable.getClass().getName());
		printWriter.println("StackTrace :");
		throwable.printStackTrace(printWriter);
		Throwable cause = getRootCause(throwable);
		if (!cause.equals(throwable)) {
			printWriter.println();
			printWriter.println("Root Cause: ");
			cause.printStackTrace(printWriter);
		}
		return stringWriter.toString();
	}

	/**
	 * Gets the root cause.
	 *
	 * @param throwable
	 *            the throwable
	 * @return the root cause
	 */
	private static Throwable getRootCause(Throwable throwable) {
		Throwable cause = throwable;
		while (cause.getCause() != null) {
			cause = cause.getCause();
			if (cause == throwable) {
				break;
			}
		}
		return cause;
	}

	/**
	 * Gets the file encoding.
	 *
	 * @param filePath
	 *            the file path
	 * @return the file encoding
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getFileEncoding(String filePath) throws IOException {
		String fileEncoding = "UTF-8";
		if (filePath == null || !new File(filePath).exists()) {
			return fileEncoding;
		}
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
			fileEncoding = fileReader.getEncoding();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return fileEncoding;
	}

}
