# Question: Phone charging
![](img.png)
  
Saman hopes to create a simple product that calculates how long it will take to charge the amount of battery available in any phone. This is an app that allows you to find out the current battery capacity percentage of the phone, the number of years the mobile phone has been used and the time it takes to charge the charger after entering it. Create the program needed to complete the software.

### Notes

1. If the current capacity of the battery **C** is less than 40% then 2 hours should be added to any phone. 40% -60% names take 1 hours. 60% -100% is 30 minutes.

2. If the year of use of the phone **Y** is more than 2 years, one hour should be entered and if it is less than 30 minutes.

3. If the voltage **V** is 1, it is called 1 hour and if the voltage is 1.5, it is stated as half an hour.  

The number of hours depends on the 3 methods used.

### Constraints
0% <= *C* <= 100%  
**V = 1** or **V = 1.5**

### Inputs :
**C** , **Y** and **V**

### Output :
Specify the time it takes for the phone to fully charge.

### Sample Input
61%  
2 years  
1.5v  

### *Sample Output*
2 hours

## Important
Feel free to use any programming language. (Eg: **Java** or **C++**)  
If the user's input is not correct, you should throw an exception. For those who are unfamiliar with exception handling, just print an Error message.  

#### Question was taken from BitCode V 3.0
Organized by  
<b>BITSA</b>  
Department of Information Systems  
Faculty of Management  
Rajarata University of Sri Lanka  
