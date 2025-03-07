import axios from 'axios';

export default axios.create({
    baseURL: 'https://c09a-38-34-84-35.ngrok-free.app'
,
    // baseURL:'http://localhost:8080',  
    headers: {"ngrok-skip-browser-warning": "true"}
});