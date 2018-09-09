import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {RESOURCES} from '../constants/resources';
import {VentaVo} from '../model/venta-vo';
import {VentaDetalleVo} from '../model/venta-detalle-vo';
import {UtilityService} from '../services/utility.service';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class VentaService {

    constructor(private _http: HttpClient,
        private _utilityService: UtilityService) {}

    addVenta(ventaVo: VentaVo): Observable<any> {
        return this._http.post(RESOURCES.add_venta
            , ventaVo, httpOptions)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("addVenta"))
            );
    }

    addVentaDetalle(ventaDetalleVoList: VentaDetalleVo[]): Observable<any> {
        return this._http.post(RESOURCES.add_venta_detalle
            , ventaDetalleVoList, httpOptions)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("addVentaDetalle"))
            );
    }
}
