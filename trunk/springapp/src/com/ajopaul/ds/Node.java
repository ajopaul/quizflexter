package com.ajopaul.ds;

public class Node

{
  Node next = null;
  int data;
  
  public Node(int data){
    this.data = data;
  }
  
  public void addNode(int data){
    Node newNode = new Node(data);
    Node current = this;
    while(null != current.next){
      current = current.next;      
    }
    current.next = newNode;
  }
}
