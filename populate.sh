docker exec -d lbd_mongo /seeds/mongo.sh
docker exec -u postgres lbd_postgres psql -f /seeds/populate_postgres.sql

