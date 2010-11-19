<%--
  Created by IntelliJ IDEA.
  User: sarbogast
  Date: 19/11/10
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" contentType="text/xml;charset=UTF-8" %>
<objects>
    <object id="amfChannel" class="mx.messaging.channels.AMFChannel" scope="singleton">
        <constructor-arg value="my-amf"></constructor-arg>
        <constructor-arg value="${ConfigurationHolder.config.grails.serverURL}/messagebroker/amf"></constructor-arg>
        <property name="id" value="amfChannel"></property>
        <property name="pollingEnabled" value="false"></property>
    </object>

    <object id="channelSet" class="mx.messaging.ChannelSet" scope="singleton">
        <method-invocation name="addChannel">
            <arg>
                <ref>amfChannel</ref>
            </arg>
        </method-invocation>
    </object>
</objects>