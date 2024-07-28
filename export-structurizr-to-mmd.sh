# cli documentation: https://docs.structurizr.com/cli/export
docker pull structurizr/cli:latest
docker run -it --rm -v ./architecture:/usr/local/structurizr structurizr/cli export -workspace workspace.json -format mermaid