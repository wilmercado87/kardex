import {ProductoVo} from "./producto-vo";

export class PedidoVo {
    
    constructor(public pkPedido: number,
        public fecha: any,
        public cantidad: number,
        public productoVo: ProductoVo){
        
    }
}
