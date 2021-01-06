public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    /** A constructor that makes an empty ArrayDeque instance */
    public ArrayDeque() {
        items = (T[]) new Object[100];
        size = 0;
        first = 100 / 2;
        last = 100 / 2;
    }

    /** A constructor that makes a deep copy of an ArrayDeque instance.
     * @param other
     * */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        size = 0;
        first = other.last;
        last =  other.last;
        int i = other.last;
        while (size != other.size()) {
            if (i < 0) {
                i = other.items.length - 1;
            } else if (i > other.items.length - 1) {
                i = 0;
            }
            addFirst((T) other.items[i]);
            i -= 1;
        }
    }

    /** A method that checks if an ArrayDeque is empty.
     * @return boolean
     * */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** A method that resizes an instance of an ArrayDeque to the target capacity.
     * @param capacity
     * */
    private void resize(int capacity) {
        T[] nuItems = (T[]) new Object[capacity];
        int i = 0;
        int index = capacity / 2;
        while (i < size) {
            if (index > capacity - 1) {
                index = 0;
            }
            nuItems[index] = get(i); i += 1; index += 1;
        }
        items = null;
        items = nuItems;
        first = capacity / 2;
        last = index - 1;
    }

    /** A method that returns the size of an ArrayDeque instance.
     * @return int size
     * */
    public int size() {
        return size;
    }

    /** A method that adds item n to the front of an ArrayDeque instance.
     * @param item
     * */
    public void addFirst(T item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        if (size == 0) {
            items[first] = item;
            size += 1;
            if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                this.resize(items.length / 2);
            }
        } else {
            if (first == 0) {
                first = items.length - 1;
                items[first] = item;
                size += 1;
                if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                    this.resize(items.length / 2);
                }
            } else {
                first -= 1;
                items[first] = item;
                size += 1;
                if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                    this.resize(items.length / 2);
                }
            }
        }
    }

    /** A method that adds item n to the end of an ArrayDeque instance.
     * @param item
     * */
    public void addLast(T item) {
        if (size == items.length) {
            this.resize(size * 2);
        }
        if (size == 0) {
            items[last] = item;
            size += 1;
            if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                this.resize(items.length / 2);
            }
        } else {
            if (last == items.length - 1) {
                last = 0;
                items[last] = item;
                size += 1;
                if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                    this.resize(items.length / 2);
                }
            } else {
                last += 1;
                items[last] = item;
                size += 1;
                if (((double) size) / items.length <= 0.25 && items.length >= 16) {
                    this.resize(items.length / 2);
                }
            }
        }
    }

    /** A method that removes and returns the first item from an ArrayDeque instance.
     * @ return T item
     * @source
     * https://stackoverflow.com/questions/19090526/
     * dividing-two-integers-to-a-double-in-java/19090582
     * Used source to learn how to convert an integer to a double for more precise division.
     * */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T removed = items[first];
        items[first] = null;
        size -= 1;
        first += 1;
        if (size == 0) {
            first = items.length / 2;
            last = items.length / 2;
        } else if (first > items.length - 1) {
            first = 0;
        } else if (((double) size) / items.length <= 0.25 && items.length >= 16) {
            this.resize(items.length / 2);
        }
        return removed;
    }

    /** A method that removes and returns the last item from an ArrayDeque instance.
     * @ return Neema */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T removed = items[last];
        items[last] = null;
        size -= 1;
        last -= 1;
        if (size == 0) {
            first = items.length / 2;
            last = items.length / 2;
        } else if (last < 0) {
            last = items.length - 1;
        } else if (((double) size) / items.length <= 0.25 && items.length >= 16) {
            this.resize(items.length / 2);
        }
        return removed;
    }

    /** A method that returns an item located by the given index of an ArrayDeque instance.
     * @param i
     * @return Neema item */
    public T get(int i) {
        if (this.isEmpty()) {
            return null;
        } else if (i > items.length - 1) {
            return null;
        } else {
            if (first + i > items.length - 1) {
                return items[first + i - items.length];
            } else {
                return items[first + i];
            }
        }
    }

    /** A method that prints each item of an ArrayDeque instance in order. */
    public void printDeque() {
        ArrayDeque copy = new ArrayDeque(this);
        while (!copy.isEmpty()) {
            System.out.println(copy.removeFirst());
        }
        System.out.println();
    }
}
