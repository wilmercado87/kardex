import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {RESOURCES} from '../constants/resources';
import {PedidoVo} from '../model/pedido-vo';
import {UtilityService} from '../services/utility.service';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class PedidoService {

    constructor(private _http: HttpClient,
        private _utilityService: UtilityService) {}

    addOrder(pedidoVo: PedidoVo): Observable<any> {
        return this._http.post(RESOURCES.add_order
            , pedidoVo, httpOptions)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("addOrder"))
            );
    }
}
