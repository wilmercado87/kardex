import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {UsuarioVo} from '../model/usuario-vo';
import {MESSAGES} from '../constants/messages';
import {UtilityService} from "../services/utility.service";
import {GenericService} from "../services/generic.service";
import {UsuarioLoginService} from "../services/usuario-login.service";
import {BaseComponent} from "../base/base.component";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
    providers: [UsuarioLoginService, UtilityService, GenericService],
    encapsulation: ViewEncapsulation.None
})
export class LoginComponent extends BaseComponent implements OnInit, OnDestroy {
    private usuarioVo: UsuarioVo;
    private form: FormGroup;
    private loading: any;
    private tableLogin: any;
    private logout: boolean;
    private param: any;

    constructor(
        private _usuarioLoginService: UsuarioLoginService,
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        super(_genericService, _utilityService);
    }

    ngOnInit(): any {
        this.init();
        this.onClear();

        this.param = this._utilityService.requestParameterValue(MESSAGES.session_param_logout);
        this.logout = this.param.value;

        console.log("logout:" + this.logout);

        if (this.logout) {
            this._utilityService.logout();
            this.removeAllSession();
        }

        this.loading = <HTMLElement> document.querySelector(".loading");
        this.tableLogin = <HTMLElement> document.querySelector(".tablaGeneral");
        this.visibilityHiddenComponent(MESSAGES.style_hidden, MESSAGES.style_visible);
    }

    ngOnDestroy() {
        this.usuarioVo = new UsuarioVo(null, "", "");
    }

    private init() {
        this.msgs = [];
        this.usuarioVo = new UsuarioVo(null, "", "");
    }

    onLogin(form: FormGroup) {
        console.log("init onLogin");
        this.form = form;
        this.visibilityHiddenComponent(MESSAGES.style_visible, MESSAGES.style_hidden);
        this.onClear();
        this.serviceUsuarioLogin();
    }
    
    /**
     * Invoca al servicio serviceUsuarioLogin
     */
    private serviceUsuarioLogin() {
        this._usuarioLoginService.getUsuarioSesion(this.usuarioVo.nombreUsuario, this.usuarioVo.contrasena)
            .subscribe(
            result => {
                console.log("UserLogin Response estado:" + result.messageVo.exit + ",message:" + result.messageVo.message);

                this.messageVo = result.messageVo;

                if (this.messageVo.exit) {
                    this.usuarioVo = result.objectVo;
                    if (typeof (Storage) !== MESSAGES.undefined) {
                        sessionStorage.setItem(MESSAGES.session_param_usuario_login, JSON.stringify(this.usuarioVo));
                        sessionStorage.setItem(MESSAGES.session_param_usuario_ip, JSON.stringify(this.messageVo.data));
                    }
                    this._utilityService.navigatePath(MESSAGES.nav_principal);
                } else {
                    this.visibilityHiddenComponent(MESSAGES.style_hidden, MESSAGES.style_visible);
                    this.msgs.push({severity: 'error', summary: "", detail: this.resourceBundle.error_usuario_invalido});
                }

                this.form.reset();

            },
            error => {
                let errorMessage = <any> error;
                if (errorMessage !== null) {
                    console.log("errorMessage:" + errorMessage);
                    this.msgs.push({severity: 'error', summary: ' ', detail: this.resourceBundle.error_usuario_invalido});
                    this.visibilityHiddenComponent(MESSAGES.style_hidden, MESSAGES.style_visible);
                    this.form.reset();
                }
            }
            );
    }


    onClear() {
        this.msgs = [];
    }

    private visibilityHiddenComponent(loading: string, login: string) {
        this.loading.style.visibility = loading;
        this.tableLogin.style.visibility = login;
    }

}
