# Malta Proxy
Lightweight proxy based on Java

### :bulb: &nbsp; Idea

To create a simple and lightweight cached proxy server based on Java SE with no dependencies

### :gear: &nbsp; Components
* Java SE `Tested with OpenJDK 15`

## Performance 

Feel free to use config file [MaltaProxy_JMeter_performance_test.jmx](MaltaProxy_JMeter_performance_test.jmx) with [test data with the request body samples](MaltaProxyCannedJsonDeviceData10k.csv)
 for performance test measurement in [JMeter](https://jmeter.apache.org/).
  
## How to run

`java -XX:ThreadStackSize=1m -XX:MaxGCPauseMillis=100 -jar /project_root/out/artifacts/MaltaProxy.jar`
  
## Class diagram

<img src="MaltaProxyDiagram.png">

## Support

If you need any kind of support don't hesitate to let me know :wink:
  
Created by [Alex Antukhov](https://www.linkedin.com/in/antukhov/) 
