import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 15;

    //** Создаем массив, который проверяет вместимость. Если вместимость <= 0, то выбрасывает IllegalArgumentException */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        }
        elements = new Object[initCapacity];
    }

    /**
     * Создаем массив с вместимостью по умолчанию. Вместимость по умолчанию равна 15 элементам
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Добавление элемента в конец коллекции
     */
    @Override
    public void add(T element) {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        elements[size] = element;
        size++;
    }

    /**
     * Добавление элемента в коллекцию в позицию index
     */
    @Override
    public void add(int index, T element) {
        if (elements.length == size + 1) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        System.arraycopy(elements, 0, element, index + 1, size - 1);
        elements[index] = element;
        size++;
    }

    /**
     * Замена элемента в указанной позиции (index) на переданный элемент (element)
     */
    @Override
    public void set(int index, T element) {
        elements[index] = element;
    }

    /**
     * Получение элемента по индексу
     */
    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    /**
     * Возвращает первый элемент коллекции. Если массив пустой, то NoSuchElementException()
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        return get(0);
    }

    /**
     * Возвращает последний элемент коллекции. Если массив пустой, то NoSuchElementException()
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        return get(size - 1);
    }

    /**
     * Удаляем элемент из коллекции
     */
    @Override
    public T remove(int index) {
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }

    /**
     * Проверка коллекции на наличие переданного элемента
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка коллекции на "пустоту"
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Размер коллекции
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Удаление всех элементов из коллекции
     */
    @Override
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }
}