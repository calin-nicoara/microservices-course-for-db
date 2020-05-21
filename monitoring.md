# Logging with elk

## Install elk using docker
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.7.0

check Elastic search
```
curl -XGET http://localhost:9200
```

## Install kibana using docker
docker run --link YOUR_ELASTICSEARCH_CONTAINER_NAME_OR_ID:elasticsearch -p 5601:5601 docker.elastic.co/kibana/kibana:7.7.0

./logstash -f ../config/logstash-custom-config.conf
