package com.vilen.learn.chapter5;

/**
 * Created by vilen on 2017/10/13.
 */

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义收集器
 * 待收集元素的类型，这里是String ；
 累加器的类型StringCombiner ；
 最终结果的类型，这里依然是String
 */
public class StringCollector implements Collector<String,StringCombiner,String>{

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    // Supplier 创建容器的工厂
    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }

    //accumulator 是一个函数，它将当前元素叠加到收集器
    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    //  combiner 合并两个容器
    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
