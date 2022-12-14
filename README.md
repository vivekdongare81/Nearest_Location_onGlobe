# Nearest_Location_onGlobe
Problem Statement - Find the Nearest location (Latitude-Longitude Pair) from given Dataset of around 8 Lakh records after parsing and cleaning given Raw .txt file

SubTasks <br/> - Clean and parse given dataSet of .txt file to CSV <br/>
         - According to given input Location, Find exact Loc if exits else find Nearest Location in a Optimize way.
         
## Prerequisite 

- Java SE 8 (JDK 1.8)

         
## Demo 

Solution 1 - src/com/solutions/Haversine_Dist.java <br/>
             - Loop throughout the data and parallely Calculate the Distance from the given Location to each Lat-Long Pair, Keep Track of Least Distance Found. <br/>
             Time Comp. - O(n) ,where n is Total Number of loacations. [SEARCH] <br/>
             Real Time - 1219 ms
             
 ![image](https://user-images.githubusercontent.com/74758376/182136745-69f02b2c-26dd-44cc-9364-8320f4f7a914.png)

Solution 2 - src/com/solutions/TwoD_BinaryTree.java <br/>
            - Store the data into Binary Trees in such a way that it represent 2D arrangements of Points by partitioning it on the basis of alternate x and y co-ordinates <br/>
            Time Comp. - O(log h) , where h is height of Binary tree [ SEARCH ] <br/>
            Real Time - 41 ms  
            
![image](https://user-images.githubusercontent.com/74758376/182138032-35b8de6e-795d-44da-b8cd-f348e87209af.png)

## Installation to Run Locally

 -  Step 1 - Clone the project and navigate to the project directory
  
```bash
git init 
git clone < repo link >

```

 -  Step 2 - Extract allCountries.rar
 -  Step 3 - Run parseTxtToCSV.java to parse Raw Txt to cleaned CSV
 


|     Referred Links                                                                  |
|  ------------------------------------------------------------------ |
| [https://youtu.be/BK5x7IUTIyU](https://youtu.be/BK5x7IUTIyU)|
| [https://algorist.com/problems/Kd-Trees.html](https://algorist.com/problems/Kd-Trees.html)|

