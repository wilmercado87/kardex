import {Injectable} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable, throwError} from 'rxjs';
import {MESSAGES} from '../constants/messages';
import {ProductoVo} from '../model/producto-vo';

@Injectable()
export class UtilityService {

    constructor(private _router: Router, private route: ActivatedRoute) {}

    private isLogged(): boolean {
        if (typeof (Storage) !== MESSAGES.undefined) {
            if (sessionStorage.getItem(MESSAGES.session_param_usuario_login) !== null) {
                return true;
            }
        }

        return false;
    }

    public validateSesion(): boolean {
        return this.isLogged();
    }

    public logout() {
        sessionStorage.removeItem(MESSAGES.session_param_usuario_login);
        sessionStorage.removeItem(MESSAGES.session_param_usuario_ip);
        sessionStorage.removeItem(MESSAGES.session_param_productos);
        this._router.navigate([MESSAGES.nav_login]);
    }

    public requestParameterValue(param: string): any {
        let value: any;
        let sub = this.route.queryParams.subscribe(params => {
            value = params[param];
        });

        return {"value": value, "sub": sub};
    }

    public navigate(path: string, parameter: any) {
        this._router.navigate([path], {queryParams: {parameter: parameter}});
    }

    public navigatePathFromPrincipal(path: string, parameter: any) {
        this._router.navigate([MESSAGES.nav_principal, {outlets: {'router_contenido': [path]}}], {queryParams: {parameter: parameter}});
    }

    public navigatePath(path: string) {
        this._router.navigate([path]);
    }

    public handleErrorObservable<T>(result?: T) {
        return (error: any): Observable<T> => {
            console.error(error); // log to console instead
            return throwError(result as T);
        };
    }

    public generateArray(obj: any) {
        return Object.keys(obj).map((key) => {return obj[key]});
    }

    public validateBirthDate(birthDate: any): boolean {
        let today = new Date();
        today.setHours(0, 0, 0);
        today.setSeconds(0, 0);
        let day: number = this.getPartDate(birthDate, 0, "/");
        let month: number = this.getPartDate(birthDate, 1, "/");
        let year: number = this.getPartDate(birthDate, 2, "/");
        let fmtBirthDate: Date = new Date(year, month - 1, day);
        if (fmtBirthDate.getTime() > today.getTime()) {
            return true;
        } else {
            return false;
        }

    }

    public formatBirthDate(birthDate: any): Date {
        let day: number = this.getPartDate(birthDate, 0, "/");
        let month: number = this.getPartDate(birthDate, 1, "/");
        let year: number = this.getPartDate(birthDate, 2, "/");
        return new Date(year, month - 1, day);
    }

    public setTimeHHMMSSDate(date: string): Date {
        let resDate: Date = new Date();
        resDate.setHours(this.getPartDate(date, 0, ":"));
        resDate.setMinutes(this.getPartDate(date, 1, ":"));
        resDate.setSeconds(this.getPartDate(date, 2, ":"));
        return resDate;
    }

    public getPartDate(birthDate: any, posision: number, separator: string): number {
        return Number.parseInt(birthDate.toString().split(separator)[posision]);
    }

    public isValidNumber(value: number): boolean {
        return Number.isInteger(+value) && value >= 0 && value.toString().length > 0;
    }

    public isValidString(value: string): boolean {
        return value != null && value != "" && value != MESSAGES.undefined;
    }

    public isValidCollection(list: any[]): boolean {
        return list != null && list.length > 0;
    }

    public getProductoVo(pkProducto: number, productos: any[]): ProductoVo {
        let productoVo: ProductoVo = null;
        for (let item of productos) {
            if (pkProducto == item.pkProducto) {
                productoVo = new ProductoVo(item.pkProducto, item.nombre, item.stock, item.valorVentaUnidad);
                break;
            }
        }

        return productoVo;
    }
    
    public getProductoVoByNombre(nombre: string, productos: any[]): ProductoVo {
        let productoVo: ProductoVo = null;
        for (let item of productos) {
            if (nombre == item.nombre) {
                productoVo = new ProductoVo(item.pkProducto, item.nombre, item.stock, item.valorVentaUnidad);
                break;
            }
        }

        return productoVo;
    }

}
