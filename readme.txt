Group Members:
	- Shubham Raosaheb Kharde(sxk173732)
	- Pranita Hatte (prh170230)
-----------------------------------------------------------------------------------------
Software stack used while developing and running the project:	
	- Language: Java 8
	- Compiler: jdk1.8.0_171
	- IDE: Eclipse JEE Oxygen
	- O/S: Windows 10
-----------------------------------------------------------------------------------------
Instructions to compile and run the project from command line:
	- Naviagate to sxk173732_prh170230_SP1 and open command prompt at this location
	- Compile the source file 
		- "javac -cp . sxk173732\DoublyLinkedList.java"
	- Run the program using any of the following two approaches
		1. "java sxk173732.DoublyLinkedList"
			- This will create a linked list of 10 elements [1 to 10]
		2. "java sxk173732.DoublyLinkedList <size of the list>"
			- This will create a linked list of the specified size [1 to size]
------------------------------------------------------------------------------------------
Instructions to compile and run the project from eclipse IDE:
	- Create a new java project
	- Create package with name sxk173732. 
	- Copy both the source files in the package. 
	- Run the program using any of the following two approaches
		1. Right click DoublyLinkedList.java file --> Run As -> Run Configurations.
			- Click on Arguments tab. Under Program arguments, enter the size of the list.
			- Click Apply and then Run
		2. Right click DoublyLinkedList.java file --> Run As -> Java Application
			- This will create a linked list of 10 elements
------------------------------------------------------------------------------------------
Use following options to test the functionality when the program is running
		0 - Get the previous element [Tests hasPrev() and prev()]
		1 - Get the next element [Tests hasNext() and next()]
		2 - Remove the current element [Tests remove()]
		3 - Add element at the cursor [Tests add(x)]
------------------------------------------------------------------------------------------

Sample Input:
1 1 1 2 0 3 3 0 0 

Sample Output:
10: 1 2 3 4 5 6 7 8 9 10 
1
2
3
9: 1 2 4 5 6 7 8 9 10 
1
Enter a number to add into list
10: 1 3 2 4 5 6 7 8 9 10 
1
10: 1 3 2 4 5 6 7 8 9 10 
10: 1 2 5 7 9 3 4 6 8 10 	