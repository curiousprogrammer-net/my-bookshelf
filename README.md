# my-bookshelf

Simple web application for personal book management.

## Prerequisites

### DB setup

You need to create db user and database.
Run following commands from shell:
```
createuser --createdb bookworm

createdb -O bookworm my_bookshelf_dev
createdb -O bookworm my_bookshelf_test
```

### Web server config

If you want to avoid conflicts with other ring applications running on localhost,
consider chaning web server port in [config.edn](env/dev/resources/config.edn )

## Running

To start a web server for the application, run:

    lein run

Then go to http://localhost:3000 (or custom port). 
