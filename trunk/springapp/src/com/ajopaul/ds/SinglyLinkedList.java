package com.ajopaul.ds;

public class SinglyLinkedList
{
    class Node{
      int data;
      Node next;
      public Node(int n){
        this.data = n;
      }    
      
    }
    
    Node header = null;
    
    public void append(int data){
      if(header == null){//If first element
        Node node = new Node(data);
        header = node;//assign header;
      }else{
        Node temp = header;
        while(temp.next != null){
          temp = temp.next;
        }
        Node node = new Node(data);
        temp.next = node;
      }
    }
    
    public void display(){
      if(header!= null ){
        if(header.next == null){
          System.out.print(" "+header.data);
        }else{
          Node temp = header;
          System.out.println("\nList contents \n");
          do{
            System.out.print(" "+temp.data);
            temp = temp.next;
          }while(temp.next != null);
          System.out.print(" "+temp.data);
        }
      }else{
        System.out.println("empty list");
      }
    }
    
    public void addAtBeg(int data){
      if(null == header){
        append(data);//Add as first node
      }else{
        Node node = new Node(data);
        node.next = header;
        header = node;
      }
    }
    
    public void count(){
      
    }
    
    public void delete(int data){
      if(null != header){
        
        if(header.data == data && header.next == null){
          System.out.println("\ndeleted "+data+" at header ");
          header = null;
        }else{
          Node temp = header;
          Node prev = header;
          while(temp.next != null){
            
            if(temp.data == data){
              System.out.println("\nDeleted "+data);
              Node tempPrev = temp;
              temp = temp.next;
              if(tempPrev == header){
                header = temp;
              }else{
                prev.next = temp;
              }
            }else{
              prev = temp;
              temp = temp.next;
            }
          }
          if(temp.data == data){//for last element
            System.out.println("\ndelete data at end "+data);
            prev.next = null;
          }
        }
      }
    }
    
    public static void main(String... args){
      SinglyLinkedList list= new SinglyLinkedList();
      list.append(3);
      list.append(3);
      list.append(2);
      list.append(30);
      list.append(40);
      
      //list.display();
      
 /*     list.addAtBeg(5);
     // list.display();
      list.addAtBeg(7);*/
      
      list.display();
      
      list.count();
      
      list.delete( 3);
      list.display();
      list.delete( 10);
      list.display();
      list.delete(20);
      list.display();
      list.delete(40);
      list.display();
      list.delete(5);
      list.display();
      list.delete(30);
      list.display();
    }
    
}
