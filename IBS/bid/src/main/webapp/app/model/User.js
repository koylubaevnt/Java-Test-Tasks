Ext.define('Bid.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'lastName', 'firstName', 'email'],
    proxy: {
        type: 'rest',
        api: {
            read: 'user',
        root: 'data',
        successProperty: 'success'
        },
        reader: {
            type: 'json'
        }
    }
});
