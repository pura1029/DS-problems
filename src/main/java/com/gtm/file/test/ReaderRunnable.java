/*
 * 
 */
package com.gtm.file.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;


/**
 * The Class ReaderRunnable.
 */
@SuppressWarnings("unused")
public class ReaderRunnable implements Callable<String> {

	/** The word frequencies. */
	private Map<String, AtomicLong> wordFrequencies;
	
	/** The pause flag. */
	private AtomicBoolean pauseFlag;
	
	/** The input stream. */
	private InputStream inputStream;
	
	/** The stream encoding. */
	private String streamEncoding;
	
	/** The size. */
	private long size;
	
	/** The current. */
	private long current;
	
	/** The word sep pattern. */
	private String wordSepPattern;

	/**
	 * Instantiates a new reader runnable.
	 *
	 * @param inputStream the input stream
	 * @param streamEncoding the stream encoding
	 * @param wordSepPattern the word sep pattern
	 * @param size the size
	 * @param wordFrequencies the word frequencies
	 * @param pauseFlag the pause flag
	 */
	public ReaderRunnable(InputStream inputStream, String streamEncoding, String wordSepPattern, long size,
			Map<String, AtomicLong> wordFrequencies, AtomicBoolean pauseFlag) {
		this.inputStream = inputStream;
		this.wordSepPattern = wordSepPattern;
		this.streamEncoding = streamEncoding;
		this.size = size;
		this.current = 0;
		this.wordFrequencies = wordFrequencies;
		this.pauseFlag = pauseFlag;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() {
		logInfo("Starting Processs: " + getClass().getSimpleName() + " ");
		Scanner scanner = null;
		Pattern pattern = Pattern.compile(wordSepPattern);
		try {
			Set<Integer> percentCompleted = new HashSet<>();
			scanner = new Scanner(inputStream, streamEncoding);
			scanner.useDelimiter(pattern);
			//int lineSep = wordSepPattern.getBytes(streamEncoding).length;
			int lineSep = 1;
			while (scanner.hasNext()) {
				progress(percentCompleted);
				if (pauseFlag.get()) {
					synchronized (pauseFlag) {
						System.out.println("Pause signal on thread "+Thread.currentThread().getName());
						pauseFlag.wait();
					}
				}
				String word = scanner.next().trim().toLowerCase();
				char ch = word.charAt(word.length() - 1);
				if (!(Character.isDigit(ch) || Character.isAlphabetic(ch))) {
					word = word.substring(0, word.length() - 1).trim();
				}
				current += (word.getBytes(streamEncoding).length + lineSep);
				//logInfo("Word Found: " + word);
				wordFrequencies.putIfAbsent(word, new AtomicLong(0));
				wordFrequencies.get(word).incrementAndGet();
			}
			progress(percentCompleted);
		} catch (Exception e) {
			logError(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					Util.logError(e);
				}
			}
			if (scanner != null) {
				scanner.close();
			}
		}
		logInfo("Ending Processs: " + getClass().getSimpleName() + " ");
		return null;
	}

	/**
	 * Progress.
	 *
	 * @param percentCompleted the percent completed
	 */
	private void progress(Set<Integer> percentCompleted) {
		int percentComplete;
		percentComplete = getPercentage(current, size);
		if ((percentComplete % 5 == 0) && !percentCompleted.contains(percentComplete)) {
			percentCompleted.add(percentComplete);
			logInfo("Percentage Complete: " + percentComplete + "%");
		}
	}

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
		return Util.getPercentage(current, total);
	}

	/**
	 * Log info.
	 *
	 * @param message
	 *            the message
	 */
	private void logInfo(String message) {
		Util.logInfo(message);
	}

	/**
	 * Log warning.
	 *
	 * @param message
	 *            the message
	 */
	private void logWarning(String message) {
		Util.logWarning(message);
	}

	/**
	 * Log error.
	 *
	 * @param message
	 *            the message
	 */
	private void logError(String message) {
		Util.logError(message);
	}

	/**
	 * Log error.
	 *
	 * @param throwable
	 *            the throwable
	 */
	private void logError(Throwable throwable) {
		Util.logError(throwable);
	}
}
