Ext.define('Bid.model.Bids', {
    extend: 'Ext.data.Model',
    fields: ['id', 'number'], 
    	/*{name:'from', mapping:'from.email'},
    	{name:'to', mapping:'to.email'},
    	{name:'status', mapping:'status.name'}
    	],
    associations: [
    { type: 'belongsTo', model:'Bid.model.User', name:'from'},
    { type: 'belongsTo', model:'Bid.model.User', name:'to'},
    { type: 'belongsTo', model:'Bid.model.Status', name:'status'}
    ],*/
    hasOne: [{
            model: 'Bid.model.User',
            name: 'from',
            proxy: {
		        type: 'rest',
		        api: {
		            read: 'user',
		        	root: 'from',
		        	successProperty: 'success'
		        },
		        reader: {
		            type: 'json'
		        }
		    }
        }, {
            model: 'Bid.model.User',
            name: 'to'
        }, {
            model: 'Bid.model.Status',
            name: 'status'
        }],
    proxy: {
        pageParam: 'search',
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
