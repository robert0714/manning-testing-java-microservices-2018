This repository is for studying **["Testing Java Microservices - Using Arquillian, Hoverfly, AssertJ, JUnit, Selenium, and Mockito"](https://www.manning.com/books/testing-java-microservices)**.

# Other Reference

*  https://github.com/arquillian/arquillian-showcase
*  https://github.com/andreschaffer/microservices-testing-examples
*  https://github.com/UltimateSoftware/testing-microservices-introduction
*  https://github.com/hemanshuchauhan/microservices-test

# Services
1. Game  
    + Container: [Thorntail(WildFly Swarm)](https://thorntail.io/)
[reference](https://jaxenter.com/thorntail-version-2-1-0-final-148293.html )  
     Using Maven 3.6, which isn't supported in this ancient version of WildFly Swarm.
      ```bash
      [ERROR] Failed to execute goal org.wildfly.swarm:wildfly-swarm-plugin:2017.4.0:package (default) on project game: Execution default of goal org.wildfly.swarm:wildfly-swarm-plugin:2017.11.0:package failed: An API incompatibility was encountered while executing org.wildfly.swarm:wildfly-swarm-plugin:2017.11.0:package: java.lang.AbstractMethodError: null
      [ERROR] ----------------------------------------------------------------------------------------------------------
      realm =    plugin>org.wildfly.swarm:wildfly-swarm-plugin:2018.5.0
      strategy = org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy
      ```
      You can:
      + use Maven 3.5
      + or you can update to the latest version of Thorntail (yes, WildFly Swarm got renamed).
        To update automatically, you can run:
        ```
        mvn io.thorntail:thorntail-maven-plugin:2.7.0.Final:migrate-from-wildfly-swarm
        ```
    + Datastore: [H2 Database Engine](http://www.h2database.com/html/main.html)
    + Build tool: Maven
2. Comments
    + Container: [Apache TomEE](http://tomee.apache.org/)
    + Datastore: MongoDB
    + Build tool: Gradle
3. Video
    + Container: Spring Boot
    + Datastore: Redis
    + Build tool: Gradle
4. Aggregator
    + Container: Tomcat
    + Build tool: Gradle

