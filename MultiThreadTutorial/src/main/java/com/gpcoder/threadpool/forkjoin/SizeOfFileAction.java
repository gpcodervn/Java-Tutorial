package com.gpcoder.threadpool.forkjoin;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

public class SizeOfFileAction extends RecursiveAction {

	private static final long serialVersionUID = -196522408291343951L;

	private final File file;
	private final AtomicLong sizeAccumulator;

	public SizeOfFileAction(final String fileName, final AtomicLong sizeAccumulator) {
		this(new File(fileName), sizeAccumulator);
	}

	public SizeOfFileAction(final File file, final AtomicLong sizeAccumulator) {
		this.file = Objects.requireNonNull(file);
		this.sizeAccumulator = Objects.requireNonNull(sizeAccumulator);
	}

	@Override
	protected void compute() {
		// System.out.printf("Computing size of: %s \n", file);

		if (file.isFile()) {
			sizeAccumulator.addAndGet(file.length());
		} else {
			final File[] children = file.listFiles();
			if (children != null) {
				for (final File child : children) {
					ForkJoinTask.invokeAll(new SizeOfFileAction(child, sizeAccumulator));
				}
			}
		}
	}
}
