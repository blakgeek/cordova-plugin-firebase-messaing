var exec = require('cordova/exec');

function FirebaseMessaging() {

    var token = null;
    
    exec(dispatchEvent, null, 'FirebaseMessagingPlugin', 'initialize', []);

    this.getToken = function() {
        return token;
    };
    
    this.subscribe = function(topic) {
        exec(dispatchEvent, null, 'FirebaseMessagingPlugin', 'subscribe', [topic]);
    };
    
    this.unsubscribe = function(topic) {
        exec(dispatchEvent, null, 'FirebaseMessagingPlugin', 'unsubscribe', [topic]);
    };

    function dispatchEvent(event) {

        if(event.type === 'tokenrefresh') {
            token = event.data;
        }
        window.dispatchEvent(new CustomEvent(event.type, {detail: event.data}));
    }
}

if (typeof module !== undefined && module.exports) {

    module.exports = FirebaseMessaging;
}