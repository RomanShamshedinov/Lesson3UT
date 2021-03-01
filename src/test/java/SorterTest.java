import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SorterTest {
    @Test
    //Тест на правильность направления и сортировки массива
    public void compareArray() {
        long[] array = {35, 98, 15, 2, 6, 88, 26};
        long[] expectedArray = {2, 6, 15, 26, 35, 88, 98};
        SortTanos.sort(array);
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    //Тест на длинну массива, т.е. сколько ввели чисел, столько и отсортировал
    public void lengthArray() {
        long[] array = {22, 15, 87, 99, 68};
        SortTanos.sort(array);
        int length = array.length;
        int expectedlength = 5;
        Assertions.assertEquals(expectedlength, length);
    }

    @Test
    //Тест на тип long. Массив сортирует не обрезая длинну
    public void typeElementArray() {
        long[] array = {745477483647L, 846616879891L, 5241883697L};
        long[] expectedArray = {5241883697L, 745477483647L, 846616879891L};
        SortTanos.sort(array);
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    //Тест на правильность сортировки при условии, что есть повторяющиеся элементы
    public void elementsRepeat() {
        long[] array = {2, 88, 15, 15, 15, 68, 9, 9};
        long[] expectedArray = {2, 9, 9, 15, 15, 15, 68, 88};
        SortTanos.sort(array);
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    //Тест на непадение пустого массива
    public void nullArray() {
        long array[] = {};
        long[] expectedArray = {};
        SortTanos.sort(array);
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    //Тест на непадение массива состоящего только из одинаковых элементов
    public void elementRep() {
        long array[] = {2, 2, 2, 2, 2, 2};
        long[] expectedArray = {2, 2, 2, 2, 2, 2};
        SortTanos.sort(array);
        Assertions.assertArrayEquals(expectedArray, array);
    }
}