# simple-service

Собрать образ
```gradle
./gradlew buildService
```

Запустить контейнер
```gradle
./gradlew startService
```

Остановить контейнер
```gradle
./gradlew stopService
```

### Тестирование

Получение 256 дня в заданном году
```
curl http://localhost\?year\=1999
{"errorCode":200,"dateMessage":"13/09/1999"}%

curl http://localhost\?year\=2000
{"errorCode":200,"dateMessage":"12/09/2000"}%
```

Сколько дней осталось до следующего дня программиста
```
curl http://localhost\?currentDate\=12092020
{"errorCode":200,"dateMessage":0}%

curl http://localhost\?currentDate\=12092019
{"errorCode":200,"dateMessage":1}%

curl http://localhost\?currentDate\=13092019
{"errorCode":200,"dateMessage":0}%

curl http://localhost\?currentDate\=14092019
{"errorCode":200,"dateMessage":365}%
```
