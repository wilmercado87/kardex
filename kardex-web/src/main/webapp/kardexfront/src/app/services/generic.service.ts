import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {RESOURCES} from '../constants/resources';
import {UtilityService} from '../services/utility.service';
import {MESSAGES} from '../constants/messages';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable()
export class GenericService {

    constructor(
        private _http: HttpClient,
        private _utilityService: UtilityService) {
    }

    /**
     * Inovoca el servicio rest  
     * retorna un Json con la informacion del getListProducto
     */
    getListProducto(filter: boolean): Observable<any> {
        return this._http.get(RESOURCES.find_all_list + "?parameter=" + MESSAGES.list_producto + "&filter=" + filter)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("getListProducto"))
            );
    }
    
    /**
     * Inovoca el servicio rest  
     * retorna un Json con la informacion del getListOrder
     */
    getListOrder(): Observable<any> {
        return this._http.get(RESOURCES.find_all_list + "?parameter=" + MESSAGES.list_order)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("getListOrder"))
            );
    }

    /**
     * Inovoca el servicio rest  
     * retorna un Json con la informacion Generica
     * Remueve todos los objetos de la sesion
     */
    removeAllSession(): Observable<any> {
        return this._http.get(RESOURCES.remove_all_session)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("removeAllSession"))
            );
    }

    /**
    * Inovoca el servicio rest 
    * retorna un Json resourceBundle
    */
    loadMessagesApp(locale: string): Observable<any> {
        return this._http.get(RESOURCES.load_messages + locale + RESOURCES.ext_json)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("loadMessagesApp"))
            );
    }

}
