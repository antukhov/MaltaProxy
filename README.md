# Malta Proxy
Lightweight proxy based on Java

### :bulb: &nbsp; Idea

To create a simple and lightweight cached proxy server based on Java SE with no dependencies

### :gear: &nbsp; Components
* Java SE `Tested with OpenJDK 15`

## Performance 

Feel free to use config file [MaltaProxy_JMeter_performance_test.jmx](MaltaProxy_JMeter_performance_test.jmx) with [test data with the request body samples](MaltaProxyCannedJsonDeviceData10k.csv)
 for performance test measurement in [JMeter](https://jmeter.apache.org/).
  
Run JMeter test in command line with specifying the log file with results:   
```
jmeter -t MaltaProxy_JMeter_performance_test.jmx -n -l jMeterDetailedResults.csv
```  
  
To update settings or run JMeter in GUI run `jmeter` in command line, open the [MaltaProxy_JMeter_performance_test.jmx](MaltaProxy_JMeter_performance_test.jmx), change the options and save it.
  
## How to run

Simple run:

```
java -jar /project_root/out/artifacts/MaltaProxy.jar SERVER_PORT=8081 THREADS=4 
```

With ZGC and echo to the log file:
  
```
java -XX:+UseZGC -Xms128m -Xmx1024m -XX:+UseLargePages -XX:ConcGCThreads=2 -jar /project_root/out/artifacts/MaltaProxy.jar SERVER_PORT=8081 THREADS=4 > detailedLog.log 2>&1
```
  
## Class diagram

<img src="MaltaProxyDiagram.png">

## Support

If you need any kind of support don't hesitate to let me know :wink:
  
Created by [Alex Antukhov](https://www.linkedin.com/in/antukhov/) 
