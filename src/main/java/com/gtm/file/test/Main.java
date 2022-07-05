/*
 * 
 */
package com.gtm.file.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Class Main.
 */
@SuppressWarnings("unused")
public class Main {

	/** The Constant WORD_SEPERATOR_PATTERN. */
	private static final String WORD_SEPERATOR_PATTERN = "\\s+";

	/** The word frequencies. */
	private ConcurrentHashMap<String, AtomicLong> wordFrequencies;

	/** The pause flag. */
	private AtomicBoolean pauseFlag;

	/** The thread factory. */
	private ReaderThreadFactory threadFactory;

	/** The executor. */
	private ScheduledThreadPoolExecutor executor;

	/** The dir path. */
	private String dirPath;

	/**
	 * Instantiates a new main.
	 *
	 * @param dirPath
	 *            the dir path
	 */
	public Main(String dirPath) {
		this.dirPath = new File(dirPath).getAbsolutePath();
		wordFrequencies = new ConcurrentHashMap<String, AtomicLong>();
		pauseFlag = new AtomicBoolean(false);
		threadFactory = new ReaderThreadFactory();
		executor = new ScheduledThreadPoolExecutor(10, threadFactory);
	}

	/**
	 * Call.
	 *
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	public String call() throws Exception {
		File directory = new File(dirPath);
		File[] files = directory.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});

		ReaderRunnable[] readers = new ReaderRunnable[files.length];
		Future<String>[] futures = new Future[files.length];
		for (int i = 0; i < files.length; i++) {
			InputStream stream = null;
			try {
				stream = new BufferedInputStream(new FileInputStream(files[i]));
				readers[i] = new ReaderRunnable(stream, Util.getFileEncoding(files[i].getAbsolutePath()),
						WORD_SEPERATOR_PATTERN, files[i].length(), wordFrequencies, pauseFlag);
				futures[i] = executor.submit(readers[i]);
			} catch (Exception e) {

			} finally {
				if (stream != null) {
					try {
					} catch (Exception e) {
						Util.logError(e);
					}
				}
			}
		}
		Scanner scanner = new Scanner(System.in);
		while (executor.getActiveCount() > 0 && scanner.hasNextLine()) {
			int freqInput = getNextNumber(scanner);
			try {
				checkExitRequest(freqInput);
				signalReaders(true);
				printWordFrequenciesNew(freqInput);
				checkReadersSignalled();
			} finally {
				signalReaders(false);
			}
		}
		scanner.close();
		for (int i = 0; i < futures.length; i++) {
			futures[i].get();
		}
		// printWordFrequencies();
		executor.shutdownNow();
		return null;
	}

	protected void printWordFrequenciesNew(int top) {
		SortedMap<AtomicLong, Set<String>> sortedMap = new TreeMap<AtomicLong, Set<String>>(
				new Comparator<AtomicLong>() {
					public int compare(AtomicLong k1, AtomicLong k2) {
						return (int) (k2.get() - k1.get());
					}
				});

		for (String word : wordFrequencies.keySet()) {
			AtomicLong newKey = wordFrequencies.get(word);
			Set<String> set = sortedMap.get(newKey);
			if (set == null) {
				set = new HashSet<String>();
				sortedMap.put(newKey, set);
			}
			set.add(word);
		}
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		for (AtomicLong frequency : sortedMap.keySet()) {
			counter++;

			builder.append("@HigeshtFreq: ");
			builder.append(counter);
			builder.append(" : ");

			builder.append(" With a frequency of '");
			builder.append(frequency.get());
			builder.append("' times, word :");

			builder.append("'");
			builder.append(sortedMap.get(frequency));
			builder.append("'");

			logInfo(builder.toString());
			builder.delete(0, builder.length());
			if (top > 0 && counter == top) {
				break;
			}
		}
	}

	/**
	 * The Class VComparator.
	 */
	class VComparator implements Comparator<String> {

		/** The key values. */
		private Map<String, AtomicLong> keyValues;
		private Set<Integer> set;

		/**
		 * Instantiates a new v comparator.
		 */
		VComparator() {
		}

		/**
		 * Sets the key values.
		 *
		 * @param keyValues
		 *            the key values
		 */
		public void setKeyValues(Map<String, AtomicLong> keyValues) {
			this.keyValues = keyValues;
			this.set = new HashSet<>();
		}

		/**
		 * Gets the key values.
		 *
		 * @return the key values
		 */
		public Map<String, AtomicLong> getKeyValues() {
			return keyValues;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(String k1, String k2) {
			// return (int) (getKeyValues().get(k2).get() - getKeyValues().get(k1).get());
			int result = (int) (getKeyValues().get(k2).get() - getKeyValues().get(k1).get());
			if (set.contains(result)) {
				result = result + 1;
				set.add(result);
			} else {
				set.add(result);
			}
			return result;
		}
	}

	/**
	 * Prints the word frequencies.
	 */
	protected void printWordFrequencies() {
		printWordFrequencies(-1);
	}

	/**
	 * Prints the word frequencies.
	 *
	 * @param top
	 *            the top
	 */
	protected void printWordFrequencies(int top) {
		VComparator valueComparator = new VComparator();
		SortedMap<String, AtomicLong> valueSortedMap = new TreeMap<String, AtomicLong>(valueComparator);
		valueComparator.setKeyValues(wordFrequencies);
		valueSortedMap.putAll(wordFrequencies);
		System.out.println("wordFrequencies length ==  " + wordFrequencies.size());
		System.out.println("valueSortedMap length ==  " + valueSortedMap.size());
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		for (String word : valueSortedMap.keySet()) {
			counter++;

			builder.append("@HigeshtFreq: ");
			builder.append(counter);
			builder.append(" : ");

			builder.append("'");
			builder.append(word);
			builder.append("'");
			builder.append(" with a frequency of '");
			builder.append(valueSortedMap.get(word).get());
			builder.append("' times .");

			logInfo(builder.toString());
			builder.delete(0, builder.length());
			if (top > 0 && counter == top) {
				break;
			}
		}
	}

	/**
	 * Check readers signalled.
	 */
	void checkReadersSignalled() {
		boolean runPoll = true;
		while (runPoll) {
			runPoll = false;
			Iterator<Thread> iterator = threadFactory.getThreads().iterator();
			while (iterator.hasNext()) {
				Thread thread = (Thread) iterator.next();
				if (thread.getState().equals(Thread.State.TERMINATED)) {
					iterator.remove();
				} else if (thread.getState().equals(Thread.State.RUNNABLE)) {
					runPoll = true;
				} else {
					Util.logInfo(thread.getState().toString());
				}
			}
		}
	}

	/**
	 * Check exit request.
	 *
	 * @param freqInput
	 *            the freq input
	 */
	void checkExitRequest(int freqInput) {
		if (freqInput == -1) {
			System.exit(0);
		}
	}

	/**
	 * Signal readers.
	 *
	 * @param pause
	 *            the pause
	 */
	void signalReaders(boolean pause) {
		System.out.println("Pause value is :: " + pause);
		if (pause) {
			pauseFlag.set(true);
		} else {
			pauseFlag.set(false);
			synchronized (pauseFlag) {
				pauseFlag.notifyAll();
			}
		}

	}

	/**
	 * Gets the next number.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the next number
	 */
	private int getNextNumber(Scanner scanner) {
		int freqInput = 0;
		try {
			freqInput = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
		}
		return freqInput;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		String dirPath = new File(System.getProperty("user.home")).getAbsolutePath();
		if (args.length == 1) {
			dirPath = new File(args[0]).getAbsolutePath();
		}
		System.out.println("Dire is ::::  " + dirPath);
		new Main(dirPath).call();
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
