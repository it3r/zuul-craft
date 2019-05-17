```
gradlew build
cd docker
docker-compose up --build --scale service=2
```
```
http://localhost:5001/ - eureka
http://localhost:5000/service/123 - балансирует между экземплярами
```