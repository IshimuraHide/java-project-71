.DEFAULT_GOAL := build-run

report:
	make -C app report

build-run: build run

.PHONY: build