/**
 * Trabalho 2 da cadeira de Algorítmos e Estruturas de Dados I.
 * 
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

class App {
  public static void main(String[] args) {
    Pilha pilha = new Pilha();

    Path path1 = Paths.get("exemplo4.txt");
    String s = "";
    try(Scanner sc=new Scanner(Files.newBufferedReader(path1,Charset.defaultCharset()))) 
    {
      while (sc.hasNext()) {
        s += sc.next();
        s += " ";
      }
      sc.close();
    } catch (IOException x) {
      System.err.format("Erro de E/S: %s%n", x);
    }
    String[] splitted = s.split(" ");
    for(String op : splitted){
      switch(op){
        case "+": {
          double last = pilha.pop();
          double secondToLast = pilha.pop();
          pilha.push((last + secondToLast));
          break;
        }
        case "-": {
          double last = pilha.pop();
          double secondToLast = pilha.pop();
          pilha.push((last - secondToLast));
          break;
        }
        case "*": {
          double last = pilha.pop();
          double secondToLast = pilha.pop();
          pilha.push((last * secondToLast));
          break;
        }
        case "/": {
          double last = pilha.pop();
          double secondToLast = pilha.pop();
          pilha.push((last / secondToLast));
          break;
        }
        case "swap": {
          double last = pilha.pop();
          double secondToLast = pilha.pop();
          pilha.push(last);
          pilha.push(secondToLast);
          break;
        }
        case "chs": {
          double element = pilha.pop();
          pilha.push((-1 * element));
          break;
        }
        case "pop": {
          pilha.pop();
          break;
        }
        case "dup": {
          pilha.push(pilha.top());
          break;
        }
        case "sqrt": {
          double element = Math.sqrt(pilha.top());
          pilha.push(element);
          break;
        }
        default: {
          double element = Double.parseDouble(op);
          pilha.push(element);
          break;
        }
      }
    }
    pilha.imprime();
  }
}