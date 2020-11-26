<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
  metadata-complete="true">


<servlet>
<servlet-name>startup</servlet-name>
<servlet-class>com.thinking.machines.school.servlets.startup.startup</servlet-class>
<load-on-startup>1</load-on-startup>
</servlet>

<servlet>
<servlet-name>AddStudent</servlet-name>
<servlet-class>com.thinking.machines.school.servlets.startup.AddStudent</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>AddStudent</servlet-name>
<url-pattern>/addStudent</url-pattern>
</servlet-mapping>

</web-app>