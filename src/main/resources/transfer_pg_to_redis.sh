#!/bin/bash

# Parametry połączenia PostgreSQL
PGHOST="localhost"
PGPORT="5434"
PGDATABASE="test"
PGUSER="postgres"
PGPASSWORD="postgres"

# Parametry połączenia Redis
REDIS_HOST="localhost"
REDIS_PORT="6379"

# Zapytanie SQL do pobrania danych produktów
SQL="SELECT id, name, price FROM products;"

# Eksport danych z PostgreSQL i przetwarzanie każdego wiersza
export PGPASSWORD=$PGPASSWORD
psql -h $PGHOST -p $PGPORT -d $PGDATABASE -U $PGUSER -t -A -F"," -c "$SQL" | while IFS=, read -r id name price
do
  # Wstawianie danych do Redis za pomocą redis-cli
  redis-cli -h $REDIS_HOST -p $REDIS_PORT HMSET product:$id name "$name" price "$price"
done

echo "Udalo sie"
