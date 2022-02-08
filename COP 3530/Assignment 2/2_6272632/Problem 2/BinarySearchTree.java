package problem.pkg2.pkg2;
/**************************************************************
 Purpose/Description: <In this program we will prgram 4 methods. keySum will 
 * return the sum of all keys in the binary tree. deleteMin will delete the 
 * minimum element in the binary tree. printTree will iterate over the nodes 
 * to print them in increasing order. printPostorder will iterate over the 
 * nodes to print them in post order.>
 Author’s Panther ID: <6272632>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
class BinarySearchTreeNode {
     
    public int key;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;
    
    //constructors
    BinarySearchTreeNode(int key){
        this(key, null, null);
    }

    BinarySearchTreeNode(int element, BinarySearchTreeNode lt, BinarySearchTreeNode rt){
        this.key = element; 
        this.left = lt; 
        this.right = rt;
    }

    public String toString(){
        return "Value: " + key;
    }

}


public class BinarySearchTree {
    
    private BinarySearchTreeNode root;
    
    //Insert Method
    public void insert(int key){
        
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(key);
        
        //if there is no root this will be the new root
        if(root == null){
            root = newNode;
        }else{
            BinarySearchTreeNode currentNode = root;
            BinarySearchTreeNode parent;
            
            while(true){
                parent = currentNode;
                
                //if key should go on left side of parent
                if(key < currentNode.key){
                    currentNode = currentNode.left; //Recurse down the left subtree IF the element is less than current element
                    
                    //if the left child has no children place the new node on the left of it
                    if(currentNode == null){
                        parent.left  = newNode;
                        return;
                        
                    }
                //if key should go on the right side of parent
                }else{
                    currentNode = currentNode.right;
                    
                    //if the right child has no children place the new node on the right of it.
                    if(currentNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
                
    }//End of Insert method.
    
    
    //Delete method
    public boolean delete(int key) {

	//Start at the top of the tree.
	BinarySearchTreeNode currentNode = root;
	BinarySearchTreeNode parent = root;

        //If the tree is empty.
        if (root == null){
            return false;
        }
        
	/* When searching for a Node this willtell us whether to search to the
        right or left.*/
	boolean isLeft = true;

	// While we haven't found the Node keep looking.
	while (currentNode.key != key) {

            parent = currentNode;

            // If we should search to the left.
            if (key < currentNode.key) {
                isLeft = true;

                // Shift the focus Node to the left child.
                currentNode = currentNode.left;

            } else {
                // Greater than focus node so go to the right.
                isLeft = false;
            
                // Shift the focus Node to the right child.
		currentNode = currentNode.right;
            }

            // The node wasn't found.
            if (currentNode == null){
		return false;
            }

	}

	// If Node doesn't have children delete it.
	if (currentNode.left == null && currentNode.right == null) {

            // If root delete it
            if (currentNode == root){
		root = null;
                
            /*If it was marked as a left child of the parent delete it in 
              its parent.*/
            }else if (isLeft){
		parent.left = null;
                
            // Vice versa for the right child.
            }else{
		parent.right = null;
            }
        
        // If no right child.
	}else if (currentNode.right == null) {

            if (currentNode == root){
		root = currentNode.left;

            /*If focus Node was on the left of parent move the focus Nodes 
            left child up to the parent node.*/
            }else if (isLeft){
		parent.left = currentNode.left;

            // Vice versa for the right child.
            }else{
		parent.right = currentNode.left;
            }
        
        // If no left child.
	}else if (currentNode.left == null) {

            if (currentNode == root){
		root = currentNode.right;

            /*If focus Node was on the left of parentmove the focus Nodes 
            right child up to theparent node.*/
            }else if (isLeft){
		parent.left = currentNode.right;

            // Vice versa for the left child.
            }else{
		parent.right = currentNode.right;
            }

        // Two children so I need to find the deleted nodes replacement.
	}else {

            BinarySearchTreeNode replacement = getReplacement(currentNode);

            // If the focusNode is root replace rootwith the replacement
            if (currentNode == root){
		root = replacement;

            // If the deleted node was a left child make the replacement the left child
            }else if (isLeft){
		parent.left = replacement;

            // Vice versa if it was a right child
            }else{
		parent.right = replacement;
                replacement.left = currentNode.left;
            }
	}
	return true;
    }//End of delete method.
    
    
    //Replacement method used in delete method in the case of two children.
    public BinarySearchTreeNode getReplacement(BinarySearchTreeNode replacedNode) {

	BinarySearchTreeNode replacementParent = replacedNode;
	BinarySearchTreeNode replacement = replacedNode;

	BinarySearchTreeNode focusNode = replacedNode.right;

	// While there are no more left children
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
	}

	/* If the replacement isn't the right child move the replacement into 
        the parents leftChild slot and move the replaced nodes right child into
        the replacements rightChild*/
	if (replacement != replacedNode.right) {
            replacementParent.left = replacement.right;
            replacement.right= replacedNode.right;
	}
	return replacement;
    }//End of replacement method.
    
    
    //Search method.
    public BinarySearchTreeNode find(int key){ 
        BinarySearchTreeNode focusNode = root;
        
        while(focusNode.key != key){
            if(key <  focusNode.key){
                focusNode = focusNode .left;
                
            }else{
                focusNode = focusNode.right;
            }
            
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }//End of search method.

    
    //Key sum helper
    public int keySumHelper(BinarySearchTreeNode node){
        int sumL = 0;
        int sumR = 0;
        
        if(node == null){
            return 0;
        }else{
            //traverse left node
            sumL += keySumHelper(node.left);
            
            //traverse right node
            sumR += keySumHelper(node.right);
        }
        return node.key + sumL + sumR;
    }
     
    /*A. Returns the sum of all keys in the tree. 
    PRETRAVERSAL METHOD*/
    public int keySum(){
        return keySumHelper(root);
    }
    
    //Delete min helper
    public BinarySearchTreeNode deleteMinHelper(BinarySearchTreeNode node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMinHelper(node.left);
        return node;
        
    }//End of deleteMin method.
    
    
    /*B. Deletes the minimum element in the tree, or does nothing if the tree 
    has no elements. (DELETE METHOD)*/
    public void deleteMin(){
        deleteMinHelper(root);
    }
    
    //In-order traversal helper
    public void printTreeHelper(BinarySearchTreeNode currentNode){
        if(currentNode != null){
            //traverse left node
            printTreeHelper(currentNode.left);
            
            System.out.println(currentNode);
            
            //traverse right node
            printTreeHelper(currentNode.right);
        }
    }//End of in order method
    
    
    /*C. Iterates over the nodes to print them in increasing order. (IN-ORDER)*/
    public void printTree(){
        printTreeHelper(root);
    }
    
    //Port-order traversal helper
    public void printPostorderHelper(BinarySearchTreeNode currentNode){
        
        if(currentNode != null){
            //traverse left node
            printPostorderHelper(currentNode.left);
            
            //traverse right node
            printPostorderHelper(currentNode.right);
            
            System.out.println(currentNode);
        }
    }//End of post order method.
    
    
    /*D. Prints out the nodes of the tree according to a "postorder" traversal.*/
    public void printPostorder(){
        printPostorderHelper(root);
    }
    
    //Main Method (tester method)
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        
        searchTree.insert(4);
        searchTree.insert(2);
        searchTree.insert(5);
        searchTree.insert(1);
        searchTree.insert(3);
        
        System.out.print("Sum: ");
        System.out.println(searchTree.keySum());
        
        System.out.println("\nIn Order:");
        searchTree.printTree();
        
        System.out.println("\nPost Order:");
        searchTree.printPostorder();
        
        System.out.println("\nAfter removing minimum number with in-order: ");
        searchTree.deleteMin();
        searchTree.printTree();
        
    }//End of main method
    
}
