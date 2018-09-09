import {ProductoVo} from "./producto-vo";
import {VentaVo} from "./venta-vo";

export class VentaDetalleVo {
    
    constructor(
        public pkVentaDetalle: number,
        public cantidad: number,
        public productoVo: ProductoVo,
        public ventaVo: VentaVo
    ) {

    }
}
