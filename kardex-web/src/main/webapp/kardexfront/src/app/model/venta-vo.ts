import {UsuarioVo} from "./usuario-vo";

export class VentaVo {

    constructor(
        public pkVenta: number,
        public idCliente: string,
        public nombreCliente: string,
        public fecha: any,
        public valorTotal: any,
        public usuarioVo: UsuarioVo
    ) {

    }
}
