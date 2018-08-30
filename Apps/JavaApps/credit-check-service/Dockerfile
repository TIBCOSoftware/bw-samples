FROM maven:3.3.9-jdk-8
RUN mkdir --parents /usr/src/app
ADD . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package -Dhttps.protocols=TLSv1.2
EXPOSE 7080
CMD mvn exec:java -Dhttps.protocols=TLSv1.2