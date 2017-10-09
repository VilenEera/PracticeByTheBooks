package com.vilen.learn.chapter4;

import com.vilen.learn.chapter1.Album;

import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

/**
 * Created by vilen on 2017/10/9.
 */
public class TrackLength {
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTracks().mapToInt(track -> track.getLength())
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
    /*************************/
    public void overloadedMethod(Object o) {
        System.out.print("Object");
    }

    public void overloadedMethod(String s) {
        System.out.print("String");
    }
    /*************************/
    public interface IntegerBiFunction extends BinaryOperator<Integer> {

    }

    public void overloadedMethod (BinaryOperator<Integer> Lambda) {
        System.out.print("BinaryOperator");
    }

    public void overloadedMethod(IntegerBiFunction Lambda) {
        System.out.print("IntegerBinaryOperator");
    }
    /*************************/


}
