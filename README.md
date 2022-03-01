# eleven


Requirements :  
  Maven
  
This project runs on spring-boot and primefaces.   
To start application run  "mvn spring-boot:run" after compiling.  

Application server runs on port : 6161  

Ui link is : http://localhost:6161/conference/index.xhtml  

Meetings can be added via ui input areas or can be set by giving a json. Using json replaces everything and deletes old data.   

Json example is as follows :

[  
&emsp;{  
&emsp;&emsp;"name":"Architecting Your Codebase",  
&emsp;&emsp;"length":60  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Overdoing it in Python",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Flavors of Concurrency in Java",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Ruby Errors from Mismatched Gem Versions",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"JUnit 5 - Shaping the Future of Testing on the JVM",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Cloud Native Java",  
&emsp;&emsp;"length":5  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Communicating Over Distance",  
&emsp;&emsp;"length":60  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"AWS Technical Essentials",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Continuous Delivery",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Monitoring Reactive Applications",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Pair Programming vs Noise",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Rails Magic",  
&emsp;&emsp;"length":60  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Microservices \"Just Right\"",  
&emsp;&emsp;"length":60  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Clojure Ate Scala (on my project)",  
&emsp;&emsp;"length":45  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Perfect Scalability",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Apache Spark",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"Async Testing on JVM",  
&emsp;&emsp;"length":60  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"A World Without HackerNews",  
&emsp;&emsp;"length":30  
&emsp;},  
&emsp;{  
&emsp;&emsp;"name":"User Interface CSS in Apps",  
&emsp;&emsp;"length":30  
&emsp;}  
]  

![image](https://user-images.githubusercontent.com/100146804/156263429-67c88bca-a085-4681-a21d-72de7de4151f.png)
![image](https://user-images.githubusercontent.com/100146804/156263463-36c8fd46-1540-4d5a-8ecf-ad869d4fb119.png)
