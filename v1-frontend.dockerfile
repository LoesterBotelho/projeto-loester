FROM node:20 AS builder
WORKDIR /app
COPY ./v1-frontend/package.json ./
RUN npm install
COPY ./v1-frontend .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]


# FROM node:20-slim
# WORKDIR /app
# RUN apt-get update && apt-get install -y \
#   build-essential \
#   && rm -rf /var/lib/apt/lists/*
# COPY --from=builder .
# RUN npm run build
# EXPOSE 3000
# CMD ["npm", "start"]