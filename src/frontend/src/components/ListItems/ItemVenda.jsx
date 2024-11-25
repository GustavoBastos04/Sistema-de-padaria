import PropTypes from "prop-types";
import { format } from 'date-fns'

function ItemVenda(props){
    return (
        <tr>
            <td>{props.id_venda}</td>
            <td>{props.valor}</td>
            <td>{format(props.data_de_venda, 'dd/MM/yyyy')}</td>
        </tr>
    )
}

ItemVenda.propTypes = {
    id_venda: PropTypes.number.isRequired,
    valor: PropTypes.number.isRequired,
    data_de_venda: PropTypes.any.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemVenda;