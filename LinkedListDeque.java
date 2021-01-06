public class LinkedListDeque<T> {
    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        private TNode(T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private TNode sentinel;
    private int size;

    /** A constructor that makes an empty LinkedListDeque instance. */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** A constructor that creates a deep copy of a given LinkedListDeque instance.
     * @param other
     */
    public LinkedListDeque(LinkedListDeque other) {
        //use this somehow? deepCopy is lost and going to default empty LinkedListDeque
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        if (!other.isEmpty()) {
            addFirst((T) other.sentinel.next.item);
            TNode node = other.sentinel.next.next;
            while (node != other.sentinel) {
                addLast((T) node.item);
                node = node.next;
            }
        }
    }

    /** A method that checks if a LinkedListDeque is empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** A method that adds item x to the front of a LinkedListDeque instance.
     *
     * @param item
     */
    public void addFirst(T item) {
        if (this.isEmpty()) {
            sentinel.next = new TNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        } else {
            TNode ogNode = sentinel.next;
            sentinel.next = new TNode(item, ogNode, sentinel);
            ogNode.prev = sentinel.next;
            ogNode.next = sentinel.next.next.next;
            size += 1;
        }
    }

    /** A method that adds item x to the end of a LinkedListDeque instance.
     *
     * @param item
     */
    public void addLast(T item) {
        if (this.isEmpty()) {
            sentinel.next = new TNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        } else {
            TNode ogNode = sentinel.prev;
            sentinel.prev = new TNode(item, sentinel, ogNode);
            ogNode.next = sentinel.prev;
            size += 1;
        }
    }

    /** A method that removes and returns the last item from a LinkedListDeque instance.
     *
     * @ return T item
     * */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            T removedItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel.prev.next.next;
            size -= 1;
            return removedItem;
        }
    }

    /** A method that removes and returns the first item from a LinkedListDeque instance.
     *
     * @ return T item
     * */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            T removedItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return removedItem;
        }
    }

    /** A method that returns the size of a LinkedListDeque instance.
     *
     * @return int size
     */
    public int size() {
        return size;
    }

    /** An iterative method that returns an item located by the given index of
     * a LinkedListDeque instance.
     * @param i
     * @return T item
     */
    public T get(int i) {
        TNode node = sentinel.next;
        int index = 0;
        if (this.isEmpty()) {
            return null;
        } else if (i > size - 1) {
            return null;
        } else {
            while (index != i) {
                node = node.next;
                index += 1;
            }
        }
        return node.item;
    }

    /** A recursive method that returns an item located by the given index of
     * a LinkedListDeque instance.
     * @param i
     * @return T item
     */
    public T getRecursive(int i) {
        if (this.isEmpty()) {
            return null;
        } else if (i == 0) {
            return sentinel.next.item;
        } else {
            LinkedListDeque<T> copy = new LinkedListDeque(this);
            copy.sentinel = copy.sentinel.next;
            return copy.getRecursive(i - 1);
        }
    }

    /** A method that prints each item in a LinkedListDeque instance. */
    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println();
        } else {
            TNode node = sentinel;
            while (node.next != sentinel) {
                System.out.println(node.next.item);
                node = node.next;
            }
            System.out.println();
        }
    }
}
