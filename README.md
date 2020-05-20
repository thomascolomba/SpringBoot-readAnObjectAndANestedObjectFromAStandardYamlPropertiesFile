How to read an object and a nested object from the standard application.yaml with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readObjectAndNestedObjectFromAYamlPropertiesFile-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
---application.yaml<br/>
myObject:<br/>
&nbsp;&nbsp;myString1: qwerty1<br/>
&nbsp;&nbsp;myString2: qwerty2<br/>
<br/>
mySecondObject:<br/>
&nbsp;&nbsp;myNestedObject:<br/>
&nbsp;&nbsp;&nbsp;&nbsp;myInt1: 123<br/>
&nbsp;&nbsp;&nbsp;&nbsp;myInt2: 456<br/>
<br/>
myHashMap:<br/>
&nbsp;&nbsp;myString1:&nbsp;qwerty3<br/>
&nbsp;&nbsp;myString2:&nbsp;qwerty4<br/>
---MyConfigurationBean.java<br/>
private MyObject myObject;<br/>
private MySecondObject mySecondObject;<br/>
&nbsp;&nbsp;public static class MyObject {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private String myString1;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;private String myString2;<br/>
public static class MySecondObject {<br/>
&nbsp;&nbsp;private MyNestedObject myNestedObject;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;public static class MyNestedObject {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private Integer myInt1;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;private Integer myInt2;<br/>
+getter and setter<br/>
<b>---MyMyObjectConverter.java and MyMySecondObjectConverter.java (they could be merged)<br/>
final ObjectMapper mapper = new ObjectMapper();<br/>
return mapper.convertValue(myObjectFromJson, ....class);<br/></b>
---The class who displays the value of the application.yaml configuration<br/>
@Autowired<br/>
MyConfigurationBean myConf;<br/>
...<br/>
System.out.println(myConf.getMyObject().getMyString1());<br/>
System.out.println(myConf.getMyObject().getMyString2());<br/>
System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt1());<br/>
System.out.println(myConf.getMySecondObject().getMyNestedObject().getMyInt2());<br/>
<br/>
<br/>
The application will read an object and nested object in the standard application.yaml configuration file then display them in the terminal.<br/>


