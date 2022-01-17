/**
 * we parse Point object in assignment in this class, in order to arrange priority for more efficient strategy
 *
 * @param <T> Point object
 */
public class PriorityQueue<T> {
    PNode<T> first = null;   // Remove from Front
    PNode<T> last = null;    // Put on the Back
    int count = 0;      // Number of items in the Queue

    // Uses the Insertion Sort concept of placing new element into array - Shift is low cost
    public void enqueue(T e, int priority) {

        // Find the insertion point for the new item in the Queue
        count++;

        if (first == null) {  // Case 1 : List is empty, first node being add
            first = new PNode(e, priority, null);
            last = first;
        } else {  //Case 2 : the list is not empty
            PNode prev = null;
            for (PNode current = first; current != null; current = current.next) {
                if (priority < current.priority) {
                    if (prev == null)
                        first = new PNode(e, priority, first);    // 2a: adding at front, New first node
                    else
                        prev.next = new PNode(e, priority, current); // 2b: adding in the middle,  New middle node
                    return;
                }
                prev = current;
            }
            last.next = new PNode(e, priority, null);  // 2c: adding at the end
            last = last.next;
        }
    }

    // Always take the top one off the list
    public T dequeue() throws IllegalStateException {
        if (first != null) {
            T temp = first.value;
            first = first.next;
            count--;
            if (first == null)
                last = first;
            return temp;
        }
        throw new IllegalStateException("Queue is Empty");
    }

    public int size() {
        return count;
    }

    public T peek() {
        return first.value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        String text = "[";
        PNode current = first;

        while (current != null) {
            text += String.format("[%d]%s", current.priority, current.value);
            if (current.next != null)
                text += ",";
            current = current.next;
        }
        return text + "]";
    }

    class PNode<T> {
        T value;
        int priority;
        PNode<T> next;

        PNode(T e, int p, PNode n) {
            value = e;
            priority = p;
            next = n;
        }
    }
}
