docker compose down
docker rmi -f daergaothdev/unity-server:latest
docker rmi -f unity-server:latest
docker build -t unity-server .
::docker build --no-cache --progress=plain -t unity-server .
docker tag unity-server:latest daergaothdev/unity-server:latest
docker-compose up -d