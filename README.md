# airbnb-light
## Démarrage de la base de données
```
cd database
docker stack deploy -c docker-compose.yml mysql
```
ou (si docker-compose est installé)
```
cd database
docker-compose up
```
