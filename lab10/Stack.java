import java.lang.RuntimeException;

public class Stack<T>
{
    private T[] m_array;
    private int m_size;
    private int m_maxSize;

    @SuppressWarnings("unchecked")
    public Stack(int max_stack_size)
    {
        m_maxSize = max_stack_size;
        m_size = 0;
        m_array = (T[]) new Object[m_maxSize];
    }

    public boolean isEmpty() { return (m_size == 0); }
    public boolean isFull() { return (m_size == m_maxSize); }
    public int getMaxSize() { return m_maxSize; }
    public int getCurrentSize() { return m_size; }
    public T[] getArray() { return m_array; }

    public T pop()
    {
        if(this.isEmpty()) { throw new RuntimeException("Stack is empty."); }
        return m_array[--m_size];
    }

    public void push(T new_object)
    {
        if(this.isFull()) { throw new RuntimeException("Stack is full."); }
        m_array[m_size++] = new_object;
    }

    public Stack<T> copy()
    {
        var result = new Stack<T>(m_maxSize);
        for(int i = 0; i < m_size; i++)
        {
            result.m_array[i] = m_array[i];
        }
        result.m_size = m_size;
        return result;
    }
}
