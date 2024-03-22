import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 1, 2, 4, 4, 6, 2, 1, 5, 4, 5);
        findMinMax(stream, Comparator.naturalOrder(), (min, max) -> {
            System.out.println("Min: " + min + ", Max: " + max);
        });
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,//Вызов метода stream() в списке для получения потока значений из списка
            Comparator<? super T> order,// order - компаратор для сравнения объектов типа T
            BiConsumer<? super T, ? super T> minMaxConsumer) {//для обработки максимального и минимального значений объектов


        List<? extends T> list = stream.collect(Collectors.toList());
        //Собрать элементы потока и преобразовать их к нужному типу collect()
        T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);
        minMaxConsumer.accept(min, max);
    }
}
