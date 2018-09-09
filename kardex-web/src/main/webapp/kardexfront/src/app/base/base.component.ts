import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {Message} from 'primeng/components/common/api';
import {GenericService} from "../services/generic.service";
import {UtilityService} from '../services/utility.service';
import {MESSAGES} from '../constants/messages';

@Component({
    selector: 'app-base',
    templateUrl: './base.component.html',
    styleUrls: ['./base.component.css'],
    providers: [GenericService, UtilityService],
    encapsulation: ViewEncapsulation.None
})
export class BaseComponent implements OnInit, OnDestroy {
    messageVo: any;
    productos: any[];
    orders: any[];
    msgs: Message[] = [];
    selLocale: string = "es";
    resourceBundle: any = new Object();

    constructor(
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        this.loadMessagesApp();
    }

    ngOnInit() {
    }

    ngOnDestroy() {
    }

    onchangeLocale(selLocale: string) {
        this.selLocale = selLocale;
        sessionStorage.removeItem(MESSAGES.session_param_locale);
        sessionStorage.setItem(MESSAGES.session_param_locale, JSON.stringify(selLocale));
        this.loadMessagesApp();
    }

    loadMessagesApp() {
        if (JSON.parse(sessionStorage.getItem(MESSAGES.session_param_locale)) != null) {
            this.selLocale = JSON.parse(sessionStorage.getItem(MESSAGES.session_param_locale));
        }

        console.log("loadMessagesApp:" + this.selLocale);
        this.msgs = [];
        this._genericService.loadMessagesApp(this.selLocale).
            subscribe(resourceBundle => {
                this.resourceBundle = resourceBundle;
            });
    }

    serviceListProducto(filter: boolean) {
        this._genericService.getListProducto(filter)
            .subscribe(
            result => {
                console.log("serviceListProducto Response estado:" + result.messageVo.exit + ",message:" + result.messageVo.message);
                this.productos = this.getReponseExit(result, this.productos);
            },
            error => {
                this.setResponseError(error);
            }
            );
    }
    
    serviceListOrder() {
        this._genericService.getListOrder()
            .subscribe(
            result => {
                console.log("serviceListOrder Response estado:" + result.messageVo.exit + ",message:" + result.messageVo.message);
                this.orders = this.getReponseExit(result, this.orders);
            },
            error => {
                this.setResponseError(error);
            }
            );
    }

    removeAllSession() {
        this._genericService.removeAllSession().subscribe(
            result => {
                console.log("removeAllSession Response estado:" + result.messageVo.exit + ",message:" + result.messageVo.message);
            },
            error => {
                this.setResponseError(error);
            }
        );
    }

    getReponseExit(result: any, list: any[]): any[] {
        this.messageVo = result.messageVo;

        if (this.messageVo.exit) {
            list = result.objectsVo;
        } else {
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_list_invalida});
        }

        return list;
    }

    setResponseError(error: any) {
        let errorMessage = <any> error;
        if (errorMessage !== null) {
            console.log("errorMessage:" + errorMessage);
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_list_invalida});
        }
    }

    byOption(item1: any, item2: any) {
        return item1 == item2;
    }

    onClear() {
        this.msgs = [];
    }

}
