import {Component, OnInit, OnDestroy, ViewEncapsulation} from '@angular/core';
import {MenuItem} from 'primeng/components/common/api';
import {MESSAGES} from '../constants/messages';
import {UtilityService} from "../services/utility.service";
import {UsuarioVo} from '../model/usuario-vo';
import {GenericService} from "../services/generic.service";
import {BaseComponent} from "../base/base.component";

@Component({
    selector: 'app-principal',
    templateUrl: './principal.component.html',
    styleUrls: ['./principal.component.css'],
    providers: [UtilityService, GenericService],
    encapsulation: ViewEncapsulation.None
})
export class PrincipalComponent extends BaseComponent implements OnInit, OnDestroy {
    private usuarioVo: UsuarioVo;
    private usuarioIp: string;
    private currentDate: Date;
    private items: MenuItem[];

    constructor(
        protected _genericService: GenericService,
        protected _utilityService: UtilityService) {
        super(_genericService, _utilityService);
    }

    ngOnInit() {
        this.init();
    }

    init() {
        if (this._utilityService.validateSesion()) {
            console.log("The session is valid");
            this.currentDate = new Date();
            this.usuarioVo = JSON.parse(sessionStorage.getItem(MESSAGES.session_param_usuario_login));
            this.usuarioIp = JSON.parse(sessionStorage.getItem(MESSAGES.session_param_usuario_ip));
            console.log("usuarioLogin:" + this.usuarioVo);
            console.log("ip:" + this.usuarioIp);
            this.loadMenuPrincipal();
            return;
        }

        console.log("The session invalid");
        this.ngOnDestroy();
        this._utilityService.logout();
    }

    loadMenuPrincipal() {
        this.items = [];
        let itemSubMenu: MenuItem[] = [];
        itemSubMenu.push({label: 'Gestion Productos', icon: 'fa-mail-forward', routerLink: [MESSAGES.nav_principal, {outlets: {'router_contenido': 'producto'}}], styleClass: MESSAGES.textoFuente9});
        itemSubMenu.push({label: 'Gestion Pedidos', icon: 'fa-mail-forward', routerLink: [MESSAGES.nav_principal, {outlets: {'router_contenido': 'pedido'}}], styleClass: MESSAGES.textoFuente9});
        itemSubMenu.push({label: 'Gestion Ventas', icon: 'fa-mail-forward', routerLink: [MESSAGES.nav_principal, {outlets: {'router_contenido': 'venta'}}], styleClass: MESSAGES.textoFuente9});
        let itemMenu: MenuItem = {label: 'MENU OPCIONES', icon: '', items: itemSubMenu};
        itemMenu.styleClass = MESSAGES.textoFuente12Negrita;
        this.items.push(itemMenu);
    }

    ngOnDestroy() {
        this.usuarioVo = new UsuarioVo(null, "", "");
        this.usuarioIp = "";
        this.currentDate = null;
    }

}
