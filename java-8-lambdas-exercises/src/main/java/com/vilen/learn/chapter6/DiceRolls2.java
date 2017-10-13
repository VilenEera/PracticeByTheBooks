package com.vilen.learn.chapter6;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * Created by vilen on 2017/10/13.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class DiceRolls2 {
    private static final int N = 100000000;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*DiceRolls.*",
                "-wi",
                "5",
                "-i",
                "5"
        };
        Main.main(args);
    }

    @Benchmark
    public Map<Integer, Double> serialDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .mapToObj(twoDiceThrows())
                .collect(groupingBy(side -> side,
                        summingDouble(n -> fraction)));
    }

    @Benchmark
    public Map<Integer, Double> parallelDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N) //使用IntStream 的range 方法创建大小为N 的流
                .parallel() // 调用parallel 方法使用流的并行化操作，twoDiceThrows 函数模拟了连续掷两次骰子事件，返回值是两次点数之和
                .mapToObj(twoDiceThrows()) //使用mapToObj 方法以便在流上使用该函数。
                .collect(groupingBy(side -> side, // 得到了需要合并的所有结果的流，使用前一章介绍的groupingBy 方法将点数一样的结果合并。
                        // 我说过要计算每个点数的出现次数，然后除以总的模拟次数N 。在流框架中，将数字映射为1/N 并且相加很简单，
                        // 这和前面说的计算方法是等价的
                        summingDouble(n -> fraction))); // 我们使用summingDouble 方法完成了这一步。
                        // 最终的返回值类型是Map<Integer, Double> ，是点数之和到它们的概率的映射。
    }

    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1,7);
            int secondThrow = random.nextInt(1,7);
            return firstThrow + secondThrow;
        };
    }
    /*
    * Run complete. Total time: 00:05:03
        Benchmark                     Mode  Cnt  Score   Error  Units
        DiceRolls2.parallelDiceRolls  avgt   50  0.458 ± 0.019   s/op
        DiceRolls2.serialDiceRolls    avgt   50  1.677 ± 0.029   s/op
    *
    * */
}
