FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/my-bookshelf.jar /my-bookshelf/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/my-bookshelf/app.jar"]
