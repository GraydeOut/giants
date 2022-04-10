What does this program do?
**************************
This program simulates several cashier lines as queues. By adjusting the amount of customers, whether
they are full/self service and their arrival/service times you can attempt to find a balance between
customer satisfaction and line efficiency.  

Note:
*****
Due to current limitations the simulation will only allow one customer to arrive per minute.

Instructions:
*************
To run this project start from the Main class. Follow prompts in the console to enter time ranges for 
arrival and service durations. Next you must enter how much longer self service takes as a percentage.
Then enter the number of full and self service lines. Generally you want about 1.25-2 self service lines 
for each full service line. Lastly enter the number of customers to be simulated. If the number of 
customers is greater than approximately 700 you will not see all the individual statistics for each 
customer. Note that any time and customers must be greater than zero. Also there must be at least 
one line. After providing the initial conditions the program will simulate the queues and then output 
to console some statistics.

Good sttarting values for two 7AM-9PM retails stores:
*****************************************************
Good starting numbers for a smaller retail store is arrival 1-4, service 2-6, self service modifier 20%,
	1 full service line, 2 self service lines, 325 customers. 

For a larger retail store use arrival 1, service 2-7, self service modifier 20%, 3 full service lines,
	3-4 self service lines, and 850 customers.

Author:
*******
Gray English <dre2123@email.vccs.edu>