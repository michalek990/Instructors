#!/bin/bash

PGHOST="localhost"
PGPORT="5432"
PGDATABASE="instructorsDb"
PGUSER="postgres"
PGPASSWORD="postgres"

REDIS_HOST="localhost"
REDIS_PORT="6379"

SQL="SELECT id, name, price FROM products;"

export PGPASSWORD=$PGPASSWORD
psql -h $PGHOST -p $PGPORT -d $PGDATABASE -U $PGUSER -t -A -F"," -c "$SQL" | while IFS=, read -r id name price
do
  redis-cli -h $REDIS_HOST -p $REDIS_PORT HMSET products:$id name "$name" price "$price"
  redis-cli -h $REDIS_HOST -p $REDIS_PORT SADD products $id

done
echo "Udalo sie"
