var userStore = Ext.create('Bid.store.User');
var statusStore = Ext.create('Bid.store.Status');

var fromComboBox = Ext.create('Ext.form.field.ComboBox', {
    fieldLabel: 'От кого',
    name: 'from',
    width: 400,
    editable: false,
    labelWidth: 130,
    store: userStore,
    hiddenName: 'id',
    valueField: 'id',
    displayField: 'email',
    typeAhead: true,
    queryMode: 'local',
    emptyText: 'Отправитель',
    allowBlank: false,
    blankText: 'Это поле должно быть заполнено',
    listConfig: {
        getInnerTpl: function () {
            return '<div data-qtip="{email} ({lastName} {firstName})">{email}</div>';
        }
    }
});


var toComboBox = Ext.create('Ext.form.field.ComboBox', {
    fieldLabel: 'Кому',
    name: 'to',
    width: 400,
    editable: false,
    labelWidth: 130,
    store: userStore,
    valueField: 'id',
    hiddenName: 'id',
    displayField: 'email',
    typeAhead: true,
    queryMode: 'local',
    emptyText: 'Получатель',
    allowBlank: false,
    blankText: 'Это поле должно быть заполнено',
    listConfig: {
        getInnerTpl: function () {
            return '<div data-qtip="{email} ({lastName} {firstName})">{email}</div>';
        }
    }
});

var statusComboBox = Ext.create('Ext.form.field.ComboBox', {
    fieldLabel: 'Статус',
    name: 'status',
    width: 400,
    editable: false,
    labelWidth: 130,
    store: statusStore,
    valueField: 'id',
    hiddenName: 'id',
    displayField: 'name',
    typeAhead: true,
    queryMode: 'local',
    emptyText: 'Статус',
    allowBlank: false,
    blankText: 'Это поле должно быть заполнено'
});

Ext.define('Bid.view.BidsAddWindowForm', {
    extend: 'Ext.window.Window',
    alias: 'widget.bidsAddWindowForm',
    autoShow: true,
    layout: 'fit',
    modal: true,
    items: [{
        bodyPadding: 10,
        xtype: 'form',
        items: [{
                xtype: 'textfield',
                width: 400,
                labelWidth: 130,
                name: 'number',
                fieldLabel: 'Номер',
                regex: /^[0-9]*$/,
                regexText: 'Номер должен состоять только из чисел',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            },
            fromComboBox,
            toComboBox,
            statusComboBox
        ]
    }],
    buttons: [{
        text: 'Сохранить',
        action: 'save',
        disabled: true
    }, {
        text: 'Отменить',
        handler: function () {
            this.up('window').close();
        }

    }]
});
