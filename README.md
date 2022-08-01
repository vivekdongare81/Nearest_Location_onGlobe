# Nearest_Location_onGlobe
Problem Statement - Find the Nearest Location (Latitude-Longitude Pair) from given Dataset of around 8 Lakh Records after parsing and cleaning given Raw .Txt File
SubTasks - Clean and Parse given dataSet of .Txt file to CSV
         - According to given input Location, Find Exact pair if exits or Find Nearest Lacation in Optimize way.
         
## Prerequisite 

- Java SE 8 (JDK 1.8)
 
 ##Demo 

Solution 1 - com/solutions/Haversine_Dist.java
             Loop throughout the data and parallely Calculate the Distance from Given the Location to each Lat-Long Pair, Keep Track of Least Distance Found.
             Time Comp. - O(n) ,where n is Total Number of loacations. [SEARCH]
             Real Time - 1200ms
             ![image](https://user-images.githubusercontent.com/74758376/182136745-69f02b2c-26dd-44cc-9364-8320f4f7a914.png)

Solution 2 - com/soultions/TwoD_BinaryTree.java
            Store the data into Binary Trees in such a way that it represent 2D arrangements of Points by partitioning it on the basis of alternate x and y co-ordinates
            Time Comp. - O(log h) , where h is height of Binary tree
            Real Time - 41 ms
            ![image](https://user-images.githubusercontent.com/74758376/182138032-35b8de6e-795d-44da-b8cd-f348e87209af.png)

## Installation to Run Locally


 -  Step 1 - Clone the project and navigate to the project directory
  
```bash
git init 
git clone < repo link >

```

 -  Step 2 - Run ParseTxtToJava.java to parse Raw Txt to Cleaned CSV
 


|     Referred Links                                                                  |
|  ------------------------------------------------------------------ |
| [https://youtu.be/BK5x7IUTIyU](https://youtu.be/BK5x7IUTIyU)|
| [https://jar-download.com/artifacts/com.fasterxml.jackson.core](https://jar-download.com/artifacts/com.fasterxml.jackson.core)|
