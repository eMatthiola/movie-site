# Use Node.js to build the frontend application
FROM node:18 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY package*.json ./

RUN npm install

# Copy the entire project and build it
COPY . .
RUN npm run build

# Use Nginx as the web server
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html

# Expose the default Nginx port
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]
