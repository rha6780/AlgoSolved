import axios from 'axios';


// TODO: stage 별로 url 등 변경할 수 있도록
// http://developerdiscovery.com
export const ApiClient = axios.create({
//    baseURL: "https://developerdiscovery.com",
    baseURL: "http://localhost:8080",
    headers: {
        'content-type': 'application/json',
    },
});