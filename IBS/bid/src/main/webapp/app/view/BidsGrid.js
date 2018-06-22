Ext.define('Bid.view.BidsGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.bidsGrid',
    width: 400,
    height: 300,
    frame: true,
    store: 'Bids',
    columns: [{
            text: 'ID',
            flex: 1,
            sortable: false,
            dataIndex: 'id'
        }, {
            text: 'Номер',
            flex: 2,
            sortable: false,
            dataIndex: 'number'
        }, {
            text: 'От кого',
            flex: 2,
            sortable: false,
            dataIndex: 'from'
        }, {
            text: 'Кому',
            flex: 2,
            sortable: false,
            dataIndex: 'to'

        }, {
            text: 'Статус',
            flex: 2,
            sortable: false,
            dataIndex: 'status'
        }

    ],
    dockedItems: [{
        xtype: 'toolbar',
        items: [{
            text: 'Добавить',
            action: 'add',
            iconCls: 'icon-add'
        }, {
            text: 'Редактировать',
            action: 'edit',
            iconCls: 'icon-edit',
            disabled: true
        }, {
            text: 'Удалить',
            action: 'delete',
            iconCls: 'icon-delete',
            disabled: true
        }]
    }]
});
