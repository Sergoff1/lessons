package BloomFilter;

abstract class BloomFilter<T> {

    //Конструкторы
    //постусловие: создан новый фильтр Блюма
    //public BloomFilter<T> BloomFilter(int length);

    //Команды

    //постусловие: в фильтр добавлено новое значение
    public abstract void add(T item);

    //Запросы
    public abstract boolean isValue(T item); //Содержится ли переданное значение в фильтре.
                                             // Допускаются ложноположительные срабатывания
}

class BloomFilterImpl<T> extends BloomFilter<T> {

    private static final int INT_BITS_NUM = 32;

    private int length;
    private int[] filter;

    public BloomFilterImpl(int length) {
        this.length = length;
        filter = new int[length / INT_BITS_NUM + (length % INT_BITS_NUM == 0 ? 0 : 1)];
    }

    @Override
    public void add(T item) {
        int position1 = hash1(item);
        int position2 = hash2(item);

        filter[position1 / INT_BITS_NUM] |= (1 << (position1 - position1 / INT_BITS_NUM * INT_BITS_NUM));
        filter[position2 / INT_BITS_NUM] |= (1 << (position2 - position2 / INT_BITS_NUM * INT_BITS_NUM));
    }

    @Override
    public boolean isValue(T item) {
        int position1 = hash1(item);
        int position2 = hash2(item);
        int mask1 = (1 << (position1 - position1 / INT_BITS_NUM * INT_BITS_NUM));
        int mask2 = (1 << (position2 - position2 / INT_BITS_NUM * INT_BITS_NUM));

        return (filter[position1 / INT_BITS_NUM] & mask1) != 0 && (filter[position2 / INT_BITS_NUM] & mask2) != 0;
    }

    private int hash1(T item) {
        return Math.abs((item.hashCode() * 17) % length);
    }

    private int hash2(T item) {
        return Math.abs((item.hashCode() * 223) % length);
    }
}
