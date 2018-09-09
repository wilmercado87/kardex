import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {UtilityService} from "../services/utility.service";
import {ProductService} from "../services/product.service";
import {ProductoVo} from '../model/producto-vo';
import {GenericService} from "../services/generic.service";
import {BaseComponent} from "../base/base.component";

@Component({
    selector: 'app-producto',
    templateUrl: './producto.component.html',
    styleUrls: ['./producto.component.css'],
    providers: [UtilityService, GenericService, ProductService],
    encapsulation: ViewEncapsulation.None
})
export class ProductoComponent extends BaseComponent implements OnInit, OnDestroy {
    private form: FormGroup;
    private productoVo: ProductoVo;
    private loading: boolean;
    private showNewProduct: boolean;
    private existProducto: boolean;

    constructor(
        private _productService: ProductService,
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        super(_genericService, _utilityService);
    }

    ngOnInit() {
        this.init();
    }

    init() {
        this.productoVo = new ProductoVo(null, "", null, null);
        this.showNewProduct = false;
        this.onLoadListProducto();
    }

    onLoadListProducto() {
        this.loading = true;
        setTimeout(() => {
            this.serviceListProducto(false);
            this.loading = false;
        }, 1000);
    }

    onNewProduct(form: FormGroup) {
        this.form = form;
        this.showNewProduct = true;
        this.form.reset();
    }

    onSaveProduct(form: FormGroup) {
        this.msgs = [];
        this.form = form;
        this.serviceExistsProductoByNombre();
    }

    serviceExistsProductoByNombre() {
        this._productService.getProductoByNombre(this.productoVo.nombre).
            subscribe(
            result => {
                console.log("serviceSaveProducto message:" + result.messageVo.message);
                if (result.objectVo != null) {
                    this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_add_producto});
                }else{
                    this.serviceSaveProducto();
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

    serviceSaveProducto() {
        this.productoVo.pkProducto = null;
        this._productService.addProducto(this.productoVo).
            subscribe(
            result => {
                console.log("serviceSaveProducto message:" + result.messageVo.message);
                if (result.messageVo.exit) {
                    this.productoVo = result.objectVo;
                    this.form.reset();
                    this.msgs.push({severity: 'info', summary: "", detail: this.resourceBundle.info_add_producto});
                    this.onLoadListProducto();
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
    }

}
