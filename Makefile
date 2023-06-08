SHELL = /bin/bash

.DEFAULT_GOAL := help

.PHONY: help
help: ## show this help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

docker-start: ## create and start postgres, redis and localstack docker instances
	docker compose -f local/docker-compose.yaml up -d --remove-orphans

docker-stop: ## stop docker instances
	docker compose -f local/docker-compose.yaml stop -t 0

docker-rm: docker-stop  ## remove docker instances
	docker compose -f local/docker-compose.yaml rm -fv
	docker network prune