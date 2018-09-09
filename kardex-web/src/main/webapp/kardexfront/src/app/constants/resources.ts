import {MESSAGES} from '../constants/messages';

export const RESOURCES = {
    find_usuario_login: MESSAGES.contexto_app.concat("resources/usuarioLogin/find/usuarioLogin"),
    remove_all_session: MESSAGES.contexto_app.concat("resources/generic/remove/all/session"),
    find_all_list: MESSAGES.contexto_app.concat("resources/generic/find/all/list"),
    add_product: MESSAGES.contexto_app.concat("resources/producto/add/product"),
    get_product_by_name: MESSAGES.contexto_app.concat("resources/producto/get/productByName"),
    update_product: MESSAGES.contexto_app.concat("resources/producto/update/product"),
    add_venta: MESSAGES.contexto_app.concat("resources/venta/add/venta"),
    add_venta_detalle: MESSAGES.contexto_app.concat("resources/venta/add/ventaDetalle"),
    add_order: MESSAGES.contexto_app.concat("resources/order/add/order"),
    load_messages: "./assets/messages_",
    ext_json: ".json"
}
