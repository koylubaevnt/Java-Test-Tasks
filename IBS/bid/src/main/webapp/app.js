Ext.application({

    appFolder: 'app',

    name: 'Bid',

    controllers: [
        'BidsPanelController'
    ],

    launch: function () {
            Ext.create('Ext.container.Viewport', {
                layout: 'fit',
                items: {
                    xtype: 'bidsPanel'
                }
            });
        }

});
