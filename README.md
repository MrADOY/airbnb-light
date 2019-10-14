# airbnb-light
## Démarrage de la base de données
```
docker stack deploy -c stack.yml mysql
```
ou (si docker-compose est installé)
```
docker-compose -f stack.yml up
```
