const axios = require('axios');

const serverURL = process.env.VUE_APP_BASE_URL;
const instance = axios.create({
    baseURL: serverURL,
    timeout: 30000
});

module.exports = instance;
