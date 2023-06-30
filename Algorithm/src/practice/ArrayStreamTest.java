package practice;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ArrayStreamTest {

    private static final int MAX_SIZE = 10000;


    /**
     * 양쪽의 배열을 구하기 위해서
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] array = new int[MAX_SIZE];
        IntStream.range(0, MAX_SIZE).parallel().forEach(i -> array[i] = (int) (Math.random() * MAX_SIZE));

        System.out.println("기존 코드");
        checkTime(ArrayStreamTest::originFunction, array);

        System.out.println("스트림 사용  코드");
        checkTime(ArrayStreamTest::newFunction, array);

    }

    public static void checkTime(Consumer<int[]> func, int[] a) {
        Instant start = Instant.now();

        func.accept(a);

        Instant end = Instant.now();

        Duration elapsedTime = Duration.between(start, end);
        System.out.println("경과 시간(ms): " + elapsedTime.toMillis());
    }

    public static void originFunction(int[] a) {

        int[] leftMinArr = new int[a.length];
        int[] rightMinArr = new int[a.length];
        int leftMin = a[0];
        int rightMin = a[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            leftMin = Math.min(leftMin, a[i]);
            rightMin = Math.min(rightMin, a[a.length - i - 1]);
            leftMinArr[i] = leftMin;
            rightMinArr[a.length - i - 1] = rightMin;
        }
    }

    public static void newFunction(int[] a) {

//        // 해당 로직을 사용하게되면 반복을 더 많이 하기 떄문에 a.length = n이라고 하면  n * n * n 정도 ..?
//        int[] leftMinArr = new int[a.length];
//        int[] rightMinArr = new int[a.length];
//
//        for (int i = 0; i < a.length; i++) {
//            leftMinArr[i] = Arrays.stream(a, i, i + 1).min().getAsInt();
//            rightMinArr[i] = Arrays.stream(a, Math.min(i + 1, a.length - 1), a.length).min().getAsInt();
//        }
//
//
//        // -------------------- parallel()을 써면 오히려 더 오래 걸리게 된다. 병렬 처리중 leftMinRef가 변한값이 필요하기 때문?
//        int[] leftMinArr = new int[a.length];
//        int[] rightMinArr = new int[a.length];
//
//        int[] leftMinRef = {a[0]};
//        int[] rightMinRef = {a[a.length - 1]};
//
//        IntStream.range(0, a.length)
//                .forEach(i -> {
//                    leftMinRef[0] = Math.min(leftMinRef[0], a[i]);
//                    rightMinRef[0] = Math.min(rightMinRef[0], a[a.length - i - 1]);
//                    leftMinArr[i] = leftMinRef[0];
//                    rightMinArr[a.length - i - 1] = rightMinRef[0];
//                });
//
//        //-------------------------------------
//        int[] leftMinArr = new int[a.length];
//        int[] rightMinArr = new int[a.length];
//        int leftMin = a[0];
//        int rightMin = a[a.length - 1];
//
//        //람다 캡쳐링 문제(final)
//        IntStream.range(0, a.length).forEach(i -> {
//            leftMin = Math.min(leftMin, a[i]);
//            rightMin = Math.min(rightMin, a[a.length - i - 1]);
//            leftMinArr[i] = leftMin;
//            rightMinArr[a.length - i - 1] = rightMin;
//        });
//
//
//        int[] leftMinArr = IntStream.range(0, a.length)
//                .mapToObj(i -> IntStream.rangeClosed(0, i)
//                        .map(j -> a[j])
//                        .reduce(Integer.MAX_VALUE, Math::min))
//                .mapToInt(Integer::intValue)
//                .toArray();
//
//        int[] rightMinArr = IntStream.range(0, a.length)
//                .mapToObj(i -> IntStream.rangeClosed(i, a.length - 1)
//                        .map(j -> a[j])
//                        .reduce(Integer.MAX_VALUE, Math::min))
//                .mapToInt(Integer::intValue)
//                .toArray();
//    }
    }
}