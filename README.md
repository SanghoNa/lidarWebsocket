# lidarWebsocket
processing websocket library for broadband communication


프로세싱용 웹소켓 라이브러리로, 단순 서버, 클라이언트 통신 뿐 아니라 고대역폭 데이터 통신 또한 가능합니다. 
라이다 센서의 클라우드포인트 데이터를 주고 받기 위한 용도로 설계되었으나, 일반적인 웹소켓 용으로 사용 가능하며, 단순 메시지 이외에 다양한 string buffer를 주고 받을 수 있습니다. 
A WebSocket library for processing that supports not only simple server-client communication but also high-bandwidth data transmission.
It was designed for exchanging LiDAR sensor point cloud data but can be used as a general WebSocket library. In addition to simple messages, it allows the transmission of various string buffers.

lidarws/src/main/java/com/lidarws
경로에 라이브러리 빌드를 위한 java 가 있습니다. 
There is a Java file in the path for building the library.

WebSocketServer.java
WebSockerServerEndPoint.java  
위 두 파일은 웹소켓 서버를 생성합니다. 
The two files above create a WebSocket server.

WebSocketClientMessage.java
위 파일은 단순 메시지를 주고 받는 웹소켓 클라이언트를 생성합니다. 
The file above creates a WebSocket client for sending and receiving simple messages.

WebSocketClient.java
위 파일은 웹소켓 클라이언트를 생성하고 라이다 서버 데이터를 받아 원하는 오브젝트의 데이터를 파싱하도록 합니다.
The file above creates a WebSocket client, receives LiDAR server data, and parses the data for the desired object.

DataController.java
데이터를 파싱하고 프로세싱에서 사용가능한 ArrayList 및 PVector등으로 반환 합니다.
It parses the data and returns it as an ArrayList, PVector, and other formats usable in Processing.


위 라이브러리를 제작하기 위해 Maven 빌더를 사용하였고
구체적인 dependency는 pom.xml을 참조해주세요. 
Maven Builder was used to create the library.
For specific dependencies, please refer to the pom.xml file.

resource/sensr_proto
안의 프로토콜 버퍼 파일들은 서울로보틱스사의 sensr 파일을 이용하였으며, Java 버젼으로 컴파일하여 사용하였습니다. 
https://github.com/seoulrobotics/sensr_proto
위의 경로에서 해당 파일들을 확인 가능합니다. 
The protocol buffer files inside were sourced from Seoul Robotics' SENSR files and compiled into the Java version for use.
You can check the files at the following link:
https://github.com/seoulrobotics/sensr_proto

