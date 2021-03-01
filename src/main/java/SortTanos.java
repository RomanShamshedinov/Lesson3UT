public class SortTanos {
    public static void main(String[] args) {
        long[] array = {58, 36, 1, 98, 45, 15, 67, 89, 49, 50};
        System.out.println();
        array = sort(array);
    }

    public static long[] sort(long[] mass) {

        float avg = 0;
        long sum = 0;
        long[] podmass = new long[mass.length]; //Подмассив
        long[] massl; //Левый массив
        long[] massr; //Правый массив
        int countl = 0; //Длинна левого массива
        int countr = 0; //Длинна правого массива
        int count = 0; //Счетчик для остановки рекурсии

        //Найдем среднее массива
        for (int i = 0; i < mass.length; i++) {
            sum += mass[i];
        }
        avg = (float) sum / mass.length;

        //Первая итеррация
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] >= avg) {
                podmass[podmass.length - 1 - countr] = mass[i];
                countr++;
            } else {
                podmass[countl] = mass[i];
                countl++;
            }
        }

        //Копируем подмассив после итерраций в массив
        for (int i = 0; i < mass.length; i++) {
            mass[i] = podmass[i];
        }

        massl = new long[countl]; //Копируем левую часть массива
        for (int i = 0; i < countl; i++) {
            massl[i] = mass[i];
        }

        massr = new long[countr]; //Копируем правую часть массива
        for (int i = 0; i < countr; i++) {
            massr[i] = mass[mass.length - countr + i];
        }

        //Проверяем, не состоит ли левый массив из одинаковых элементов
        for (int i = 0; i < massl.length - 1; i++) {
            if (massl[i] == massl[i + 1]) {
                count++;
            }
        }

        //Рекурсия
        if (countl > 1 && count != massl.length - 1) {
            massl = sort(massl);
        }
        for (int i = 0; i < massl.length; i++) {
            mass[i] = massl[i];
        }
        count = 0;

        //Проверяем, не состоит ли правый массив из одинаковых элементов
        for (int i = 0; i < massr.length - 1; i++) {
            if (massr[i] == massr[i + 1]) {
                count++;
            }
        }

        //Рекурсия
        if (countr > 1 && count != massr.length - 1) {
            massr = sort(massr);
        }

        int k = 0;
        for (int i = countl; i < mass.length; i++) {
            mass[i] = massr[k];
            k++;
        }
        return mass;
    }
}
