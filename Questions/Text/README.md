# Text
![](img.png)

### Difficulty: Easy  
  
Shalika has an idea to create a computer program to distinguish a few specific words in a given sentence. Shalika gives you the following information about this.
  
After giving the number of characters to start **S** and the number to end **E**, the relevant part should be printed. If the number of characters in the middle of a word starts or ends, that word must also be applied to the output.  

## Input Format

Number of Charachters The initial and final values to be separated are separated by a single space and input in the first line. The relevant sentence is issued in the second line.

## Constraints
**S** ≥ 0  
**E** ≥ 5  
**S** < **E**  

## Output Format
Print words related to the given range.  
  
If not **S** >= 0 : print "Error: Start Number"  
If not **E**  >= 5 : print "Error: End Number"  
if **S** > **E** : print "Error: Range"  

## Sample Input

15 45  
Video games have been around since the 1940s and 1950s. As part of their computer science study, computer scientists began working on the early phases of video games by building simulations and artificial intelligence.  

## Sample Output

have been around since the 1940s  

## Important
Feel free to use any programming language. (Eg: **Java** or **C++**)  
If the user's input is not correct, you should throw an exception. For those who are unfamiliar with exception handling, just print an Error message.  

#### Question was taken from BitCode V 3.0
Organized by  
<b>BITSA</b>  
Department of Information Systems  
Faculty of Management  
Rajarata University of Sri Lanka  
