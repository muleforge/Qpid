








WELCOME
=======
Congratulations you have just created a new Mule transport!

This wizard created a number of new classes and resources useful for Mule transports.  Each of the created files
contains documentation and _todo_ items where necessary.  You'll need to look at each of the classes and other files and
address the _todo_ items in the files. Here is an overview of what was created.

./pom.xml:
A maven project descriptor that describes how to build this project.  If you enabled this project for the
MuleForge, this file will contain additional information about the project on MuleForge.

./assembly.xml:
A maven assembly descriptor that defines how this project will be packaged when you make a release.

./LICENSE.txt:
The open source license text for this project.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/i18n/QpdMessages.java:

The QpdMessages java class contains methods for access i18n messages embedded in your java code.

-----------------------------------------------------------------
./src/main/resources/META-INF/services/org/mule/i18n/qpd-messages.properties

These message properties contain i18n strings used by QpdMessages.java.


-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdConnector.java

The connector for this transport. This is used for configuing common properties on endpoints for this transport
and initialising shared resources.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdEndpointURIBuilder.java

The class responsible for parsing custom endpoints for this transport.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdInboundTransformer.java

This transformer should convert the inbound message into a type consumable by Mule.  For example, in the case of JMS this
class would would convert a JMSMessage to a String, object, Map, etc depending on the time of message.  If your transport
does not have a specific message type you do not need this class (see QpdMessageAdapter).

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdOutboundTransformer.java

This transformer should convert the otbound message into a type supported by the underlying technology.  For example,
in the case of JMS this class would would convert a MuleMessage to a JMSMessage.  If your transport
does not have a specific message type you do not need this class.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdMessageAdapter.java

This class is used to wrap inbound messages and access the data in the message in a unified way.  The MessageAdapter provides
access to the payload, message headers and attachments.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/QpdMessageReceiver.java

This part of the transport responsible for inbound endpoints.  This class should implement the logic need to
receive messages from the underlying transport.  Mule supports polling receivers, that pull events from the transport, but
users can implement listener interfaces to have events pushed to the receiver.

-----------------------------------------------------------------
./src/main/resources/META-INF/services/org/mule/config/registry-bootstrap.properties

This file contains key value pairs of objects that will be stored in the Mule registry when this module is loaded.  These
objects are useful for loading module objects such as transformers or expression evaluators that you want to make
available inside the Mule context automatically.
These properties are defined in the form of: "objectName=fully qualified class name".

-----------------------------------------------------------------
./src/main/resources/META-INF/mule-qpd.xsd

The configuration schema file for this module. All configuration elements should be defined in this schema.

-----------------------------------------------------------------
./src/main/resources/META-INF/spring.schemas

Contains a mapping of the Namespace URI for this projects schema.

-----------------------------------------------------------------
./src/main/resources/META-INF/spring.handlers

Contains a mapping of the namespace handler to use for the schema in this project.

-----------------------------------------------------------------
./src/main/java/org/mule/transport/qpd/config/QpdNamespaceHandler.java

The implmentation of the namespace handler used to parse elements defined in mule-qpd.xsd.

TESTING
=======

This  project also contains test classes that can be run as part of a test suite.
-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdTestCase.java

This is an example functional test case.  The test will work as is, but you need to configure it to actually test your
code.  For more information about testing see: http://www.mulesource.org/display/MULE2USER/Functional+Testing.

-----------------------------------------------------------------
./src/test/resources/qpd-functional-test-config.xml

Defines the Mule configuration for the QpdTestCase.java.

-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdConnectorTestCase.java

The unit test case for testing the connecotr object for this transport.

-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdEndpointTestCase.java

The unit test case for testing the endpoint builder object for this transport.
-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdMessageAdapterTestCase.java

The test case for testing the custom message adapter for this transport.

-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdMessageReceiverTestCase.java

The unit test case for testing the message receiver object for this transport.

-----------------------------------------------------------------
./src/test/java/org/mule/transport/qpd/QpdNamespaceHandlerTestCase.java

A test case that is used to test each of the configuration elements inside your mule-qpd.xsd schema file.

-----------------------------------------------------------------
./src/test/resources/qpd-namespace-config.xml

The configuration file for the QpdNamespaceHandlerTestCase.java testcase.


ADDITIONAL RESOURCES
====================
Everything you need to know about getting started with Mule can be found here:
http://www.mulesource.org/display/MULE2INTRO/Home

There further useful information about extending Mule here:
http://mule.mulesource.org/display/MULE2USER/Introduction+to+Extending+Mule

We recommend you read the page on writing Mule transports if you have not done so already:
http://mule.mulesource.org/display/MULE2USER/Creating+Transports

There is also detailed information about creating Mule configuration schemas here:
http://mule.mulesource.org/display/MULE2USER/Creating+a+Custom+XML+Namespace

For information about working with Mule inside and IDE with maven can be found here:
http://www.mulesource.org/display/MULE2INTRO/Setting+Up+Eclipse

Remember if you get stuck you can try getting help on the Mule user list:
http://www.mulesource.org/display/MULE/Mailing+Lists

Also, MuleSource, the company behind Mule, offers 24x7 support options:
http://www.mulesource.com/services/subscriptions.php

Enjoy your Mule ride!

The Mule Team

--------------------------------------------------------------------
This project was auto-generated by the mule-transport-archetype.

artifactId=mule-transport-qpd
description=qpid
muleVersion=2.2.1
hasCustomSchema=y
hasReceiver=y
hasDispatcher=n
hasRequestor=n
hasCustomMessageAdapter=y
hasBootstrap=y
hasTransactions=n
hasCustomTransactions=n
inboundTransformer=n
outboundTransformer=n
ModuleType=Transport
forgeProject=n
transports=vm,stdio
modules=client

version=1.0-SNAPSHOT
groupId=org.mule.transports
basedir=C:\Users\User\Desktop
--------------------------------------------------------------------