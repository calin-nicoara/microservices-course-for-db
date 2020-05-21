## USe kubernetes locally

Install kubectl and minilube

https://kubernetes.io/docs/tasks/tools/install-kubectl/
https://kubernetes.io/docs/tasks/tools/install-minikube/

## Use local images in minikube
eval $(minikube docker-env)

Then run docker build and it will appear in minikube
