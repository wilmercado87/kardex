import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {MESSAGES} from "../constants/messages";
import {UtilityService} from "../services/utility.service";
import {VentaService} from "../services/venta.service";
import {VentaVo} from '../model/venta-vo';
import {VentaDetalleVo} from '../model/venta-detalle-vo';
import {ProductoVo} from '../model/producto-vo';
import {GenericService} from "../services/generic.service";
import {BaseComponent} from "../base/base.component";

@Component({
    selector: 'app-venta',
    templateUrl: './venta.component.html',
    styleUrls: ['./venta.component.css'],
    providers: [UtilityService, GenericService, VentaService],
    encapsulation: ViewEncapsulation.None
})
export class VentaComponent extends BaseComponent implements OnInit, OnDestroy {
    private form: FormGroup;
    private productoVo: ProductoVo;
    private ventaVo: VentaVo;
    private ventaDetalleList: VentaDetalleVo[];
    private ventaDetalleVo: VentaDetalleVo;
    private disabledAdd: boolean = false;
    private disabledSave: boolean = true;

    constructor(
        private _ventaService: VentaService,
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        super(_genericService, _utilityService);
    }

    ngOnInit() {
        this.init();
    }

    init() {
        this.ventaDetalleList = [];
        this.ventaVo = new VentaVo(null, "", "", null, 0, null);
        this.serviceListProducto(true);
    }

    removeVentaDetalle(ventaDetalleVo: VentaDetalleVo) {
        this.msgs = [];
        this.disabledAdd = false;
        this.disabledSave = false;
        this.ventaDetalleVo = ventaDetalleVo;
        let index = this.ventaDetalleList.indexOf(this.ventaDetalleVo);
        this.ventaDetalleList = this.ventaDetalleList.filter((val, i) => i != index);
        if (this.ventaDetalleList.length == 0) {
            this.disabledSave = true;
        }
        this.ventaDetalleVo = null;

        this.getCantidadByProducto();
    }

    putVentaDetalle() {
        this.msgs = [];
        this.disabledSave = true;
        this.disabledAdd = true;
        this.getCantidadByProducto();
        let ventaDetalleList = [...this.ventaDetalleList];
        this.ngOnDestroy();
        ventaDetalleList.push(this.ventaDetalleVo);
        this.ventaDetalleList = ventaDetalleList;

    }

    onchangeProducto(ventaDetalleVo: VentaDetalleVo) {
        this.msgs = [];
        let nombreProducto: string = ventaDetalleVo.productoVo.nombre;
        if (nombreProducto.length == 0) {
            this.disabledAdd = true;
            this.disabledSave = true;
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_name_product_required});
            return;
        }

        this.productoVo = this._utilityService.getProductoVoByNombre(nombreProducto, this.productos);
        let index = this.ventaDetalleList.indexOf(ventaDetalleVo);
        this.ventaDetalleList[index].productoVo = this.productoVo;
    }

    validateCantidad(ventaDetalleVo: VentaDetalleVo) {
        this.msgs = [];
        let cantidad: number = ventaDetalleVo.cantidad;
        let nombreProducto: string = ventaDetalleVo.productoVo.nombre;
        if (cantidad == null) {
            this.disabledAdd = true;
            this.disabledSave = true;
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_quantity_required});
            return;
        }

        if (!Number.isInteger(+cantidad) || cantidad <= 0) {
            this.disabledAdd = true;
            this.disabledSave = true;
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_quantity_required});
            return;
        }

        this.productoVo = this._utilityService.getProductoVoByNombre(nombreProducto, this.productos);
        let cantidadTotal: number = this.getCantidadByProducto();
        if (cantidadTotal > this.productoVo.stock) {
            this.disabledAdd = true;
            this.disabledSave = true;
            this.removeVentaDetalle(ventaDetalleVo);
            this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_stock_exceeds});
            return;
        }

        this.disabledAdd = false;
        this.disabledSave = false;

    }

    getCantidadByProducto(): number {
        let cantidad: number = 0;
        let valorTotal: number = 0;
        for (let item of this.ventaDetalleList) {
            valorTotal = valorTotal + (Number.parseInt(item.cantidad.toString()) * Number.parseInt(item.productoVo.valorVentaUnidad.toString()));
            if (this.productoVo.nombre == item.productoVo.nombre) {
                cantidad = cantidad + Number.parseInt(item.cantidad.toString());
            }
        }

        this.ventaVo.valorTotal = valorTotal;
        return cantidad;
    }

    onSaveVenta(form: FormGroup) {
        this.form = form;
        this.msgs = [];
        this.ventaVo.pkVenta = null;
        this.ventaVo.usuarioVo = JSON.parse(sessionStorage.getItem(MESSAGES.session_param_usuario_login));
        this.ventaVo.fecha = new Date();
        this.serviceSaveVenta();
    }

    serviceVentaDetalle() {
        console.log("ventaDetalle:" + JSON.stringify(this.ventaDetalleList));
        this._ventaService.addVentaDetalle(this.ventaDetalleList).
            subscribe(
            result => {
                console.log("serviceVentaDetalle message:" + result.messageVo.message);
                this.init();
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

    serviceSaveVenta() {
        this._ventaService.addVenta(this.ventaVo).
            subscribe(
            result => {
                console.log("serviceSaveVenta message:" + result.messageVo.message);
                if (result.messageVo.exit) {
                    this.ventaVo = result.objectVo;
                    console.log("ventaVo:" + JSON.stringify(this.ventaVo));
                    for (let item of this.ventaDetalleList) {
                        item.ventaVo = this.ventaVo;
                    }
                    this.serviceVentaDetalle();
                    this.disabledSave = true;
                    this.form.reset();
                    this.msgs.push({severity: 'info', summary: "", detail: this.resourceBundle.info_add_venta});
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
        this.productoVo = new ProductoVo(null, "", null, null);
        this.ventaDetalleVo = new VentaDetalleVo(null, null, this.productoVo, this.ventaVo);
    }

}
