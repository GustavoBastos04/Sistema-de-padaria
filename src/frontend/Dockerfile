FROM node:18-alpine as builder

WORKDIR /app

# Copia o package.json e package-lock.json para o contêiner
COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# Imagem super leve do NGINX
FROM nginx:stable-alpine

COPY --from=builder /app/dist /usr/share/nginx/html

# Porta padrão do NGINX
EXPOSE 80

# Comando para iniciar o NGINX e manter o contêiner rodando
CMD ["nginx", "-g", "daemon off;"]