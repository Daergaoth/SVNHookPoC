::docker compose down
docker rmi -f daergaothdev/svnhook-server:latest
docker rmi -f svnhook-server:latest
docker build -t svnhook-server .
::docker build --no-cache --progress=plain -t unity-server .
docker tag unity-server:latest daergaothdev/svnhook-server:latest
::docker-compose up -d