package kyu4.ThreadedCounting;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadedCounting {
    public static void countInThreads(Counter counter) {

        ExecutorService[] execs = new ExecutorService[3];
        for (int i = 0; i < 3; i++) {
            execs[i] = Executors.newFixedThreadPool(1);
        }

        try {
            for (int i = 1; i <= 100; i++) {
                int n = i;
                Runnable task = () -> counter.count(n);
                execs[n % 3].submit(task).get();
            }

            for (int i = 0; i < 3; i++) {
                execs[i].shutdown();
                execs[i].awaitTermination(1, TimeUnit.SECONDS);
            }
        }
        catch (InterruptedException|ExecutionException e) {
            throw new Error("can't happen", e);
        }
    }}


class Counter {
    private final List<Integer> numbers = new ArrayList<>();
    private final Map<Integer, Long> threads = new HashMap<>();
    private final Map<Long, List<Integer>> threadNumbers = new HashMap<>();

    public synchronized void count(int i) {

        long threadId = Thread.currentThread().getId();
        numbers.add(i);
        threads.put(i, threadId);

        List<Integer> threadList = threadNumbers.get(threadId);
        if (threadList == null) {
            threadList = new ArrayList<>();
            threadNumbers.put(threadId, threadList);
        }
        threadList.add(i);

        System.out.println(i + " " +  threadId);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Set<Long> getThreadIds() {
        return new HashSet<>(threads.values());
    }

    public List<Integer> getNumbersInSameThreadAs(int i) {
        long threadId = threads.get(i);
        return new ArrayList<>(threadNumbers.get(threadId));
    }
}