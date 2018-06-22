Ext.define('Bid.view.BidsSearch', {
    extend: 'Ext.form.Panel',
    alias: 'widget.bidsSearch',
    bodyPadding: 10,
    items: [{
        xtype: 'textfield',
        name: 'search',
        fieldLabel: 'Номер заявки',
        maxLength: 200
    }]
});
