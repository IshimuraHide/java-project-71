.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean  install build

install:
	./gradlew clean install

# запуск исполняемого файла полученного в результате сборки
run-dist:
	./build/install/app/bin/app file1.json file2.json

run-dist-ymll:
	./build/install/app/bin/app file1.yml file2.yml

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport
	./gradlew JacocoCoverageVerification


lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

help:
	./build/install/app/bin/app -h


checkstyle:
	gradle checkstyleMain


build-run: build run

.PHONY: build