Ext.define('Bid.model.Status', {
    extend: 'Ext.data.Model',
    fields: ['id', 'name'],
    proxy: {
        type: 'rest',
        api: {
            read: 'status',
            root: 'data',
            successProperty: 'success'
        },
        reader: {
            type: 'json'
        }

    }
});
