package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head;
	public Node tail;

	public DSEList() {
		this.head = null;
		this.tail = null;
	}
	
	public DSEList(Node head_) {
		this.head = head_;
		this.tail = null;
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) { // Copy constructor. 
		
		//Node current will point to head  
        Node current = other.head;    
         
        while(current != null) {  
            
        	this.add(current.getString());
            current = current.next;  
        
        }  
		
	}

	//remove the String at the parameter's index
	public String remove(int index) {
		
		String nodeToRemove = this.get(index);
		this.remove(nodeToRemove);
		return nodeToRemove;
		
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		
	    Node currentNode = this.head;
	    int counter = 0;
	 
	    while (currentNode != null) {
	      
	    	if (currentNode.getString().equals(obj)) {
		        
	    		return counter;
	    	}
	      
	    	currentNode = currentNode.next;
	    	counter++;
	    }
	    
	    return -1;
	 
	}
	
	//returns String at parameter's index
	public String get(int index) {
	
	    Node currentNode = this.head;
	    int counter = 0; 
	 
	    while (currentNode != null) {
	      
	    	if (counter == index) {
		        
	    		String text = currentNode.getString();
	    		return text;
	    		
		    }
	      
	    	currentNode = currentNode.next;
	    	counter++;
	    }
	    
	    return null;
	
	}

	//checks if there is a list
	public boolean isEmpty() {
	
		if(head == null) {  
	           
            return true;
        }  
		
		else {
			
			return false;
			
		}
		
	}

	//return the size of the list
	public int size() { 
		
		//Node current will point to head  
        Node current = head; 
        int totalNodes = 0;
		
		if(head == null) {  
	           
            return 0;
        }  
		
		 while(current != null) {  
	            
	            totalNodes += 1;  
	            current = current.next; //go to next node
	        }  
	        
	   return totalNodes;
	
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	
		//Node current will point to head  
        Node current = this.head;  
        String text = "";
        
        if(current == null) {  
           
        	return text;
        }  
         
        while(current != null) {  
            //Print each node and then go to next.  
            text += current.getString() + " ";  
            current = current.next;  
        }  
        
        //strip tailing " " char
        text = text.substring(0, text.length() - 1); 
        return text;
		
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		
		//if list is empty, head and tail point to new node
		if(this.head == null) {
			
			Node initialNode = new Node(null, null, obj);
			this.head = initialNode;
			this.tail = initialNode;
			
		}
		
		//add new node to the end of list
		else {
			
			Node subsequentNode = new Node(null, null, obj);
			subsequentNode.next = subsequentNode;
			subsequentNode.prev = tail;
			// add new node to the end of list
			this.tail.next = subsequentNode; 
			//newNode->previous set to tail 
			subsequentNode.prev = tail;
			//newNode becomes new tail
			this.tail = subsequentNode;
			//tail's next point to null  
			this.tail.next = null;
			
			
		}
		
		return true;
	
	}

	//add String at parameter's index
	public boolean add(int index, String obj) {
		
		if (index < 0) {
			
			return false;
			
		}
		
		if(index > (this.size() - 1)) { // insert at tail as requested index is larger than current list
			
			this.add(obj); // use standard add method to insert at tail
			return true;
			
		}
		
		Node newNode = new Node(null, null, obj);
		
		if (head == null){ // list is empty, index must be 0
			
			head = newNode;
			tail = newNode;
		
		}
		
		else if (index == 0) { // insert before head
			
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		
		}
		
		else {
		//else if(index == (this.size() - 1)) { // insert just before tail
			
			 Node current = head;
			 Node temp = null;  
			   
	        for(int i = 1; i < index; i++){  
	                
	        	current = current.next;  
	            
	        }  
	        
	        //Node temp will point to node next to current  
            temp = current.next;  
            temp.prev = current;  
  
            //newNode will be added between current and temp  
            current.next = newNode;  
            newNode.prev = current;  
            newNode.next = temp;  
            temp.prev = newNode;  
            
            tail.next = null;
			
		
		}
		
		
		return true;
		
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
		
	    Node currentNode = this.head;
	 
	    while (currentNode != null) {
	      
	    	if (currentNode.getString().equals(obj)) {
	    		
	    		return true;
		       
	      }
	      
	    	currentNode = currentNode.next;
	    }
	    
	    return false; //string not found
		
	}

	//removes the parameter's String from the list
	public boolean remove(String obj) { //UNCOMMENT ITEMS IN THIS.HEAD AFTER CLARIFICATION
	
		Node nodeToRemove = null;
	    Node currentNode = this.head;
	 
	    while (currentNode != null) {
	      
	    	if (currentNode.getString().equals(obj)) {
		        
	    		nodeToRemove = currentNode;
		        break;
	      
	    	}
	      
	    	currentNode = currentNode.next;
	    }
	 
	    if (nodeToRemove == null) {
	      
	    	return false;
	    
	    }
	    
	    else if (nodeToRemove == this.head) {
	    	
	    	this.head = nodeToRemove.next;
	    	
	    	//this.head.prev = null; //this causes unit test error but my test driver code indicates its working well?
	    	
	    
	    }
	    
	    else if (nodeToRemove == this.tail) {
	    	
	    	this.tail = nodeToRemove.prev;
	    	this.tail.next = null;
	    	
	    
	    } 
	    
	    else {
	      
	      Node nextNode = nodeToRemove.next;
	      Node previousNode = nodeToRemove.prev;
	      nextNode.prev = previousNode;
	      previousNode.next = nextNode;
	    
	    }
	    
	    
	    return true;
		
		
	}
	
	@Override
	public int hashCode() {
		
		int val = this.hashCode();
		return val;
		
	}

	@Override
	public boolean equals(Object other) {
		
		if(this.toString().equals(other.toString())){
			
			return true;
		
		}
		
		else {
			
			return false;
		
		}
	}
	
}
