import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {UtilityService} from "../services/utility.service";
import {PedidoService} from "../services/pedido.service";
import {PedidoVo} from '../model/pedido-vo';
import {ProductoVo} from '../model/producto-vo';
import {GenericService} from "../services/generic.service";
import {BaseComponent} from "../base/base.component";

@Component({
    selector: 'app-pedido',
    templateUrl: './pedido.component.html',
    styleUrls: ['./pedido.component.css'],
    providers: [UtilityService, GenericService, PedidoService],
    encapsulation: ViewEncapsulation.None
})
export class PedidoComponent extends BaseComponent implements OnInit, OnDestroy {
    private form: FormGroup;
    private pedidoVo: PedidoVo;
    private productoVo: ProductoVo;
    private selProducto: number;
    private loading: boolean;

    constructor(
        private _pedidoService: PedidoService,
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        super(_genericService, _utilityService);
    }

    ngOnInit() {
        this.msgs = [];
        this.pedidoVo = new PedidoVo(null, null, null, null);
        this.serviceListProducto(false);
        this.onLoadListOrder();
    }
    
    onLoadListOrder() {
        this.loading = true;
        setTimeout(() => {
            this.serviceListOrder();
            this.loading = false;
        }, 1000);
    }

    onchangeProducto(selProducto: number) {
        this.selProducto = selProducto;
        this.productoVo = this._utilityService.getProductoVo(this.selProducto, this.productos);
        this.pedidoVo.productoVo = this.productoVo;
    }

    onSaveOrder(form: FormGroup) {
        this.form = form;
        this.msgs = [];
        this.pedidoVo.pkPedido = null;
        this.pedidoVo.fecha = new Date();
        this.serviceSaveOrder();
    }

    serviceSaveOrder() {
        this._pedidoService.addOrder(this.pedidoVo).
            subscribe(
            result => {
                console.log("serviceSaveOrder message:" + result.messageVo.message);
                if (result.messageVo.exit) {
                    this.pedidoVo = result.objectVo;
                    this.form.reset();
                    this.msgs.push({severity: 'info', summary: "", detail: this.resourceBundle.info_add_order});
                    this.serviceListOrder();
                }
            },
            error => {
                let errorMessage = <any> error;
                if (errorMessage !== null) {
                    console.log("errorMessage:" + errorMessage);
                    this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_generic});
                }
            }
            );
    }

    ngOnDestroy() {
        this.pedidoVo = new PedidoVo(null, null, null, null);
    }

}
