Ext.define('Bid.view.BidsPanel', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.bidsPanel',
    layout: 'border',
    items: [{
        xtype: 'bidsGrid',
        region: 'center'
    }, {
        xtype: 'panel',
        html: '<div style="font: normal 18px cursive"><center><font size = "10">Заявки</font></center></div>',
        region: 'north',
        height: 80
    }, {
        xtype: 'bidsSearch',
        title: 'Поиск заявок',
        region: 'west',
        width: 300,
        collapsible: true,
        collapsed: true
    }],
    renderTo: Ext.getBody()
});
