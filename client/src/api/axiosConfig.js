import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;

export default axios.create({
    //baseURL: ' https://cb3a-38-34-84-35.ngrok-free.app',
    //baseURL:'http://localhost:8080', 
    baseURL: baseURL,
    headers: {"ngrok-skip-browser-warning": "true"},
    withCredentials: true
});