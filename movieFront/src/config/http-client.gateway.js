const AxiosClient = require('./axios');

module.exports = {
    doGet(endPoint) {
        return AxiosClient.get(endPoint);
    },
    doPost(endPoint, object, config) {
        return AxiosClient.post(endPoint, object, config);
    },
    doPut(endPoint, id, config) {
        return AxiosClient.put(`${endPoint}/${id}`, null, config);
    }
};
