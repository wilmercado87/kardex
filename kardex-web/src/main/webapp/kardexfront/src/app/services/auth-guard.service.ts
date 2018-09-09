import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {UtilityService} from '../services/utility.service';

@Injectable()
export class AuthGuardService implements CanActivate {

    constructor(private _utilityService: UtilityService
    ) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        console.log("AuthGuardService canActivate");
        let url: string = state.url;
        let path = url.substring(url.indexOf(":") + 1, url.indexOf(")"));
        console.log('RouterStateSnapshot path:' + path);
        if (!this._utilityService.validateSesion()) {
            console.log("AuthGuardService session invalid");
            this._utilityService.logout();
            return false;
        }
        console.log("AuthGuardService session success");
        return true;
    }
}
