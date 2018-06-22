Ext.define('Bid.store.Bids', {
    extend: 'Ext.data.Store',
    model: 'Bid.model.Bids',
    autoLoad: true,
    autoSync: true,
    proxy: {
        type: 'rest',
        api: {
            create: 'application',
            read: 'application',
            destroy: 'application'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
});
