import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {RESOURCES} from '../constants/resources';
import {ProductoVo} from '../model/producto-vo';
import {UtilityService} from '../services/utility.service';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ProductService {

    constructor(private _http: HttpClient,
        private _utilityService: UtilityService) {}

    addProducto(productoVo: ProductoVo): Observable<any> {
        return this._http.post(RESOURCES.add_product
            , productoVo, httpOptions)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("addProducto"))
            );
    }

    getProductoByNombre(nameProducto: string): Observable<any> {
        return this._http.get(RESOURCES.get_product_by_name + "?nameProducto=" + nameProducto)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("getProductoByNombre"))
            );
    }
}
