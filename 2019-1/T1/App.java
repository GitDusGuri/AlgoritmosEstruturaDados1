
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
    
        lista.add(9);        
        lista.add(1);
        lista.add(5);
        lista.add(7);      

        System.out.println(lista);
        
        System.out.println("Removeu numeros pares?"+lista.removeEvenNumbers()); 
        
        lista.add(0,4);
        lista.add(lista.size(),8);
        lista.add(2,6);
        
        System.out.println(lista);
        System.out.println("Removeu numeros pares?"+lista.removeEvenNumbers());
        System.out.println("Lista apos remocoes:\n" + lista);
        
        DoubleLinkedListOfInteger.organizaLista(lista);
        
        System.out.println("Lista organizada:\n"+lista);     
        
        lista.clear();
        lista.add(1);lista.add(18);lista.add(6);lista.add(5);lista.add(4);lista.add(2);lista.add(3);lista.add(0);
        
        DoubleLinkedListOfInteger.organizaLista(lista);
        
        System.out.println("Lista organizada:\n"+lista);  
    }
    
}
