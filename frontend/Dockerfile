# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8081
CMD ["npm", "run", "serve", "--fix", "--headless", "--", "--port", "8081", "--host", "0.0.0.0"]