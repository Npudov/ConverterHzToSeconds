![Build Status](https://github.com/Npudov/ConverterHzToSeconds/actions/workflows/gradleTests.yml/badge.svg?branch=main) (main)
![Build Status](https://github.com/Npudov/ConverterHzToSeconds/actions/workflows/gradleTests.yml/badge.svg?branch=develop) (develop)

# ConverterHzToSeconds
An application that converts from `Hz` to `seconds`. Input values frequency in Hz. Output values time (period) in seconds.

## Single input data

```
GET localhost:8080/HzToTime?frequency=10.2
```

Reverse converting
```
GET localhost:8080/TimeToHz?time=1020.28
```

## Array input data
```
GET localhost:8080/HzToTimeArray with body ["100.58", "25.24"]
```

```
GET localhost:8080/TimeToHzArray with body ["100.58", "25.24"]
```

## Sorting values
```
GET localhost:8080/HzToTimeArray?direction=ASC
```

# Run Docker

Clone repository
```
$ git clone https://github.com/Npudov/ConverterHzToSeconds.git
```
Change directory to app folder
```
$ cd ConverterHzToSeconds
```
Build docker image
```
$ docker build -t ConverterHzToSeconds
```
Run docker image
```
$ docker run -p 8080:8080 ConverterHzToSeconds
```