Ext.define('Bid.controller.BidsPanelController', {
    extend: 'Ext.app.Controller',

    views: [
        'BidsAddWindowForm',
        'BidsPanel',
        'BidsGrid',
        'BidsSearch'
    ],

    stores: [
        'Bids'
    ],

    models: [
        'Bids'
    ],

    refs: [{
        selector: 'bidsGrid',
        ref: 'bidsGrid'
    }, {
        selector: 'bidsGrid button[action="add"]',
        ref: 'bidsGridAdd'
    }, {
        selector: 'bidsGrid button[action="edit"]',
        ref: 'bidsGridEdit'
    }, {
        selector: 'bidsGrid button[action="delete"]',
        ref: 'bidsGridDelete'
    }, {
        selector: 'bidsSearch button[action="search"]',
        ref: 'bidsSearch'
    }, {
        selector: 'bidsAddWindowForm',
        ref: 'bidsAddWindowForm'
    }, {
        selector: 'bidsPanel',
        ref: 'bidsPanel'
    }, {
        selector: 'bidsAddWindowForm textfield[name=number]',
        ref: 'bidsAddWindowFormNumber'
    }, {
        selector: 'bidsAddWindowForm combobox[name=from]',
        ref: 'bidsAddWindowFormFrom'
    }, {
        selector: 'bidsAddWindowForm combobox[name=to]',
        ref: 'bidsAddWindowFormTo'
    }, {
        selector: 'bidsAddWindowForm combobox[name=status]',
        ref: 'bidsAddWindowFormStatus'
    }, {
        selector: 'bidsAddWindowForm button[action=save]',
        ref: 'bidsAddWindowFormSave'
    }],

    init: function () {
        this.control({
        	'bidsGrid button[action=add]': {
                click: this.onAddBid
            },
            'bidsGrid button[action=edit]': {
                click: this.onEditBid
            },
            'bidsGrid button[action=delete]': {
                click: this.onDelBid
            },
            'bidsSearch textfield[name="search"]': {
                change: this.onChangeText
            },
            'bidsGrid': {
                cellclick: this.onLineGrid
            },
            'bidsAddWindowForm button[action=save]': {
                click: this.onSaveBid
            },
            'bidsAddWindowForm textfield[name=number]': {
                change: this.onValidation
            },
            'bidsAddWindowForm combobox[name=from]': {
                select: this.onValidation
            },
            'bidsAddWindowForm combobox[name=to]': {
                select: this.onValidation
            },
            'bidsAddWindowForm combobox[name=status]': {
                select: this.onValidation
            }
        });
    },

    onSaveBid: function (button) {
        var me = this;
        var bidsModel = Ext.create('Bid.model.Bids');
        var formValues = this.getBidsAddWindowForm().down('form').getValues();
        
        //TODO: Не работает добавление, не вставляет зависимые данные...
        var userFrom = userStore.findRecord('id', formValues.from);
        var userTo = userStore.findRecord('id', formValues.to);
        var status = statusStore.findRecord('id', formValues.status);
        
        bidsModel.set('number', formValues.number);
        bidsModel.set('from', userFrom);
        bidsModel.set('to', userTo);
        bidsModel.set('status', status);
        
        bidsModel.save({
            success: function (operation, response) {
            	var objAjax = operation.data;
                me.getBidsStore().add(objAjax);
                me.getBidsAddWindowForm().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Ошибка!',
                    msg: 'Не удалось сохранить заявку',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAddBid: function () {
        Ext.widget('bidsAddWindowForm', {
            title: 'Новая заявка'
        });
    },

    onEditBid: function (button) {
    	Ext.MessageBox.show({
                    title: 'Ошибка!',
                    msg: 'Данная функциональность не реализована',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
    },
    onDelBid: function () {
        var sm = this.getBidsGrid().getSelectionModel();
        var rs = sm.getSelection();
        this.getBidsGrid().store.remove(rs[0]);
        this.getBidsGrid().store.commitChanges();
        this.getBidsGridDelete().disable();
        this.getBidsGridEdit().disable();
    },

    onChangeText: function () {
    	//Ext.MessageBox.show(this.getBidsPanel().down('bidsSearch').getValues())
        this.getBidsStore().load({
            params: {
                search: this.getBidsPanel().down('bidsSearch').getValues()
            }
        });
    },

    onLineGrid: function () {
        this.getBidsGridEdit().enable();
        this.getBidsGridDelete().enable();
    },

    onValidation: function () {
        if (this.getBidsAddWindowFormNumber().validate() &&
            this.getBidsAddWindowFormFrom().validate() &&
            this.getBidsAddWindowFormTo().validate() &&
            this.getBidsAddWindowFormStatus().validate()) {
            this.getBidsAddWindowFormSave().enable();
        } else {
            this.getBidsAddWindowFormSave().disable();
        }
    }

});
