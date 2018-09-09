import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CalendarModule} from 'angular-calendar';
import {NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import localeEs from '@angular/common/locales/es';
import {HashLocationStrategy, LocationStrategy, CommonModule, registerLocaleData} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';

import {AccordionModule} from 'primeng/accordion';
import {DropdownModule} from 'primeng/dropdown';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ButtonModule} from 'primeng/button';
import {PanelMenuModule} from 'primeng/panelmenu';
import {MenuModule} from 'primeng/menu';
import {InputMaskModule} from 'primeng/inputmask';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {PrincipalComponent} from './principal/principal.component';
import {BaseComponent} from './base/base.component';
import {AuthGuardService as AuthGuard} from './services/auth-guard.service';
import {UtilityService} from './services/utility.service';
import { ProductoComponent } from './producto/producto.component';
import { PedidoComponent } from './pedido/pedido.component';
import { VentaComponent } from './venta/venta.component';

registerLocaleData(localeEs);

const appRoutes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {
        path: 'principal', component: PrincipalComponent, children: [
            {path: 'producto', component: ProductoComponent, outlet: 'router_contenido'},
            {path: 'pedido', component: PedidoComponent, outlet: 'router_contenido'},
            {path: 'venta', component: VentaComponent, outlet: 'router_contenido'}
        ], 
        canActivate:[AuthGuard],
        runGuardsAndResolvers:"always"

    },
    {path: '**', component: LoginComponent}
];

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        PrincipalComponent,
        BaseComponent,
        ProductoComponent,
        PedidoComponent,
        VentaComponent
    ],
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        FormsModule,
        RouterModule,
        AccordionModule,
        DropdownModule,
        MessagesModule,
        MessageModule,
        ButtonModule,
        PanelMenuModule,
        MenuModule,
        InputMaskModule,
        TableModule,
        DialogModule,
        NgbModalModule.forRoot(),
        CalendarModule.forRoot(),
        RouterModule.forRoot(appRoutes, {onSameUrlNavigation: "reload", useHash: true})
    ],
    exports: [RouterModule],
    providers: [AuthGuard, UtilityService, {provide: LocationStrategy, useClass: HashLocationStrategy}],
    bootstrap: [AppComponent]
})
export class AppModule {}
