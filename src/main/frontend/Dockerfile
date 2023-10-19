FROM node:14


WORKDIR /usr/src/frontend

COPY package* .

RUN npm install

COPY . .

EXPOSE "3000"

CMD ["npm", "start"]