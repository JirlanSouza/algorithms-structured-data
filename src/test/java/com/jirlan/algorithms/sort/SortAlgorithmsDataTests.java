package com.jirlan.algorithms.sort;

import java.util.stream.Stream;

public class SortAlgorithmsDataTests {
    static DataTest Any = new DataTest(
            new int[]{
                    451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998, 513, 808, 26, 283, 830
            },
            new int[]{
                    26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
            }
    );

    static DataTest alreadySorted = new DataTest(
            new int[]{
                    26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
            },
            new int[]{
                    26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995,
                    998,
            }
    );

    static DataTest inverseSorted = new DataTest(
            new int[]{
                    998, 995, 977, 839, 830, 808, 738, 575, 523, 513, 484, 451, 447, 438, 396, 283, 225, 53, 42, 26
            },
            new int[]{
                    26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
            }
    );

    static DataTest repeated = new DataTest(
            new int[]{
                    896, 896, 896, 48, 48, 78, 78, 48, 56, 56, 56, 102, 102, 102, 296, 459, 459, 21, 21, 21, 296,
                    296,
            },
            new int[]{
                    21, 21, 21, 48, 48, 48, 56, 56, 56, 78, 78, 102, 102, 102, 296, 296, 296, 459, 459, 896, 896,
                    896
            }
    );

    static Stream<DataTest> getStream() {
        return Stream.of(
                SortAlgorithmsDataTests.Any,
                SortAlgorithmsDataTests.alreadySorted,
                SortAlgorithmsDataTests.inverseSorted,
                SortAlgorithmsDataTests.repeated
        );
    }

    record DataTest(int[] given, int[] expected) {
    }
}


