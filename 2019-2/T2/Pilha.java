public class Pilha{

  private class Node {

    public Node next;
    public Node prev;
    public Double element;

    public Node(Double element) {
      this.next = null;
      this.prev = null;
      this.element = element;
    }
  }

  private Node header;
  private Node trailer;
  private int count;


  public Pilha() {
    this.header = new Node(null);
    this.trailer = new Node(null);
    header.next = trailer;
    trailer.prev = header;
    count = 0;
  }

  public void push(Double element) {
    Node aux = new Node(element);
    aux.next = trailer;
    aux.prev = trailer.prev;
    trailer.prev.next = aux;
    trailer.prev = aux;
    count++;
  }

  public Double pop() {
    try {
      if(count == 0){
        throw new IndexOutOfBoundsException("Out of bounds");
      }
      Double last = trailer.prev.element;
      trailer.prev.prev.next = trailer;
      trailer.prev = trailer.prev.prev;
      count--;

      return last;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Stack is empty");
      return null;
    }
  }


  public Double top() {
    try {
      if(this.isEmpty()){
        throw new IndexOutOfBoundsException("Out of bounds");
      }
      Double top = trailer.prev.element; 
      return top;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Stack is empty");
      return null;
    }
  }

  public int size() {
    return count;
  }

  public boolean isEmpty() {
    return (count == 0);
  }

  public void clear() {
    trailer.prev = header;
    header.next = trailer;
    count = 0;
  }

  public void imprime(){
    Node aux = header.next;
    while(aux.element != null){
      System.out.printf("%f, ",aux.element);
      aux = aux.next;
    }
    System.out.println();
  }
}