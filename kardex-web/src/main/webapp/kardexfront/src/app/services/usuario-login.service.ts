import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {RESOURCES} from '../constants/resources';
import {UtilityService} from '../services/utility.service';

@Injectable()
export class UsuarioLoginService {

    constructor(
        private _http: HttpClient,
        private _utilityService: UtilityService) {
    }

    /**
     * Inovoca el servicio rest usuarioLogin 
     * retorna un Json con la informacion del usuarioLogin
     * @param userName
     * @param userPass
     */
    getUsuarioSesion(userName: string, userPass: string): Observable<any> {
        return this._http.get(RESOURCES.find_usuario_login + "?userName=" + userName + "&userPass=" + userPass)
            .pipe(
            map(res => res),
            catchError(this._utilityService.handleErrorObservable("getUsuarioSesion"))
            );
    }

}
