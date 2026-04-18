FROM registry.access.redhat.com/ubi9/openjdk-21:latest

USER root

RUN microdnf install -y git

RUN install -d /home/default/smart-aeronautics
COPY . /home/default/smart-aeronautics

RUN git clone https://github.com/computate-org/computate-base.git /home/default/computate-base
RUN git clone https://github.com/computate-org/computate-search.git /home/default/computate-search
RUN git clone https://github.com/computate-org/computate-vertx.git /home/default/computate-vertx
RUN git clone https://github.com/computate-org/smart-aeronautics-static.git /home/default/smart-aeronautics-static

WORKDIR /home/default/computate-base
RUN mvn clean install -DskipTests
WORKDIR /home/default/computate-search
RUN mvn clean install -DskipTests
WORKDIR /home/default/computate-vertx
RUN mvn clean install -DskipTests
WORKDIR $HOME/smart-aeronautics
RUN mvn clean install -DskipTests

WORKDIR /home/default/smart-aeronautics
RUN mvn clean install -DskipTests
RUN mvn dependency:build-classpath -Dmdep.outputFile=/home/default/smart-aeronautics/cp.txt -q
CMD java -cp "$(cat /home/default/smart-aeronautics/cp.txt):/home/default/smart-aeronautics/target/classes" org.computate.smartaeronautics.verticle.MainVerticle
