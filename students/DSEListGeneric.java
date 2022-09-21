package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 *
 */

public class DSEListGeneric<T> implements ListGeneric<T> {
	
	public NodeGeneric<T> head;
	public NodeGeneric<T> tail;

	public DSEListGeneric() {
		
		this.head = null;
		this.tail = null;
		
		
	}
	public DSEListGeneric(NodeGeneric<T> head_) {
	
		this.head = head_;
		this.tail = null;
	
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric<T> other) { // Copy constructor. 
		

		//Node current will point to head  
        NodeGeneric<T> current = other.head;    
         
        while(current != null) {  
            
        	this.add(current.get());
            current = current.next;  
        
        }  
	}

	//remove first matching object instance
	public T remove(int index){
			
		T nodeToRemove = this.get(index);
		this.remove(nodeToRemove);
		return nodeToRemove;
	
		    
		  

		}

	//returns the index of the node parameter 
		public int indexOf(Object node) {
		
			NodeGeneric<T> currentNode = this.head;
		    int counter = 0;
		 
		    while (currentNode != null) {
		      
		    	if (currentNode.get().equals(node)) {
			        
		    		return counter;
		    	}
		      
		    	currentNode = currentNode.next;
		    	counter++;
		    }
		    
		    return -1;
		
		}
	
		//returns object at parameter's index
		public T get(int index) {
		
				NodeGeneric<T> currentNode = this.head;
			    int counter = 0; 
			 
			    while (currentNode != null) {
			      
			    	if (counter == index) {
				        
			    		return currentNode.get();
			    		
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
			NodeGeneric<T> current = head; 
	        int totalNodes = 0;
			
			if(head == null) {  
		           
	            return 0;
	        }  
			
			 while(current != null) {  
		            
		            totalNodes += 1;  
		            current = current.next; 
		        }  
		        
		   return totalNodes;
		
		}
	
		//Take each element of the list a writes them to a string 
		@Override
		public String toString() {
		
			//Node current will point to head  
			NodeGeneric<T> current = this.head;  
	        String text = "";
	        
	        if(current == null) {  
	           
	        	return text;
	        }  
	         
	        while(current != null) {  
	            //Print each node and then go to next.  
	            text += current.get().toString() + " ";  
	            current = current.next;  
	        }  
	        
	        //strip tailing " " char
	        text = text.substring(0, text.length() - 1); 
	        return text;
		
		}

		//Appends the specified element to the end of this list.
		
		public boolean add(T obj) {
			
			//if list is empty, head and tail point to new node
			if(this.head == null) {
				
				NodeGeneric<T> initialNode = new NodeGeneric<T>(null, null, obj);
				this.head = initialNode;
				this.tail = initialNode;
				
			}
			
			//add new node to the end of list
			else {
				
				NodeGeneric<T> subsequentNode = new NodeGeneric<T>(null, null, obj);
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


		//add object at parameter's index
		public boolean add(int index, T obj) {
			
			
			if (index < 0) {
				
				return false;
				
			}
			
			if(index > (this.size() - 1)) { // insert at tail as requested index is larger than current list
				
				this.add(obj); // use standard add method to insert at tail
				return true;
				
			}
			
			NodeGeneric<T> genericNode = new NodeGeneric<T>(null, null, obj);
			
			
			if (head == null){ // list is empty, index must be 0
				
				head = genericNode;
				tail = genericNode;
			
			}
			
			else if (index == 0) { // insert before head
				
				genericNode.next = head;
				head.prev = genericNode;
				head = genericNode;
			
			}
			
			else {
				
				NodeGeneric<T> current = head;
				NodeGeneric<T> temp = null;  
				   
		        for(int i = 1; i < index; i++){  
		                
		        	current = current.next;  
		            
		        }  
		        
		        //Node temp will point to node next to current  
	            temp = current.next;  
	            temp.prev = current;  
	  
	            //newNode will be added between current and temp  
	            current.next = genericNode;  
	            genericNode.prev = current;  
	            genericNode.next = temp;  
	            temp.prev = genericNode;  
	            
	            tail.next = null;
				
			
			}
		
			
			return true;
		
		
		}

		//searches list for given object 
		public boolean contains(Object obj) {
		
			NodeGeneric<T> currentNode = this.head;
			 
		    while (currentNode != null) {
		      
		    	if (currentNode.get().equals(obj)) {
		    		
		    		return true;
			       
		      }
		      
		    	currentNode = currentNode.next;
		    }
		    
		    return false; //string not found
		
		}

		//removes the parameter's String form the list
		public boolean remove(T obj) {
		
			NodeGeneric<T> nodeToRemove = null;
			NodeGeneric<T> currentNode = this.head;
		 
		    while (currentNode != null) {
		      
		    	if (currentNode.get().equals(obj)) {
			        
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
		    	//this.head.prev = null; //this causes unit test error but my driver code indicates its working well?
		    	
		    
		    }
		    
		    else if (nodeToRemove == this.tail) {
		    	
		    	this.tail = nodeToRemove.prev;
		    	this.tail.next = null;
		    	
		    
		    } 
		    
		    else {
		      
		      NodeGeneric<T> nextNode = nodeToRemove.next;
		      NodeGeneric<T> previousNode = nodeToRemove.prev;
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
